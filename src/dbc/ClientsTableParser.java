package dbc;

import forms.clients.ClientInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientsTableParser {

    public static ArrayList<ClientInfo> parseResultSet(ResultSet rs) throws SQLException {
        ArrayList<ClientInfo> results = new ArrayList<>();

        while (rs != null && rs.next()) {
            ClientInfo info = new ClientInfo();
            info.name = rs.getString("name");
            info.primaryPhone = rs.getString("primaryPhone");
            info.address = rs.getString("address");
            info.city = rs.getString("city");
            info.state = rs.getString("state");
            info.zip = rs.getString("zip");
            info.website = rs.getString("website");
            info.referredBy = rs.getString("referred_by");

            results.add(info);
        }

        return results;
    }

}
