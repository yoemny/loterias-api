package com.loterias.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class StadisticGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stadistic_group_generator")
	@SequenceGenerator(name="stadistic_group_generator", sequenceName = "stadistic_group_sequence_id")
	@Column(name = "id", updatable = false, nullable = false)
    private Integer id;
	
	private String name;
	
	@OneToMany(mappedBy = "stadisticGroup", cascade = CascadeType.ALL)
	private Set<Stadistic>  stadistics;
	
	public StadisticGroup() {
		super();
	}

	public StadisticGroup(String name, Set<Stadistic> stadistics) {
		super();
		this.name = name;
		this.stadistics = stadistics;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the groupName
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param groupName the groupName to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the stadistics
	 */
	public Set<Stadistic> getStadistics() {
		return stadistics;
	}

	/**
	 * @param stadistics the stadistics to set
	 */
	public void setStadistics(Set<Stadistic> stadistics) {
		this.stadistics = stadistics;
	}
	

	
}
