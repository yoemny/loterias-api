package com.loterias.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Stadistic {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stadistic_generator")
	@SequenceGenerator(name="stadistic_generator", sequenceName = "stadistic_sequence_id")
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;

	private String name;
	private String code;
	@ManyToOne
	@JoinColumn(name = "stadistic_group_id")
	private StadisticGroup stadisticGroup;

	public Stadistic(String name, String code, StadisticGroup stadisticGroup) {
		super();
		this.name = name;
		this.code = code;
		this.stadisticGroup = stadisticGroup;
	}


	public Stadistic() {
		super();
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}


	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}


	/**
	 * @return the stadisticGroup
	 */
	public StadisticGroup getStadisticGroup() {
		return stadisticGroup;
	}


	/**
	 * @param stadisticGroup the stadisticGroup to set
	 */
	public void setStadisticGroup(StadisticGroup stadisticGroup) {
		this.stadisticGroup = stadisticGroup;
	}

	
	
	
}
