/*
 * Created on 18-nov-2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package model;

import java.io.Serializable;

/**
 * @author ebuceta
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DatPer implements Serializable {
	String documento = null;
	String apellido = null;
    String descDistrito;
    int numDistrito;
    String tipo_org;
    int dependencia;
    int escuela; 
    String reg;

	public int getDependencia() {
		return dependencia;
	}

	public void setDependencia(int dependencia) {
		this.dependencia = dependencia;
	}

	public String getDescDistrito() {
		return descDistrito;
	}

	public void setDescDistrito(String descDistrito) {
		this.descDistrito = descDistrito;
	}

	public int getEscuela() {
		return escuela;
	}

	public void setEscuela(int escuela) {
		this.escuela = escuela;
	}

	public int getNumDistrito() {
		return numDistrito;
	}

	public void setNumDistrito(int numDistrito) {
		this.numDistrito = numDistrito;
	}

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public String getTipo_org() {
		return tipo_org;
	}

	public void setTipo_org(String tipo_org) {
		this.tipo_org = tipo_org;
	}

	public DatPer() {
		super();
	}
	
	public int hashCode() {
		int result = 14;
		result = 29 * result +  getDocumento().hashCode() + getApellido().hashCode();
		return result;
	}
	
	public boolean equals(Object o) {
			if (this.documento == null)
			  return false;
		
			if (o == null)
			  return false;
			if (this == o)
			  return true;
			if (!(o instanceof DatPer))
			  return false;
			final DatPer elem = (DatPer)o;

			if (!this.getDocumento().equals(elem.getDocumento()))
			  return false;
		
			if (!this.getApellido().equals(elem.getApellido()))
			  return false;
		  
			return true;

		}
	


	/**
	 * @return
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @return
	 */
	public String getDocumento() {
		return documento;
	}

	/**
	 * @param string
	 */
	public void setApellido(String string) {
		apellido = string;
	}

	/**
	 * @param string
	 */
	public void setDocumento(String string) {
		documento = string;
	}

}
