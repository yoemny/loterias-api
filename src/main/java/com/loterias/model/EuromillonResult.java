package com.loterias.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class EuromillonResult {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    @Temporal(TemporalType.DATE)
	private Date date;
	
	private Integer number1, number2, number3, number4, number5;
	
	private Integer star1, star2;
	
	private Integer drawNumber = -1;
	
	private Boolean sorted;
	
	private String pageCode = "NoCode";

	
	public EuromillonResult() {
	}

	public EuromillonResult(Date date) {
		this.date = date;
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the number1
	 */
	public Integer getNumber1() {
		return number1;
	}

	/**
	 * @param number1 the number1 to set
	 */
	public void setNumber1(Integer number1) {
		this.number1 = number1;
	}

	/**
	 * @return the number2
	 */
	public Integer getNumber2() {
		return number2;
	}

	/**
	 * @param number2 the number2 to set
	 */
	public void setNumber2(Integer number2) {
		this.number2 = number2;
	}

	/**
	 * @return the number3
	 */
	public Integer getNumber3() {
		return number3;
	}

	/**
	 * @param number3 the number3 to set
	 */
	public void setNumber3(Integer number3) {
		this.number3 = number3;
	}

	/**
	 * @return the number4
	 */
	public Integer getNumber4() {
		return number4;
	}

	/**
	 * @param number4 the number4 to set
	 */
	public void setNumber4(Integer number4) {
		this.number4 = number4;
	}

	/**
	 * @return the number5
	 */
	public Integer getNumber5() {
		return number5;
	}

	/**
	 * @param number5 the number5 to set
	 */
	public void setNumber5(Integer number5) {
		this.number5 = number5;
	}

	/**
	 * @return the star1
	 */
	public Integer getStar1() {
		return star1;
	}

	/**
	 * @param star1 the star1 to set
	 */
	public void setStar1(Integer star1) {
		this.star1 = star1;
	}

	/**
	 * @return the star2
	 */
	public Integer getStar2() {
		return star2;
	}

	/**
	 * @param star2 the star2 to set
	 */
	public void setStar2(Integer star2) {
		this.star2 = star2;
	}

	/**
	 * @return the drawNumber
	 */
	public Integer getDrawNumber() {
		return drawNumber;
	}

	/**
	 * @param drawNumber the drawNumber to set
	 */
	public void setDrawNumber(Integer drawNumber) {
		this.drawNumber = drawNumber;
	}

	/**
	 * @return the sorted
	 */
	public Boolean getSorted() {
		return sorted;
	}

	/**
	 * @param sorted the sorted to set
	 */
	public void setSorted(Boolean sorted) {
		this.sorted = sorted;
	}

	/**
	 * @return the pageCode
	 */
	public String getPageCode() {
		return pageCode;
	}

	/**
	 * @param pageCode the pageCode to set
	 */
	public void setPageCode(String pageCode) {
		this.pageCode = pageCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EuromillonResult [date=");
		builder.append(date);
		builder.append(", number1=");
		builder.append(number1);
		builder.append(", number2=");
		builder.append(number2);
		builder.append(", number3=");
		builder.append(number3);
		builder.append(", number4=");
		builder.append(number4);
		builder.append(", number5=");
		builder.append(number5);
		builder.append(", star1=");
		builder.append(star1);
		builder.append(", star2=");
		builder.append(star2);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
