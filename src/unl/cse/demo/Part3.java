package unl.cse.demo;

import java.util.List;

import unl.cse.albums.Band;
import unl.cse.albums.Musician;
import unl.cse.data.DataLoader;

public class Part3 {

	public static void main(String args[]) {
		
		List<Band> bands = DataLoader.getBands();
		for(Band b : bands) {
			System.out.println(b + " bandId = " + b.getBandId());
			for(Musician m : b.getMembers()) {
				System.out.println("\t" + m);
			}
		}

		//you may need to change the ID to get a valid band:
		int bandId = 8801;
		Band b = DataLoader.getBandById(bandId);
		System.out.println(b);
		
	}
}
