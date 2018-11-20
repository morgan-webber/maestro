package forms.CollectionView;

import lookAndFeel.MaestroLF;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CollectionViewButton extends JButton {

    private CollectionView parentPanel;

    public CollectionViewButton(CollectionView initParent){
        parentPanel = initParent;
        setBackground(MaestroLF.maestroCardBackground);
        setFocusPainted(false);
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }




}
