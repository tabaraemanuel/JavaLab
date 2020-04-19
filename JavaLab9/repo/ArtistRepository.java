package repo;
import entities.AlbumEntity;
import entities.ArtistsEntity;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ArtistRepository {

    public void create(ArtistsEntity artistEntity){

        PersistenceUtil persistenceUtil = PersistenceUtil.getInstance();
        EntityManager entityManager = persistenceUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(artistEntity);
        entityManager.getTransaction().commit();
        entityManager.close();
        persistenceUtil.getEntityManagerFactory().close();

    }

    public List findById(Integer artistId) {
        PersistenceUtil persistenceUtil = PersistenceUtil.getInstance();
        EntityManager entityManager = persistenceUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery query = entityManager.createNamedQuery("ArtistsEntity.findById", ArtistsEntity.class);
        query.setParameter("id", artistId);
        return query.getResultList();
    }

    public List findByName(String name) {
        PersistenceUtil persistenceUtil = PersistenceUtil.getInstance();
        EntityManager entityManager = persistenceUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery query = entityManager.createNamedQuery("ArtistsEntity.findByName", ArtistsEntity.class);
        query.setParameter("name", name);
        return query.getResultList();
    }



}
