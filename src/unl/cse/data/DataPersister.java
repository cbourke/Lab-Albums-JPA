package unl.cse.data;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import unl.cse.albums.Album;

public class DataPersister {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("album_database");

	public static void addAlbum(Album a) {


	}
}
