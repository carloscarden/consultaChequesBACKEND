package model;

import java.io.Serializable;

public class Rev implements Serializable {
    String rev;
    String descr;
	
	public Rev() {
		super();
	}


	public boolean equals(Object o) {
		Rev elem = (Rev)o; 
		if (this.getRev() == elem.getRev()){
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
	public String getRev() {
		return rev;
	}

	/**
	 * @param string
	 */
	public void setDescr(String string) {
		descr = string;
	}

	/**
	 * @param string
	 */
	public void setRev(String string) {
		rev = string;
	}

}