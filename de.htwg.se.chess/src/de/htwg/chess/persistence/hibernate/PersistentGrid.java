package de.htwg.chess.persistence.hibernate;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grid")
public class PersistentGrid implements Serializable {

	private static final long serialVersionUID = 1L;

	public PersistentGrid() {
		// empty
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;

	@OneToMany(mappedBy = "grid")
	@Column(name = "cell")
	public Set<PersistentCell> cells;

}