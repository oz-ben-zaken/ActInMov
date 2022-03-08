package DAO;

import POJO.ActorPOJO;
import POJO.MoviePOJO;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ActorDAO {
    List<ActorPOJO> actors = new ArrayList<>();
    String url = "C:\\databasesss\\ActMovRel.db";
    SqliteConnection sqlCon = new SqliteConnection();
    Connection con = sqlCon.getCon(url);
    Statement stm = sqlCon.getStm();

    public List<ActorPOJO> getActors() {
        try {
            var rs = stm.executeQuery("SELECT * FROM Actors");
            while (rs.next())
                actors.add(new ActorPOJO(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("birthDate"),
                        rs.getString("firstMovie"),
                        rs.getString("cityOfBirth"),
                        rs.getString("isMarried")));
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
    }

    public ActorPOJO getActorById(int id) {
        ActorPOJO a1 = null;
        try {
            var rs = stm.executeQuery("SELECT * FROM Actors WHERE id=" + id);
            rs.next();
            a1 = new ActorPOJO(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("birthDate"),
                    rs.getString("firstMovie"),
                    rs.getString("cityOfBirth"),
                    rs.getString("isMarried"));
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a1;
    }

    public boolean removeActor(int id) {
        int res = 0;
        try {
            res = stm.executeUpdate("DELETE FROM Actors WHERE id=" + id);
            System.out.println("delete " + res);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return !(res == 0);
    }

    public boolean addActor(@NotNull ActorPOJO a1) {
        int res = 0;
        try {
            res = stm.executeUpdate("INSERT INTO Actors (name,birthDate,firstMovie,cityOfBirth,isMarried) " +
                    "VALUES ('"+
                    a1.name+"','"+
                    a1.birthDate+"','"+
                    a1.firstMovie+"','"+
                    a1.cityOfBirth+"','"+
                    a1.isMarried+"')");
            System.out.println("inserted " + res);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return !(res == 0);
    }

    public boolean updateActor(@NotNull ActorPOJO a1) {
        int res = 0;
        try {
            res = stm.executeUpdate("UPDATE Actors SET "+
                    "name = '"+a1.name+
                    "',birthDate = '"+a1.birthDate+
                    "',firstMovie = '"+a1.firstMovie+
                    "',cityOfBirth = '"+a1.cityOfBirth+
                    "',isMarried = '"+a1.isMarried+
                    "' WHERE id="+a1.id);
            System.out.println("updated " + res);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return !(res == 0);
    }

    public void close() {
        try {
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
