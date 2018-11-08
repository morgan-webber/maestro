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
public class DatabaseManager {

    private DatabaseConnection dbc;
    private String strDBConfigFile = "etc/sql.properties";


    public DatabaseManager(DatabaseConnection initDbc){
        dbc = initDbc;
    }

    public void saveConfig(){
        Properties dbProps = new Properties();
        DBInfo dbInfo = dbc.getDbInfo();
        dbProps.put("server", dbInfo.server);
        dbProps.put("user", dbInfo.user);
        dbProps.put("pass", dbInfo.pass);
        dbProps.put("port", String.valueOf(dbInfo.port));


        // Save our file
        try{
            File configFile = new File(strDBConfigFile);
            FileOutputStream fos = new FileOutputStream(configFile);
            dbProps.store(fos, "");
            fos.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public DBInfo readConfig(){

        try {
            File configFile = new File(strDBConfigFile);
            FileInputStream fis = new FileInputStream(configFile);

            Properties dbProps = new Properties();
            dbProps.load(fis);
            fis.close();

            // Read our info into DBInfo var
            DBInfo dbInfo = new DBInfo("", "", "", 0);
            dbInfo.server = String.valueOf(dbProps.get("server"));
            dbInfo.user = String.valueOf(dbProps.get("user"));
            dbInfo.pass = String.valueOf(dbProps.get("pass"));
            dbInfo.port = Integer.valueOf(String.valueOf(dbProps.get("port")));

            return dbInfo;

        } catch (FileNotFoundException e) {
            // Do nothing, there isn't a file to read
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
