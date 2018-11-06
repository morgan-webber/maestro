package dbc;

import forms.DatabaseConnection;
import lookAndFeel.MaestroLF;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatusChecker extends Thread {

    // Pair for the database connection
    DatabaseConnection dbConn;
    JButton btnDBConn;

    // Interval that we check statuses in milliseconds
    private int interval = 1000;

    public StatusChecker(int interval){
        super();
        this.interval = interval;
    }


    public void setDbConn(DatabaseConnection db, JButton btn){
        dbConn = db;
        btnDBConn = btn;
    }

    public void testDBConnection(){
        boolean isDBUp = true;
        Connection conn = dbConn.getConnection();
        try {
            if (conn == null || ! conn.isValid(1000)){
                isDBUp = false;
            }
        } catch (SQLException e) {
            isDBUp = false;
        }
        if (isDBUp){
            btnDBConn.setIcon(new ImageIcon(MaestroLF.dbImage));
        }
        else{
            btnDBConn.setIcon(new ImageIcon(MaestroLF.dbErrorImage));
        }
    }

    public void run(){

        while(true){

            // Check our database connection
            testDBConnection();

            try{
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }

}
