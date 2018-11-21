package forms.CollectionView;

import forms.buttons.BaseButton;
import lookAndFeel.MaestroLF;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CollectionViewButton extends BaseButton implements MouseListener {

    protected CollectionView parentPanel;

    public static int buttonSize = 150;

    public CollectionViewButton(CollectionView initParent){
        super("");
        parentPanel = initParent;
        setBackground(MaestroLF.maestroCardBackground);
        setFont(getFont().deriveFont(30f));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setPreferredSize(new Dimension(buttonSize, buttonSize));
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
