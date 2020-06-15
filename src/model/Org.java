package model;

import java.io.Serializable;

public class Org implements Serializable {
    String org;
    String descr;
 	
	public Org() {
		super();
	}


	public boolean equals(Object o) {
		Org elem = (Org)o; 
		if (!this.getOrg().equals(elem.getOrg())){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * @return
	 */
	public String getDescr() {
		return descr;
	}

	/**
	 * @return
	 */
	public String getOrg() {
		return org;
	}

	/**
	 * @param string
	 */
	public void setDescr(String string) {
		descr = string;
	}

	/**
	 * @param i
	 */
	public void setOrg(String string) {
		org = string;
	}

}