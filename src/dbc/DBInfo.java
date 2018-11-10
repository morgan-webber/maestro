package dbc;

import java.io.*;
import java.util.Properties;

/**
 * Contains all the information required to setup a MySQL connection. Is also capable of saving
 */
public class DBInfo {

    // DB Connection info
    public String server, user, pass;
    public int port;

    private String strDBConfigFile = "etc/sql.properties";

    public DBInfo(){
        this("", "", "", -1);
    }

    public DBInfo (String initServer, String initUser, String initPass, int initPort){
        this.server = initServer;
        this.user = initUser;
        this.pass = initPass;
        this.port = initPort;
    }

    /**
     * Saves the current configuration
     */
    public void saveConfig(){

        // Create a properties object for easy file dump
        Properties dbProps = new Properties();
        dbProps.put("server", this.server);
        dbProps.put("user", this.user);
        dbProps.put("pass", this.pass);
        dbProps.put("port", String.valueOf(this.port));

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

    /**
     * Loads the saved configuration
     */
    public void readConfig(){

        try {

            // Read saved props file
            File configFile = new File(strDBConfigFile);
            FileInputStream fis = new FileInputStream(configFile);

            Properties dbProps = new Properties();
            dbProps.load(fis);
            fis.close();

            // Read our info into DBInfo var
            this.server = String.valueOf(dbProps.get("server"));
            this.user = String.valueOf(dbProps.get("user"));
            this.pass = String.valueOf(dbProps.get("pass"));
            this.port = Integer.valueOf(String.valueOf(dbProps.get("port")));

        } catch (FileNotFoundException e) {
            // Do nothing, there isn't a file to read
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setConfigFile(String strDBConfigFile) {
        this.strDBConfigFile = strDBConfigFile;
    }
}
