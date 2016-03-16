package unl.cse.demo;

import java.util.List;

import unl.cse.albums.Album;
import unl.cse.albums.Band;
import unl.cse.data.DataLoader;
import unl.cse.data.DataPersister;

public class Part4 {

	public static void main(String args[]) {
		
		Band b = DataLoader.getBandByName("Nirvana");
		Album a = new Album("From the Muddy Banks of the Wishkah", 1996, 5, b);
		DataPersister.addAlbum(a);

		//if successful, the new album should now be in the database:
		List<Album> albums = DataLoader.getAlbums();
		for(Album album : albums) {
			System.out.println(album);
		}

	}
}
