package forms.clients;

import forms.CollectionView.CollectionView;
import forms.DatabaseConnection;
import lookAndFeel.MaestroLF;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ClientsPanel {
    private JPanel panelMain;
    private JScrollPane panelMainScroll;
    private CollectionView clientsView;
    private DatabaseConnection dbc;

    public ClientsPanel(DatabaseConnection initdbc){
        this.dbc = initdbc;
    }

    public JPanel getPanelMain() { return panelMain; }

    private void createUIComponents() {
        panelMain = new JPanel();
        panelMain.setBorder(new LineBorder(MaestroLF.maestroMainBackground, 10));
        panelMain.setBackground(MaestroLF.maestroMainBackground);

        clientsView = new CollectionView(dbc, panelMain);

        panelMainScroll = new JScrollPane(clientsView, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panelMainScroll.setBorder(BorderFactory.createEmptyBorder());
        panelMainScroll.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        panelMainScroll.setWheelScrollingEnabled(true);
        panelMainScroll.getVerticalScrollBar().setUnitIncrement(10);
    }
}
