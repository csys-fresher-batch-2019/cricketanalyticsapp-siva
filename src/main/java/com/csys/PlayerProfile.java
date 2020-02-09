package com.csys;

public class PlayerProfile {

    String capNo;
	String name;
	String nation;
	String style;
    int debutYear;
    int retiredYear;
    
    
	
	public PlayerProfile() {
		// TODO Auto-generated constructor stub
	}



	/**
	 * @return the capNo
	 */
	public String getCapNo() {
		return capNo;
	}



	/**
	 * @param capNo the capNo to set
	 */
	public void setCapNo(String capNo) {
		this.capNo = capNo;
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
	 * @return the nation
	 */
	public String getNation() {
		return nation;
	}



	/**
	 * @param nation the nation to set
	 */
	public void setNation(String nation) {
		this.nation = nation;
	}



	/**
	 * @return the style
	 */
	public String getStyle() {
		return style;
	}



	/**
	 * @param style the style to set
	 */
	public void setStyle(String style) {
		this.style = style;
	}



	/**
	 * @return the debutYear
	 */
	public int getDebutYear() {
		return debutYear;
	}



	/**
	 * @param debutYear the debutYear to set
	 */
	public void setDebutYear(int debutYear) {
		this.debutYear = debutYear;
	}



	/**
	 * @return the retiredYear
	 */
	public int getRetiredYear() {
		return retiredYear;
	}



	/**
	 * @param retiredYear the retiredYear to set
	 */
	public void setRetiredYear(int retiredYear) {
		this.retiredYear = retiredYear;
	}



	@Override
	public String toString() {
		return "PlayerProfile [capNo=" + capNo + ", name=" + name + ", nation=" + nation + ", style=" + style
				+ ", debutYear=" + debutYear + ", retiredYear=" + retiredYear + "]";
	}
	
	

	}
