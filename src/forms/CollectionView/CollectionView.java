package forms.CollectionView;

import lookAndFeel.MaestroLF;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CollectionView extends JPanel {

    // struct to represent client info
    private class ClientInfo {

    }

    // Source collection we will use to display our buttons
    private ArrayList<ClientInfo> clientCollection = new ArrayList<>();

    // Ref to our layout
    GridLayout layout;

    /**
     * Default ctor
     */
    public CollectionView(){
        // We'll use a grid layout
        layout = new GridLayout(0, 3);
        layout.setVgap(10);
        layout.setHgap(10);
        this.setLayout(layout);

        this.setBackground(MaestroLF.maestroMainBackground);

        // testing
        for (int i = 0; i < 10; i++){
            clientCollection.add(new ClientInfo());
        }
        refreshView();
    }

    /**
     * refreshView
     *
     * Does all the things required to update the view
     */
    public void refreshView(){
        // remove all the buttons first
        this.removeAll();

        // add a CollectionViewButton for each client info and set properties accordingly
        for (ClientInfo info : clientCollection){
            CollectionViewButton button = new CollectionViewButton(this);

            // We want to fill our panel according to column restrictions
            Dimension dim = new Dimension(200, 200);
            button.setPreferredSize(dim);



            this.add(button);
        }
    }



}
