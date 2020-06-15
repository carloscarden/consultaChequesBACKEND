package model;

import java.io.Serializable;

public class Ecargo implements Serializable {
	int cidr;
	int item;
	int apart;
	String docu;
	int secu;
	int foja;
	String apynom;
	int escue;
	Distrito dist;
	String cat;
	int cargo;
   	
	public Ecargo() {
		super();
	}


	public boolean equals(Object o) {
		Ecargo elem = (Ecargo)o; 
		if (this.getCidr() == elem.getCidr()){
			return true;
		}else{
			return false;
		}
	}
	

	/**
	 * @return
	 */
	public int getApart() {
		return apart;
	}

	/**
	 * @return
	 */
	public String getApynom() {
		return apynom;
	}

	/**
	 * @return
	 */
	public int getCargo() {
		return cargo;
	}

	/**
	 * @return
	 */
	public String getCat() {
		return cat;
	}

	/**
	 * @return
	 */
	public int getCidr() {
		return cidr;
	}

	/**
	 * @return
	 */
	public Distrito getDist() {
		return dist;
	}

	/**
	 * @return
	 */
	public String getDocu() {
		return docu;
	}

	/**
	 * @return
	 */
	public int getEscue() {
		return escue;
	}

	/**
	 * @return
	 */
	public int getFoja() {
		return foja;
	}

	/**
	 * @return
	 */
	public int getItem() {
		return item;
	}

	/**
	 * @return
	 */
	public int getSecu() {
		return secu;
	}

	/**
	 * @param i
	 */
	public void setApart(int i) {
		apart = i;
	}

	/**
	 * @param string
	 */
	public void setApynom(String string) {
		apynom = string;
	}

	/**
	 * @param i
	 */
	public void setCargo(int i) {
		cargo = i;
	}

	/**
	 * @param cat
	 */
	public void setCat(String string) {
		cat = string;
	}

	/**
	 * @param i
	 */
	public void setCidr(int i) {
		cidr = i;
	}

	/**
	 * @param distrito
	 */
	public void setDist(Distrito dist) {
		this.dist = dist;
	}

	/**
	 * @param string
	 */
	public void setDocu(String string) {
		docu = string;
	}

	/**
	 * @param i
	 */
	public void setEscue(int i) {
		escue = i;
	}

	/**
	 * @param i
	 */
	public void setFoja(int i) {
		foja = i;
	}

	/**
	 * @param i
	 */
	public void setItem(int i) {
		item = i;
	}

	/**
	 * @param i
	 */
	public void setSecu(int i) {
		secu = i;
	}

}