package dataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class DB {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    String DB_Url = System.getProperty("JDBC_CONNECTION_STRING");
    String DB_User = System.getProperty("JDBC_USER");
    String DB_Password = System.getProperty("JDBC_PASSWORD");
    String DB_Connection_String = DB_Url + "?user=" + DB_User + "&password=" + DB_Password;

    public boolean isArtist(String name) {

        boolean b = false;
        Connection connection = null;
        Statement statement = null;
        String s = "";
        try {
            Class.forName(JDBC_DRIVER);
            //connection = DriverManager.getConnection(DB_URL, USER, PASS);

            connection = DriverManager.getConnection(DB_Connection_String);

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
            //connection = DriverManager.getConnection(DB_URL, USER, PASS);

            connection = DriverManager.getConnection(DB_Connection_String);
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

    public void update(String name, String n1, String n2, String n3, String n4, String n5) {

        HashMap<String, Integer> hashMap = new HashMap<>();
        Connection connection = null;
        Statement statement = null;
        String s = "";
        int i = 0;
        //5
        boolean b = false;
        if (n1 != "") {
            try {
                Class.forName(JDBC_DRIVER);
                //connection = DriverManager.getConnection(DB_URL, USER, PASS);

                connection = DriverManager.getConnection(DB_Connection_String);
                statement = connection.createStatement();
                s = "SELECT * FROM entries WHERE artist = \"" + name + "\" AND song = \"" + n1 + "\"";
                ResultSet resultSet = statement.executeQuery(s);
                if (resultSet.next()) {
                    b = true;
                    i = resultSet.getInt("number") + 5;
                    System.out.println("TRUE");
                }
                //exists
                if (b) {
                    System.out.println("update");
                    s = "UPDATE entries SET number = " + i + " WHERE song = \"" + n1 + "\"";
                    statement.executeUpdate(s);
                } else {
                    System.out.println("add");
                    s = "INSERT INTO entries (artist, song, number) VALUES ( '" + name + "' , '" + n1 + "' , 5 )";
                    statement.executeUpdate(s);
                }
                //resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //4
        b = false;
        if (n2 != "") {
            try {
                Class.forName(JDBC_DRIVER);
                //connection = DriverManager.getConnection(DB_URL, USER, PASS);

                connection = DriverManager.getConnection(DB_Connection_String);
                statement = connection.createStatement();
                s = "SELECT * FROM entries WHERE artist = \"" + name + "\" AND song = \"" + n2 + "\"";
                ResultSet resultSet = statement.executeQuery(s);
                if (resultSet.next()) {
                    b = true;
                    i = resultSet.getInt("number") + 4;
                    System.out.println("TRUE");
                }
                //exists
                if (b) {
                    System.out.println("update");
                    s = "UPDATE entries SET number = " + i + " WHERE song = \"" + n2 + "\"";
                    statement.executeUpdate(s);
                } else {
                    System.out.println("add");
                    s = "INSERT INTO entries (artist, song, number) VALUES ( '" + name + "' , '" + n2 + "' , 4 )";
                    statement.executeUpdate(s);
                }
                //resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //3
        b = false;
        if (n3 != "") {
            try {
                Class.forName(JDBC_DRIVER);
                //connection = DriverManager.getConnection(DB_URL, USER, PASS);

                connection = DriverManager.getConnection(DB_Connection_String);
                statement = connection.createStatement();
                s = "SELECT * FROM entries WHERE artist = \"" + name + "\" AND song = \"" + n3 + "\"";
                ResultSet resultSet = statement.executeQuery(s);
                if (resultSet.next()) {
                    b = true;
                    i = resultSet.getInt("number") + 3;
                    System.out.println("TRUE");
                }
                //exists
                if (b) {
                    System.out.println("update");
                    s = "UPDATE entries SET number = " + i + " WHERE song = \"" + n3 + "\"";
                    statement.executeUpdate(s);
                } else {
                    System.out.println("add");
                    s = "INSERT INTO entries (artist, song, number) VALUES ( '" + name + "' , '" + n3 + "' , 3 )";
                    statement.executeUpdate(s);
                }
                //resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //2
        b = false;
        if (n4 != "") {
            try {
                Class.forName(JDBC_DRIVER);
                //connection = DriverManager.getConnection(DB_URL, USER, PASS);

                connection = DriverManager.getConnection(DB_Connection_String);
                statement = connection.createStatement();
                s = "SELECT * FROM entries WHERE artist = \"" + name + "\" AND song = \"" + n4 + "\"";
                ResultSet resultSet = statement.executeQuery(s);
                if (resultSet.next()) {
                    b = true;
                    i = resultSet.getInt("number") + 2;
                    System.out.println("TRUE");
                }
                //exists
                if (b) {
                    System.out.println("update");
                    s = "UPDATE entries SET number = " + i + " WHERE song = \"" + n4 + "\"";
                    statement.executeUpdate(s);
                } else {
                    System.out.println("add");
                    s = "INSERT INTO entries (artist, song, number) VALUES ( '" + name + "' , '" + n4 + "' , 2 )";
                    statement.executeUpdate(s);
                }
                //resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //1
        b = false;
        if (n5 != "") {
            try {
                Class.forName(JDBC_DRIVER);
                //connection = DriverManager.getConnection(DB_URL, USER, PASS);

                connection = DriverManager.getConnection(DB_Connection_String);
                statement = connection.createStatement();
                s = "SELECT * FROM entries WHERE artist = \"" + name + "\" AND song = \"" + n5 + "\"";
                ResultSet resultSet = statement.executeQuery(s);
                if (resultSet.next()) {
                    b = true;
                    i = resultSet.getInt("number") + 1;
                    System.out.println("TRUE");
                }
                //exists
                if (b) {
                    System.out.println("update");
                    s = "UPDATE entries SET number = " + i + " WHERE song = \"" + n5 + "\"";
                    statement.executeUpdate(s);
                } else {
                    System.out.println("add");
                    s = "INSERT INTO entries (artist, song, number) VALUES ( '" + name + "' , '" + n5 + "' , 1 )";
                    statement.executeUpdate(s);
                }
                //resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

}
