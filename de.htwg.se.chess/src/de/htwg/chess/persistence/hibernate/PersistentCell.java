package de.htwg.chess.persistence.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cell")
public class PersistentCell implements Serializable {

	private static final long serialVersionUID = 3184225396652683648L;
	public static final String PROP_ID = "id";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;

	public Integer value = 0;

	@Column(name = "rowcell")
	public Integer row = 0;

	@Column(name = "columncell")
	public Integer column = 0;

	public Boolean given = false;

	@ManyToOne
	@JoinColumn(name = "gridid")
	public PersistentGrid grid;

}
