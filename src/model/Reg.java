package model;

import java.io.Serializable;

public class Reg implements Serializable {
    String reg;
    String descr;
	
	public Reg() {
		super();
	}


	public boolean equals(Object o) {
		Reg elem = (Reg)o; 
		if (this.getReg() == elem.getReg()){
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
	public String getReg() {
		return reg;
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
	public void setReg(String string) {
		reg = string;
	}

}