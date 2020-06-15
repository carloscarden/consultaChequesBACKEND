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
public class DetCodigo implements Serializable {
	
	String codigo = null;
	String descripcion = null;
	String importe = null;

	public DetCodigo() {
		super();
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
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @return
	 */
	public String getImporte() {
		return importe;
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
	public void setDescripcion(String string) {
		descripcion = string;
	}

	/**
	 * @param string
	 */
	public void setImporte(String string) {
		importe = string;
	}

}
