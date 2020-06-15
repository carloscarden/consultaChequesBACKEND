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
public class CambDocPer implements Serializable {
	String documento = null;
	String periodo = null;

	public CambDocPer() {
		super();
	}
	
	public int hashCode() {
		int result = 14;
		result = 29 * result +  getDocumento().hashCode() + getPeriodo().hashCode();
		return result;
	}
	
	public boolean equals(Object o) {
		    if (this.documento == null)
			  return false;
			if (o == null)
			  return false;
			if (this == o)
			  return true;
			if (!(o instanceof CambDocPer))
			  return false;
			final CambDocPer elem = (CambDocPer)o;

			if (!this.getDocumento().equals(elem.getDocumento()))
			  return false;
			if (!this.getPeriodo().equals(elem.getPeriodo()))
			  return false;
		  
			return true;

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
	public void setDocumento(String string) {
		documento = string;
	}

	/**
	 * @return
	 */
	public String getPeriodo() {
		return periodo;
	}

	/**
	 * @param string
	 */
	public void setPeriodo(String string) {
		periodo = string;
	}


}
