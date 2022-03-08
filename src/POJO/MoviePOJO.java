package POJO;

public class MoviePOJO {
    public int id;
    public String title;
    public int len;
    public int year;
    public long cost;
    public String genre;

    public MoviePOJO(int id, String title, int len, int year, long cost, String genre) {
        this.id = id;
        this.title = title;
        this.len = len;
        this.year = year;
        this.cost = cost;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", len=" + len +
                ", year=" + year +
                ", cost=" + cost +
                ", genre='" + genre + '\'' +
                "}";
    }
}
