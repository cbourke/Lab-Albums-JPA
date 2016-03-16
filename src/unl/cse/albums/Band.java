package unl.cse.albums;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Band")
public class Band {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bandId", nullable=false)
	private Integer bandId;

	@Column(name="name", nullable=false)
	private String name;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "BandMember", joinColumns = { @JoinColumn(name="bandId") }, 
	                                inverseJoinColumns = { @JoinColumn(name="musicianId") }
	          )
	private Set<Musician> members;
	
	private Band() { }

	public Integer getBandId() {
		return bandId;
	}

	public String getName() {
		return name;
	}
	
	public Set<Musician> getMembers() {
		return this.members;
	}

	@Override
	public String toString() {
		return this.name;
	}

	
	
}
