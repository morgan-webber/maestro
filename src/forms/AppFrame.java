package forms;

import lookAndFeel.FrameMovementManager;
import org.jdesktop.swingx.border.DropShadowBorder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class AppFrame {
    private JFrame parentFrame;
    private JLabel lblLogoText;
    private JPanel panelMain;
    private JButton btnMinimize;
    private JButton btnExit;
    private JButton btnMaximize;
    private JPanel mainContentPane;
    private JPanel navPane;
    private JButton btnTickets;
    private JButton btnHome;

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
    }

    public JPanel getContentPane(){
        return panelMain;
    }

    private void createUIComponents() {

        
    }
}


