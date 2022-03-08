package POJO;

public class ActInMovRelPOJO {
    public int actorID;
    public int movieID;

    public ActInMovRelPOJO(int actorID, int movieID) {
        this.actorID = actorID;
        this.movieID = movieID;
    }

    @Override
    public String toString() {
        return "ActInMovRel{" +
                "actorID=" + actorID +
                ", movieID=" + movieID +
                "}";
    }
}
