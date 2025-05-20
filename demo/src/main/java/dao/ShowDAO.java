package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import models.Show;
import utils.JPAUtil;

import java.time.LocalDateTime;
import java.util.List;

public class ShowDAO {

    public List<Show> listShowsByCurrentDateAndDirector(String director) {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            LocalDateTime currentDay = LocalDateTime.now();
            LocalDateTime nextDay = currentDay.plusDays(1);
            String jpql = """
                SELECT s from Show s
                join s.movie m
                where m.director = :director
                and s.showDateTime >= :nextDay
        """;
            TypedQuery<Show> query = em.createQuery(jpql, Show.class)
                    .setParameter("director", director)
//                    .setParameter("currentDay", currentDay)
                    .setParameter("nextDay",nextDay);
//                    ;
            return query.getResultList();

        }
    }

    public boolean updateShowDateTime(String showId, LocalDateTime newShowDateTime) {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            em.getTransaction().begin();
            Show show = em.find(Show.class, showId);

            if(show == null) {
                em.getTransaction().rollback();
                return false;
            }

            String jpql  = """
                        SELECT count(t) from Ticket t
                        join t.show s where s.id = :showId
                    """;
            Long count = em.createQuery(jpql, Long.class)
                    .setParameter("showId", showId)
                    .getSingleResult();
            if(count != 0) {
                em.getTransaction().rollback();
                return false;
            }
            show.setShowDateTime(newShowDateTime);
            em.merge(show);

            em.getTransaction().commit();
            return true;
        }
    }
}
