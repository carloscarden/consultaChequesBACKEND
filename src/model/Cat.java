package model;

import java.io.Serializable;

public class Cat implements Serializable {
    String cat;
    String es_deno;
    String descr;
    String marca;
    String ensenanza;
    String reg;
	
	public Cat() {
		super();
	}


	public boolean equals(Object o) {
		if (o == null)
		  return false;
		if (this == o)
		  return true;
		if (!(o instanceof Cat))
		  return false;
		final Cat elem = (Cat)o;

		if (!this.getCat().equals(elem.getCat()))
		  return false;
		
		if (!this.getEs_deno().equals(elem.getEs_deno()))  
		  return false;
		  
		return true;
	}
	
	public int hashCode() {
		int result = 14;
		result = 29 * result + getCat().hashCode();
		return result;
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
	public String getCat() {
		return cat;
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
	public void setCat(String string) {
		cat = string;
	}

	/**
	 * @return
	 */
	public String getEnsenanza() {
		return ensenanza;
	}

	/**
	 * @return
	 */
	public String getEs_deno() {
		return es_deno;
	}

	/**
	 * @return
	 */
	public String getMarca() {
		return marca;
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
	public void setEnsenanza(String string) {
		ensenanza = string;
	}

	/**
	 * @param string
	 */
	public void setEs_deno(String string) {
		es_deno = string;
	}

	/**
	 * @param string
	 */
	public void setMarca(String string) {
		marca = string;
	}

	/**
	 * @param string
	 */
	public void setReg(String string) {
		reg = string;
	}

}