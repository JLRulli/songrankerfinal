package dataLayer;

import java.security.spec.ECField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DB {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/songranker";
    static final String USER = "songranker";
    static final String PASS = "1qaz!QAZ";

    public boolean isArtist(String name) {

        boolean b = false;
        Connection connection = null;
        Statement statement = null;
        String s = "";
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();
            s = "SELECT * FROM entries WHERE artist = \"" + name + "\"";
            ResultSet resultSet = statement.executeQuery(s);
            if (resultSet.next()) {
                b = true;
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;

    }

    public HashMap<String, Integer> data (String artistName) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        Connection connection = null;
        Statement statement = null;
        String s = "";
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();
            s = "SELECT * FROM entries WHERE artist = \"" + artistName + "\"";
            ResultSet resultSet = statement.executeQuery(s);
            while (resultSet.next()) {
                if (!hashMap.containsValue(resultSet.getString("song"))) {
                    hashMap.put(resultSet.getString("song"), resultSet.getInt("number"));
                } else {
                    hashMap.put(resultSet.getString("song"), hashMap.get(resultSet.getString("song")) + resultSet.getInt("number"));
                }
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hashMap;
    }


}
