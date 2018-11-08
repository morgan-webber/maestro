package forms;

import dbc.StatusChecker;
import lookAndFeel.MaestroLF;
import lookAndFeel.buttons.DBConfigButton;
import lookAndFeel.FrameMovementManager;
import lookAndFeel.buttons.NavButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppFrame implements ActionListener {
    private JFrame parentFrame;

    private JLabel lblLogoText;

    private JPanel panelMain;
    private JPanel mainContentPane;
    private JPanel navPane;

    private JButton btnMinimize;
    private JButton btnExit;
    private JButton btnMaximize;
    private JButton btnTickets;
    private JButton btnHome;
    private JButton btnClients;
    private JButton btnDBConfig;

    // Our database connection
    DatabaseConnection dbc;

    // Thread to check status of various needed components
    private StatusChecker statusChecker;

    /**
     * Default ctor
     */
    public AppFrame() {
        // Minimize button listeners
        btnMinimize.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                parentFrame.setState(JFrame.ICONIFIED);
            }
        });

        // Maximize button listeners
        btnMaximize.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                parentFrame.setState(JFrame.MAXIMIZED_BOTH);
            }
        });

        // Exit button listeners
        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                parentFrame.dispose();
            }
        });

        //Logo stuff
        lblLogoText.setForeground(new Color(255, 255, 255));

        dbc = new DatabaseConnection();
        btnDBConfig.addActionListener(this);
        btnDBConfig.setBackground(MaestroLF.defaultBackground);

        // Kick off our status checker
        statusChecker = new StatusChecker(5000);
        statusChecker.setDbConn(dbc, btnDBConfig);
        statusChecker.start();
    }

    /**
     * Ctor that also assigns our parent frame
     * @param parent the JFrame object on which this form will reside
     */
    public AppFrame(JFrame parent){
        this();

        moveToFrame(parent);
    }

    public void moveToFrame(JFrame frame){
        parentFrame = frame;
        parentFrame.setContentPane(getContentPane());

        FrameMovementManager fmm = new FrameMovementManager(parentFrame);
        parentFrame.addMouseListener(fmm);
        parentFrame.addMouseMotionListener(fmm);

        parentFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                System.exit(0);
            }
        });
    }

    public JPanel getContentPane(){
        return panelMain;
    }

    private void createUIComponents() {

        // Create our custom buttons
        btnHome = new NavButton("Home");
        btnTickets = new NavButton("Tickets");
        btnClients = new NavButton("Clients");
        btnDBConfig = new DBConfigButton("", new ImageIcon(MaestroLF.dbImage));

        // Set fonts
        lblLogoText = new JLabel("Maestro");
        lblLogoText.setFont(MaestroLF.maestroFont.deriveFont(20f));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDBConfig){
            dbc.toggleVisible();
        }
        if (e.getSource() == btnHome){

        }
        if (e.getSource() == btnTickets){

        }
        if (e.getSource() == btnClients){

        }
    }
}


