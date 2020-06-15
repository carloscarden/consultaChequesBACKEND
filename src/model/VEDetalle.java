package model;

import java.io.Serializable;

public class VEDetalle implements Serializable {
    int eliqid;
    String codigo;
    String bod;
    String origen;
    int per;
    double pesos;
	String descripcioncodigo;
	int periodo;
	
	public VEDetalle() {
		super();
	}


	public boolean equals(Object o) {
		if (o == null)
		  return false;
		if (this == o)
		  return true;
		if (!(o instanceof VEDetalle))
		  return false;
		final VEDetalle elem = (VEDetalle)o;

		if (this.getEliqid() != elem.getEliqid())
		  return false;
		
		if (!this.getCodigo().equals(elem.getCodigo()))  
		  return false;
		
		if (!this.getBod().equals(elem.getBod()))  
		  return false;
		
		if (this.getPeriodo() != elem.getPeriodo())  
		  return false;
		  
		return true;
	}
	
	public int hashCode() {
		int result = 14;
		result = 29 * result + getCodigo().hashCode() + getEliqid() + getBod().hashCode() + getPeriodo();
		return result;
	}



	/**
	 * @return
	 */
	public String getBod() {
		return bod;
	}

	/**
	 * @return
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @return
	 */
	public String getDescripcioncodigo() {
		return descripcioncodigo;
	}

	/**
	 * @return
	 */
	public int getEliqid() {
		return eliqid;
	}

	/**
	 * @return
	 */
	public String getOrigen() {
		return origen;
	}

	/**
	 * @return
	 */
	public int getPer() {
		return per;
	}

	/**
	 * @return
	 */
	public int getPeriodo() {
		return periodo;
	}

	/**
	 * @return
	 */
	public double getPesos() {
		return pesos;
	}

	/**
	 * @param string
	 */
	public void setBod(String string) {
		bod = string;
	}

	/**
	 * @param string
	 */
	public void setCodigo(String string) {
		codigo = string;
	}

	/**
	 * @param string
	 */
	public void setDescripcioncodigo(String string) {
		descripcioncodigo = string;
	}

	/**
	 * @param i
	 */
	public void setEliqid(int i) {
		eliqid = i;
	}

	/**
	 * @param string
	 */
	public void setOrigen(String string) {
		origen = string;
	}

	/**
	 * @param string
	 */
	public void setPer(int i) {
		per = i;
	}

	/**
	 * @param string
	 */
	public void setPeriodo(int i) {
		periodo = i;
	}

	/**
	 * @param d
	 */
	public void setPesos(double d) {
		pesos = d;
	}

}