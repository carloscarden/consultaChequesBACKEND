package model;

import java.io.Serializable;

public class VDetalle implements Serializable {
    int liqid;
    String codigo;
    String bod;
    String clave;
    String origen;
    double pesos;
	double pesossubv;
	String descripcioncodigo;
	String imputa;
	
	public VDetalle() {
		super();
	}


	public boolean equals(Object o) {
		if (o == null)
		  return false;
		if (this == o)
		  return true;
		if (!(o instanceof VDetalle))
		  return false;
		final VDetalle elem = (VDetalle)o;

		if (this.getLiqid() != elem.getLiqid())
		  return false;
		
		if (!this.getCodigo().equals(elem.getCodigo()))  
		  return false;
		
		if (!this.getBod().equals(elem.getBod()))  
		  return false;
		
		if (!this.getClave().equals(elem.getClave()))  
		  return false;
		  
		return true;
	}
	
	public int hashCode() {
		int result = 14;
		result = 29 * result + getCodigo().hashCode() + getLiqid() + getBod().hashCode() + getClave().hashCode();
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
	public String getClave() {
		return clave;
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
	public String getImputa() {
		return imputa;
	}

	/**
	 * @return
	 */
	public int getLiqid() {
		return liqid;
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
	public double getPesos() {
		return pesos;
	}

	/**
	 * @return
	 */
	public double getPesossubv() {
		return pesossubv;
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
	public void setClave(String string) {
		clave = string;
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
	 * @param string
	 */
	public void setImputa(String string) {
		imputa = string;
	}

	/**
	 * @param i
	 */
	public void setLiqid(int i) {
		liqid = i;
	}

	/**
	 * @param string
	 */
	public void setOrigen(String string) {
		origen = string;
	}

	/**
	 * @param d
	 */
	public void setPesos(double d) {
		pesos = d;
	}

	/**
	 * @param d
	 */
	public void setPesossubv(double d) {
		pesossubv = d;
	}

}