package unl.cse.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import unl.cse.albums.Album;
import unl.cse.albums.Band;

public class DataLoader {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("album_database");

	public static List<Album> getAlbums() {

		EntityManager em = null;
		List<Album> albums = null;
		
		try {
			em = emf.createEntityManager();
	
			em.getTransaction().begin();
	
			String query = "FROM Album";
			
			albums = (List<Album>) em.createQuery(query).getResultList();

		} catch (Exception e) {
			throw new RuntimeException("Error loading Albums", e);
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}	
		}
		
		return albums;
	}
	
	public static Album getAlbumById(int albumId) {
		EntityManager em = null;
		Album a = null;
		
		try {
			em = emf.createEntityManager();
	
			em.getTransaction().begin();
	
			String query = "FROM Album a WHERE a.albumId = :albumId";
			
			a = (Album) em.createQuery(query).setParameter("albumId", albumId).getSingleResult();

		} catch (Exception e) {
			throw new RuntimeException("Error loading Album with id = "+albumId, e);
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}	
		}
		
		return a;
	}
	
	public static List<Band> getBands() {
		return null;
	}
	
	public static Band getBandById(int bandId) {
		return null;
	}
	
	public static Band getBandByName(String name) {

		EntityManager em = null;
		Band b = null;
		
		try {
			em = emf.createEntityManager();
	
			em.getTransaction().begin();
	
			String query = "FROM Band b WHERE b.name = :name";
			
			b = (Band) em.createQuery(query).setParameter("name", name).getSingleResult();

		} catch (Exception e) {
			throw new RuntimeException("Error loading Band with name = "+name, e);
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}	
		}
		
		return b;
	}		
}
