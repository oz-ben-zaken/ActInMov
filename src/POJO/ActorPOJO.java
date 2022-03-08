package POJO;

public class ActorPOJO {
    public int id;
    public String name;
    public String birthDate;
    public String firstMovie;
    public String cityOfBirth;
    public String isMarried;

    public ActorPOJO(int id, String name, String birthDate, String firstMovie, String cityOfBirth, String isMarried) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.firstMovie = firstMovie;
        this.cityOfBirth = cityOfBirth;
        this.isMarried = isMarried;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", firstMovie='" + firstMovie + '\'' +
                ", cityOfBirth='" + cityOfBirth + '\'' +
                ", isMarried='" + isMarried + '\'' +
                "}";
    }
}
