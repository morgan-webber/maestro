package forms;

import lookAndFeel.MaestroLF;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class ClientsPanel {
    private JPanel panelMain;
    private JComboBox comboClientSelect;
    private JButton btnAddClient;
    private JLabel lblClientName;

    public JPanel getPanelMain() { return panelMain; }

    private void createUIComponents() {
        panelMain = new JPanel();
        panelMain.setBorder(new LineBorder(MaestroLF.maestroCardBackground, 10));
        panelMain.setBackground(MaestroLF.maestroCardBackground);

        lblClientName = new JLabel();
        lblClientName.setForeground(MaestroLF.maestroWhite);
    }
}
