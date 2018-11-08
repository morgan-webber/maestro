package dbc;

// Struct to hold our database info
public class DBInfo {
    public String server, user, pass;
    public int port;

    public DBInfo (String initServer, String initUser, String initPass, int initPort){
        this.server = initServer;
        this.user = initUser;
        this.pass = initPass;
        this.port = initPort;
    }
}
