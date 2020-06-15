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
public class DetPeriodo implements Serializable {
	String periodo = null;
	String documento = null;
	String secuencia = null;
	String fechaafec = null;
	String apellido = null;
	String foja = null;
	String cargo = null;
	String dep = null;
	String dis = null;
	String tor = null;
	String escu = null;
	String opag = null;
	String dopag = null;
	String cdoc = null;
	String liquido = null;
	String fecafec = null;
	String nrocheq = null;
	String fpago = null;
	String cat = null;
	String apart = null;
	String item = null;
	
	public String getFpago() {
		return fpago;
	}


	public void setFpago(String fpago) {
		this.fpago = fpago;
	}


	public DetPeriodo() {
		super();
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

	/**
	 * @return
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * @return
	 */
	public String getCdoc() {
		return cdoc;
	}

	/**
	 * @return
	 */
	public String getDep() {
		return dep;
	}

	/**
	 * @return
	 */
	public String getDis() {
		return dis;
	}

	/**
	 * @return
	 */
	public String getDopag() {
		return dopag;
	}

	/**
	 * @return
	 */
	public String getEscu() {
		return escu;
	}

	/**
	 * @return
	 */
	public String getFoja() {
		return foja;
	}

	/**
	 * @return
	 */
	public String getLiquido() {
		return liquido;
	}

	/**
	 * @return
	 */
	public String getOpag() {
		return opag;
	}

	/**
	 * @return
	 */
	public String getPeriodo() {
		return periodo;
	}

	/**
	 * @return
	 */
	public String getSecuencia() {
		return secuencia;
	}

	/**
	 * @return
	 */
	public String getTor() {
		return tor;
	}

	/**
	 * @param string
	 */
	public void setCargo(String string) {
		cargo = string;
	}

	/**
	 * @param string
	 */
	public void setCdoc(String string) {
		cdoc = string;
	}

	/**
	 * @param string
	 */
	public void setDep(String string) {
		dep = string;
	}

	/**
	 * @param string
	 */
	public void setDis(String string) {
		dis = string;
	}

	/**
	 * @param string
	 */
	public void setDopag(String string) {
		dopag = string;
	}

	/**
	 * @param string
	 */
	public void setEscu(String string) {
		escu = string;
	}

	/**
	 * @param string
	 */
	public void setFoja(String string) {
		foja = string;
	}

	/**
	 * @param string
	 */
	public void setLiquido(String string) {
		liquido = string;
	}

	/**
	 * @param string
	 */
	public void setOpag(String string) {
		opag = string;
	}

	/**
	 * @param string
	 */
	public void setPeriodo(String string) {
		periodo = string;
	}

	/**
	 * @param string
	 */
	public void setSecuencia(String string) {
		secuencia = string;
	}

	/**
	 * @param string
	 */
	public void setTor(String string) {
		tor = string;
	}

	/**
	 * @return
	 */
	public String getFecafec() {
		return fecafec;
	}

	/**
	 * @param string
	 */
	public void setFecafec(String string) {
		fecafec = string;
	}

	/**
	 * @return
	 */
	public String getNrocheq() {
		return nrocheq;
	}

	/**
	 * @param string
	 */
	public void setNrocheq(String string) {
		nrocheq = string;
	}


	public String getFechaafec() {
		return fechaafec;
	}


	public void setFechaafec(String fechaafec) {
		this.fechaafec = fechaafec;
	}


	public String getCat() {
		return cat;
	}


	public void setCat(String cat) {
		this.cat = cat;
	}


	public String getApart() {
		return apart;
	}


	public void setApart(String apart) {
		this.apart = apart;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}

}
