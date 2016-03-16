package unl.cse.albums;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Musician")
public class Musician {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="musicianId", nullable=false)
	private Integer musicianId;

	@Column(name="firstName", nullable=false)
	private String firstName;
	
	@Column(name="lastName", nullable=false)
	private String lastName;

	@Column(name="country", nullable=false)
	private String country;
	
	private Musician() { }
	
	private Musician(int foo) {}

	@Override
	public String toString() {
		return this.lastName + ", " + this.firstName;
	}

	
}
