import DAO.ActInMovRelDAO;
import DAO.ActorDAO;
import DAO.MoviesDAO;
import POJO.ActorPOJO;
import POJO.MoviePOJO;


public class Main {
    public static void main(String[] args) {

        ActorDAO aDao = new ActorDAO();
        MoviesDAO mDao = new MoviesDAO();
        ActInMovRelDAO relDao = new ActInMovRelDAO();
        var a = aDao.getActors();
        var b = mDao.getMovies();
        var c = relDao.getRelation();

        var d = aDao.getActorById(2);
        System.out.println(d);
        //aDao.addActor(new ActorPOJO(11,"lix","lix","lix","lix","lix"));
        System.out.println(aDao.getActorById(9));
        aDao.updateActor(new ActorPOJO(9,"lux","lux","lux","lux","lux"));
        System.out.println(aDao.getActorById(9));
        aDao.removeActor(9);


    }
}
