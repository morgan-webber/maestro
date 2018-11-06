package lookAndFeel.buttons;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class NavButton extends BaseButton implements MouseListener {



    public NavButton(String text) {
        super(text);
        setProperties();
    }

    public NavButton(String text, Icon icon) {
        super(text, icon);
        setProperties();
    }

    @Override
    public void setProperties(){
        super.setProperties();
        setButtonColor(backgroundColor);
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        setButtonColor(scaleColor(this.getBackground(), 10));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        setButtonColor(scaleColor(this.getBackground(), -10));
    }

    private void setButtonColor(Color color){
        this.setBackground(color);
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(),
                BorderFactory.createLineBorder(color, borderWeight * 20))
        );
    }

}