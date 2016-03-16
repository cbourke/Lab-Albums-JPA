package unl.cse.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import unl.cse.albums.Album;

public class DataPersister {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("album_database");

	public static void addAlbum(Album a) {

		EntityManager em = null;
		
		try {
			em = emf.createEntityManager();

			em.getTransaction().begin();
			em.persist(a);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.err.println("Unable to persist album: "+a);
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}
}
