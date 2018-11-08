package lookAndFeel.buttons;

import lookAndFeel.buttons.NavButton;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DBConfigButton extends BaseButton implements MouseListener {

    private static int buttonSize = 16;

    public DBConfigButton(String text) {
        super(text);
        this.setProperties();
    }

    public DBConfigButton(String text, Icon icon) {
        super(text, icon);
        this.setProperties();
    }

    @Override
    public void setProperties() {
        super.setProperties();

        // We want our config buttons to be squares
        this.setSize(buttonSize, buttonSize);

        // No border
        this.setBorder(BorderFactory.createEmptyBorder());

        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        this.setBackground(scaleColor(backgroundColor, 10));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.setBackground(scaleColor(backgroundColor, -10));
    }

}
