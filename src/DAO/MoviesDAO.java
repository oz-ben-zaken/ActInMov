package DAO;

import POJO.MoviePOJO;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MoviesDAO {
    List<MoviePOJO> movies = new ArrayList<>();
    String url = "C:\\databasesss\\ActMovRel.db";
    SqliteConnection sqlCon = new SqliteConnection();
    Connection con = sqlCon.getCon(url);
    Statement stm = sqlCon.getStm();

    public List<MoviePOJO> getMovies() {
        try {
            var rs = stm.executeQuery("SELECT * FROM Movies");
            while (rs.next())
                movies.add(new MoviePOJO(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("len"),
                        rs.getInt("year"),
                        rs.getLong("cost"),
                        rs.getString("genre")));
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public MoviePOJO getMovieById(int id) {
        MoviePOJO m1 = null;
        try {
            var rs = stm.executeQuery("SELECT * FROM Movies WHERE id=" + id);
            rs.next();
            m1 = new MoviePOJO(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getInt("len"),
                    rs.getInt("year"),
                    rs.getLong("cost"),
                    rs.getString("genre"));
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m1;
    }

    public boolean removeMovie(int id) {
        int res = 0;
        try {
            res = stm.executeUpdate("DELETE FROM Movies WHERE id=" + id);
            System.out.println("delete " + res);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return !(res == 0);
    }

    public boolean addMovie(@NotNull MoviePOJO m1) {
        int res = 0;
        try {
            res = stm.executeUpdate("INSERT INTO Movies (title,len,year,cost,genre) VALUES ('"+
                    m1.title+"',"+
                    m1.len+","+
                    m1.year+","+
                    m1.cost+",'"+
                    m1.genre+"')");
            System.out.println("inserted " + res);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return !(res == 0);
    }

    public boolean updateMovie(@NotNull MoviePOJO m1) {
        int res = 0;
        try {
            res = stm.executeUpdate("UPDATE Movies SET "+
                    "title = '"+m1.title+
                    "',len = "+m1.len+
                    ",year = "+m1.year+
                    ",cost = "+m1.cost+
                    ",genre = '"+m1.genre+
                    "' WHERE id="+m1.id);
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
