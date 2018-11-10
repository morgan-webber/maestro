package forms;

import lookAndFeel.MaestroLF;
import lookAndFeel.buttons.NavButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

public class RailNavigator extends JPanel implements ActionListener, MouseListener {

    private JPanel destinationPane = null;
    private HashMap<NavButton, JPanel> navigationItems = new HashMap<>();
    private NavButton currentSelection = null;
    private GridLayout gridLayout;


    public RailNavigator(JPanel initDestPane){
        super();

        this.setBackground(MaestroLF.maestroMainBackground);

        destinationPane = initDestPane;

        // We'll use a columnar layout
        gridLayout = new GridLayout(4, 1);
        gridLayout.setVgap(15);
        setLayout(gridLayout);
    }

    public void addItem(NavButton button, JPanel panel){
        // Set us as the listener for the button
        button.addActionListener(this);
        button.addMouseListener(this);

        navigationItems.put(button, panel);

        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            // We should be just handling cases where the event is a NavButton
            NavButton selectedButton = (NavButton)e.getSource();

            // Select this one and deselect the last one
            selectedButton.setIsSelected(true);
            for (NavButton btn : navigationItems.keySet()){
                if (btn != selectedButton){
                    btn.setIsSelected(false);
                }
            }
        }
        catch (Exception ex){
            // meh
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }
    public void mousePressed(MouseEvent e) {
        try{
            // We should be just handling cases where the event is a NavButton
            NavButton selectedButton = (NavButton)e.getSource();

            // Select this one and deselect the last one
            currentSelection.setSelected(false);
            selectedButton.setSelected(true);
            currentSelection = selectedButton;
        }
        catch (Exception ex){
            // meh
        }
    }
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {
        try{
            // We should be just handling cases where the event is a NavButton
            NavButton selectedButton = (NavButton)e.getSource();

            // Set background color
            selectedButton.setBackground(MaestroLF.maestroCardBackground);
        }
        catch (Exception ex){
            // meh
        }
    }
    public void mouseExited(MouseEvent e) {
        try{
            // We should be just handling cases where the event is a NavButton
            NavButton selectedButton = (NavButton)e.getSource();

            selectedButton.setBackground(MaestroLF.maestroMainBackground);
        }
        catch (Exception ex){
            // meh
        }
    }
}
