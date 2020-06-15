package model;

import java.io.Serializable;

public class Dep implements Serializable {
    int dep;
    String descr;
 	
	public Dep() {
		super();
	}


	public boolean equals(Object o) {
		Dep elem = (Dep)o; 
		if (this.getDep() != elem.getDep()){
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
	public int getDep() {
		return dep;
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
	public void setDep(int i) {
		dep = i;
	}

}