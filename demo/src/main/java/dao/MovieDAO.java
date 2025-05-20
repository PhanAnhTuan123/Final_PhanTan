package dao;

import jakarta.persistence.EntityManager;
import models.Movie;
import utils.JPAUtil;

public class MovieDAO {

    public boolean addMovie(Movie movie){
//        if(!movie.getId().matches("M\\d{3,}")) return false;
        if (movie.getDuration() <=0) return false;

        try (EntityManager em = JPAUtil.getEntityManager()) {
            em.getTransaction().begin();
            em.persist(movie);
            em.getTransaction().commit();
            return true;
        }
    }
}
