package repo;
import entities.AlbumEntity;
import util.PersistenceUtil;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


public class AlbumRepository {

    public void create(AlbumEntity albumEntity){

        PersistenceUtil persistenceUtil = PersistenceUtil.getInstance();
        EntityManager entityManager = persistenceUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(albumEntity);
        entityManager.getTransaction().commit();
        entityManager.close();
        persistenceUtil.getEntityManagerFactory().close();

    }

    public List findByArtist(Integer artistId) {
        PersistenceUtil persistenceUtil = PersistenceUtil.getInstance();
        EntityManager entityManager = persistenceUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery query = entityManager.createNamedQuery("AlbumEntity.findByArtistId", AlbumEntity.class);
        query.setParameter("artist_id", artistId);
        return query.getResultList();
    }


    public List findByName(String name) {
        PersistenceUtil persistenceUtil = PersistenceUtil.getInstance();
        EntityManager entityManager = persistenceUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery query = entityManager.createNamedQuery("AlbumEntity.findByName", AlbumEntity.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

}
