package forms;

import forms.CollectionView.CollectionView;
import lookAndFeel.MaestroLF;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ClientsPanel {
    private JPanel panelMain;
    private JScrollPane panelMainScroll;
    private CollectionView clientsView;

    public JPanel getPanelMain() { return panelMain; }

    private void createUIComponents() {
        panelMain = new JPanel();
        panelMain.setBorder(new LineBorder(MaestroLF.maestroMainBackground, 10));
        panelMain.setBackground(MaestroLF.maestroMainBackground);

        clientsView = new CollectionView();

        panelMainScroll = new JScrollPane(clientsView, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panelMainScroll.setBorder(BorderFactory.createEmptyBorder());
        panelMainScroll.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        panelMainScroll.setWheelScrollingEnabled(true);
        panelMainScroll.getVerticalScrollBar().setUnitIncrement(10);
    }
}
