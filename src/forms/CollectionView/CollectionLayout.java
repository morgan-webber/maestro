package forms.CollectionView;

import java.awt.*;

public class CollectionLayout extends GridLayout {
    private int columns, rows;

    public CollectionLayout(int rows, int cols){
        super(rows, cols);
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
