package unl.cse.albums;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Album")
public class Album {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="albumId", nullable=false)
	private Integer albumId;

	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="year", nullable=false)
	private Integer year;

	@Column(name="number", nullable=false)
	private Integer number;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="bandId", nullable=false)
	private Band band;

	@Transient
	private List<AlbumSong> songs;
	
	public Album(String title, Integer year, Integer number, Band band) {
		this.title = title;
		this.year = year;
		this.number = number;
		this.band = band;
	}

	public Integer getAlbumId() {
		return albumId;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public Integer getNumber() {
		return number;
	}
	
	public Band getBand() {
		return this.band;
	}
	
	public List<AlbumSong> getTracks() {
		return this.songs;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(title + " (" + year + ") by " + this.band);
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((albumId == null) ? 0 : albumId.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Album)) {
			return false;
		}
		Album other = (Album) obj;
		if (albumId == null) {
			if (other.albumId != null) {
				return false;
			}
		} else if (!albumId.equals(other.albumId)) {
			return false;
		}
		if (number == null) {
			if (other.number != null) {
				return false;
			}
		} else if (!number.equals(other.number)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		if (year == null) {
			if (other.year != null) {
				return false;
			}
		} else if (!year.equals(other.year)) {
			return false;
		}
		return true;
	}

	
}
