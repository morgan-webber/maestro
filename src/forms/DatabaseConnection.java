package forms;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import dbc.DBInfo;
import dbc.DBManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ConnectException;
import java.sql.*;
import java.util.Properties;

public class DatabaseConnection implements ActionListener {

    // Form Vars
    private JButton btnConnect;
    private JTextField txtServer;
    private JPanel paneLabels;
    private JPanel paneText;
    private JLabel lblServer;
    private JLabel lblUser;
    private JTextField txtUser;
    private JPasswordField txtPassword;
    private JLabel lblPassword;
    private JTextField txtPort;
    private JLabel lblColon;
    private JPanel mainForm;
    private JFrame optionFrame;

    // DBC Vars
    private Connection sqlConn = null;
    private DBManager dbMan = null;
    private DBInfo dbInfo = null;
    private Properties dbProps = null;

    public DatabaseConnection(){
        btnConnect.addActionListener(this);
        dbMan = new DBManager(this);

        // Read in our DB info
        dbInfo = new DBInfo();
        dbInfo.readConfig();

        if (dbInfo != null) {
            txtServer.setText(dbInfo.server);
            txtUser.setText(dbInfo.user);
            txtPassword.setText(dbInfo.pass);
            txtPort.setText(String.valueOf(dbInfo.port));

            // Try connecting
            try {
                connectToDB();
            }
            catch (CommunicationsException e){
                // This is a possible expected error, do not present a message to them
            }
            catch (SQLException e) {
                JOptionPane.showMessageDialog(optionFrame, e.getMessage());
            }
        }
    }

    private void createUIComponents() {
        txtServer = new JTextField("");
        txtUser = new JTextField("");
        txtPassword = new JPasswordField("");
    }

    /**
     * Connects to the database
     * @return the Connection object representing the SQL Connection, or null if a connection could not be made
     */
    private Connection connectToDB() throws SQLException{

        if (dbInfo != null) {
            sqlConn = DriverManager.getConnection("jdbc:mysql://" + dbInfo.server + ":" + dbInfo.port,
                    dbInfo.user, dbInfo.pass);

            // connect to maestro db
            doQuery("use maestro;");

            // Connection successful
            dbInfo.saveConfig();
            return sqlConn;
        }
        return null;

    }

    public Connection getConnection(){ return sqlConn; }

    public ResultSet doQuery(String query){

        try {
            if (sqlConn == null){
                return null;
            }

            if (sqlConn.isClosed()){
                connectToDB();
            }

            Statement statement = sqlConn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            return rs;

        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    public void closeConnection() throws SQLException{
        sqlConn.close();
    }

    public boolean isAlive() throws SQLException {
        return sqlConn.isValid(1000);
    }

    /**
     * Shows the form
     */
    public void showOptions(){

        // Create our JFrame if we need to
        if (optionFrame == null) {
            optionFrame = new JFrame("Database Options");
            optionFrame.setContentPane(mainForm);
            optionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            optionFrame.pack();
        }

        // Show it
        optionFrame.setVisible(true);
    }

    /**
     * Hides the form
     */
    public void hideOptions(){
        optionFrame.setVisible(false);
    }

    public void toggleVisible(){
        if (optionFrame == null || !optionFrame.isVisible()){
            showOptions();
        }
        else{
            hideOptions();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnConnect) {
            try {

                dbInfo = new DBInfo(txtServer.getText(), txtUser.getText(), String.valueOf(txtPassword.getPassword()),
                        Integer.valueOf(txtPort.getText()));

                this.connectToDB();

                // If we succeed we can display a message and close ourselves
                hideOptions();
                JOptionPane.showMessageDialog(optionFrame.getParent(), "Connection successful!");
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(optionFrame, sqle.getMessage());
            }
        }
    }

    public DBInfo getDbInfo() {
        return dbInfo;
    }
}
