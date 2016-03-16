package unl.cse.albums;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Song")
public class Song {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="songId", nullable=false)
	private Integer songId;

	@Column(name="title", nullable=false)
	private String title;
	
	public String toString() {
		return this.title;
	}

}
