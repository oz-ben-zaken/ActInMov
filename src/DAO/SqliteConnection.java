package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqliteConnection {
    private Connection con = null;
    private Statement stm = null;


    public SqliteConnection() {}

    public Statement getStm() {
        try {
            stm = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.stm;
    }

    public Connection getCon(String url) {
        try {
            Class.forName("org.sqlite.JDBC");
            this.con = DriverManager.getConnection("jdbc:sqlite:"+url);
            System.out.println("\nConnected to the database successfully.\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.con;
    }
}
