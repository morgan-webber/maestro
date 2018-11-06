package lookAndFeel.buttons;

import lookAndFeel.MaestroLF;

import javax.swing.*;
import java.awt.*;

public abstract class BaseButton extends JButton {

    // Slightly lighter than the background color
    protected Color backgroundColor = MaestroLF.nordicOrange;

    // Border stuff
    protected static int borderWeight = 1; // px


    public BaseButton(String text) {
        super(text);
        setProperties();
    }

    public BaseButton(String text, Icon icon) {
        super(text, icon);
        setProperties();
    }

    public void setProperties(){
        this.setFont(MaestroLF.maestroFont.deriveFont(14f));
        setContentAreaFilled(false);
        setOpaque(true);
        setFocusPainted(false);
        setForeground(Color.WHITE);
        setBackground(backgroundColor);
    }

    protected Color scaleColor(Color color, int scale){
        Color oldColor = this.getBackground();
        return new Color(oldColor.getRed() + scale, oldColor.getGreen() + scale, oldColor.getBlue() + scale);
    }

    @Override
    public void setBackground(Color bg){
        super.setBackground(bg);

        backgroundColor = bg;
    }

}
