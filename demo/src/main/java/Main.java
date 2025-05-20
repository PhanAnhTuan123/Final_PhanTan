import dao.MovieDAO;
import dao.ShowDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import models.Movie;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
//        EntityManager em = Persistence
//                .createEntityManagerFactory("mariadb")
//                .createEntityManager();
        ShowDAO showDAO = new ShowDAO();
        MovieDAO movieDAO = new MovieDAO();
//        System.out.println(showDAO.listShowsByCurrentDateAndDirector("Anthony Russo"));
//        System.out.println(showDAO.updateShowDateTime("s017", LocalDateTime.now().plusDays(2)));
        Movie movie = new Movie();
        movie.setId(UUID.randomUUID().toString());
        movie.setTitle("Test");
        movie.setGenre("gender");
        movie.setReleaseYear("Test");
        movie.setDirector("Test");
        movie.setDuration(3);

        System.out.println(movieDAO.addMovie(movie));
    }
}
