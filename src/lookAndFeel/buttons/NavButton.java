package lookAndFeel.buttons;

import lookAndFeel.MaestroLF;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class NavButton extends BaseButton {

    private ImageIcon baseImage, selectedImage = null;

    public NavButton(ImageIcon initImage, ImageIcon initSelectedImage) {
        super("", initImage);

        // Set our images
        baseImage = initImage;
        selectedImage = initSelectedImage;
        setBackground(MaestroLF.maestroMainBackground);

        // Gotta set the button border to make it just a bit bigger
        setBorder(BorderFactory.createLineBorder(getBackground(), 15));

        setProperties();

    }

    @Override
    public void setBackground(Color color){
        super.setBackground(color);
        setBorder(BorderFactory.createLineBorder(getBackground(), 15));
    }

    @Override
    public void setProperties(){
        this.setSelected(false);
        super.setProperties();
    }

    public void setIsSelected(Boolean isSelected) {
        if (isSelected) {
            this.setIcon(selectedImage);
        } else {
            this.setIcon(baseImage);
        }
    }

}