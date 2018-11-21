package forms;

import dbc.StatusChecker;
import forms.clients.ClientsPanel;
import lookAndFeel.MaestroLF;
import forms.buttons.DBConfigButton;
import lookAndFeel.FrameMovementManager;
import forms.buttons.NavButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppFrame implements ActionListener {
    private JFrame parentFrame;

    private JLabel lblLogoText;

    private JPanel panelMaestro;
    private JPanel panelContent;
    private JPanel panelNav;
    private RailNavigator railNav;

    private JButton btnMinimize;
    private JButton btnExit;
    private JButton btnMaximize;
    private JButton btnTickets;
    private JButton btnHome;
    private JButton btnClients;
    private JButton btnDBConfig;
    private JPanel panelTitle;
    private JPanel panelMain;

    // Our database connection
    DatabaseConnection dbc;

    // Thread to check status of various needed components
    private StatusChecker statusChecker;

    /**
     * Default ctor
     */
    public AppFrame() {

        // Populate rail navigator
        ImageIcon iconHome = new ImageIcon("res/buttons/home/home32.png");
        ImageIcon iconHomeSel = new ImageIcon("res/buttons/home/home32_sel.png");
        ImageIcon iconTickets = new ImageIcon("res/buttons/tickets/tickets32.png");
        ImageIcon iconTicketsSel = new ImageIcon("res/buttons/tickets/tickets32_sel.png");
        ImageIcon iconClients = new ImageIcon("res/buttons/clients/clients32.png");
        ImageIcon iconClientsSel = new ImageIcon("res/buttons/clients/clients32_sel.png");
        ImageIcon iconSettings = new ImageIcon("res/buttons/settings/settings32.png");
        ImageIcon iconSettingsSel = new ImageIcon("res/buttons/settings/settings32_sel.png");

        NavButton btnHome = new NavButton(iconHome, iconHomeSel);
        NavButton btnTickets = new NavButton(iconTickets, iconTicketsSel);
        NavButton btnClients = new NavButton(iconClients, iconClientsSel);
        NavButton btnSettings = new NavButton(iconSettings, iconSettingsSel);

        // Create db connection
        dbc = new DatabaseConnection();

        // Create content panels
        ClientsPanel clientsPanel = new ClientsPanel(dbc);


        // Create our rail navigation panel
        railNav = new RailNavigator(panelContent);
        railNav.addItem(btnHome, null);
        railNav.addItem(btnTickets, null);
        railNav.addItem(btnClients, clientsPanel.getPanelMain());
        railNav.addItem(btnSettings, null);
        panelNav.add(railNav);

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


        btnDBConfig.addActionListener(this);
        btnDBConfig.setBackground(MaestroLF.maestroMainBackground);

        // Kick off our status checker
        statusChecker = new StatusChecker(5000);
        statusChecker.setDbConn(dbc, btnDBConfig);
        statusChecker.start();

        // Set panel colors
        panelContent.setBackground(MaestroLF.maestroMainBackground);
        panelMaestro.setBackground(MaestroLF.maestroMainBackground);
        panelMain.setBackground(MaestroLF.maestroMainBackground);
        panelNav.setBackground(MaestroLF.maestroMainBackground);
        panelTitle.setBackground(MaestroLF.maestroMainBackground);
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
        parentFrame.setContentPane(getPanelContent());

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

    public JPanel getPanelContent(){
        return panelMaestro;
    }

    private void createUIComponents() {

        btnDBConfig = new DBConfigButton("", new ImageIcon(MaestroLF.dbImage));

        // Set fonts
        lblLogoText = new JLabel("MAESTRO");
        lblLogoText.setFont(MaestroLF.robotoFontBold.deriveFont(20f));

        panelNav = new JPanel();

        panelContent = new JPanel();
        panelContent.setLayout(new GridLayout(1,1));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDBConfig){
            dbc.toggleVisible();
        }
    }
}


