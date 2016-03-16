package unl.cse.demo;

import java.util.List;

import unl.cse.albums.Album;
import unl.cse.data.DataLoader;

public class Part1 {

	public static void main(String args[]) {
		
		List<Album> albums = DataLoader.getAlbums();
		for(Album a : albums) {
			System.out.println(a);
		}
		
	}
}
