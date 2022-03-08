package DAO;

import POJO.ActInMovRelPOJO;
import POJO.ActorPOJO;
import POJO.MoviePOJO;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ActInMovRelDAO {
    List<ActInMovRelPOJO> rel = new ArrayList<>();
    String url = "C:\\databasesss\\ActMovRel.db";
    SqliteConnection sqlCon= new SqliteConnection();
    Connection con = sqlCon.getCon(url);
    Statement stm = sqlCon.getStm();

    public List<ActInMovRelPOJO> getRelation() {
        try {
            var rs = stm.executeQuery("SELECT * FROM ActInMovRel");
            while (rs.next())
                rel.add(new ActInMovRelPOJO(
                        rs.getInt("actorId"),
                        rs.getInt("movieId")));
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rel;
    }

    public boolean removeRel(int aId,int mId) {
        int res = 0;
        try {
            res = stm.executeUpdate("DELETE FROM ActInMovRel WHERE actorId=" + aId +"AND movieId = "+mId);
            System.out.println("deleted " + res);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return !(res == 0);
    }

    public boolean addRel(@NotNull ActInMovRelPOJO r1) {
        int res = 0;
        try {
            res = stm.executeUpdate("INSERT INTO ActInMovRel (actorId,movieId) VALUES ("+
                    r1.actorID+","+
                    r1.movieID+")");
            System.out.println("inserted " + res);
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
