package forms.CollectionView;

import forms.clients.ClientInfo;

import java.awt.event.MouseEvent;

public class CollectionViewAddButton extends CollectionViewButton{
    public CollectionViewAddButton(CollectionView initParent) {
        super(initParent);
    }

    @Override
    public void mouseReleased(MouseEvent e){
        super.mouseReleased(e);
        parentPanel.getClientCollection().add(new ClientInfo());
        parentPanel.refreshView();
    }
}
