package unl.cse.albums;

public class AlbumSong {

	private Integer albumSongId;

	private int trackNumber;
	
	private int trackLength;

	private Album album;
	
	private Song song;
	
	public String toString() {
		int seconds = this.trackLength % 60;
		int minutes = (this.trackLength - seconds) / 60;
		return this.trackNumber + String.format(" (%2d:%02d) ", minutes, seconds) + 
			   this.song.toString() + "\n";
	}
}
