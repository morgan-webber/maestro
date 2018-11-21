package forms.CollectionView;

import dbc.ClientsTableParser;
import forms.DatabaseConnection;
import forms.clients.ClientInfo;
import lookAndFeel.MaestroLF;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CollectionView extends JPanel {

    private DatabaseConnection dbc;

    private JPanel parentPanel;

    // Source collection we will use to display our buttons
    private ArrayList<ClientInfo> clientCollection = new ArrayList<>();

    // Ref to our layout
    MigLayout layout;

    /**
     * Default ctor
     */
    public CollectionView(DatabaseConnection initdbc, JPanel parent){
        this.dbc = initdbc;
        this.parentPanel = parent;

        // We'll use a grid layout
        layout = new MigLayout("wrap 3");
        this.setLayout(layout);

        this.setBackground(MaestroLF.maestroMainBackground);

        // testing
        //for (int i = 0; i < 6; i++){
        //    clientCollection.add(new ClientInfo());
        //}
        //refreshView();

        // Kick off our updater thread
        Thread updater = new Thread(new Runnable() {

            @Override
            public void run() {

                while (true) {
                    try {
                        // grab all clients
                        ResultSet rs = dbc.doQuery("select * from clients;");
                        ArrayList<ClientInfo> info = ClientsTableParser.parseResultSet(rs);

                        // copy results to our collection
                        //clientCollection.clear();
                        clientCollection.addAll(info);

                        // refresh our view
                        refreshView();

                        // go to sleep for a bit
                        Thread.sleep(1000);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(updater, 0, 1, TimeUnit.SECONDS);
    }

    /**
     * refreshView
     *
     * Does all the things required to update the view
     */
    public void refreshView(){
        // remove all the buttons first
        this.removeAll();

        // Adjust our layout
        int wrap = parentPanel.getWidth() / CollectionViewButton.buttonSize;
        layout = new MigLayout("wrap " + wrap);
        this.setLayout(layout);

        // add a CollectionViewButton for each client info and set properties accordingly
        for (ClientInfo info : clientCollection){
            CollectionViewButton button = new CollectionViewButton(this);
            this.add(button);
        }


        // Add a special button that will be the 'add client' button
        CollectionViewButton addButton = new CollectionViewButton(this);
        addButton.setForeground(MaestroLF.maestroWhite);
        addButton.setText("+");
        this.add(addButton);

        parentPanel.revalidate();
        parentPanel.repaint();

        this.revalidate();
        this.repaint();
    }



}
