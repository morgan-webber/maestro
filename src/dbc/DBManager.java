package dbc;

import forms.DatabaseConnection;
import javax.crypto.Cipher;
import java.io.*;
import java.util.Properties;


/**
 * Database Manager
 *
 * Responsible for detecting and rectifying the database as well as saving/retrieving db info
 * from configs
 */
public class DBManager {

    private DatabaseConnection dbc;



    public DBManager(DatabaseConnection initDbc){
        dbc = initDbc;
    }



}
