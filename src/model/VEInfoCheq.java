package model;

import java.io.Serializable;
import java.util.Date;

public class VEInfoCheq implements Serializable {
    String docu;
	String nombrePers;
	int secu;
	String cat;
	String descripcionCategoria;
	int item;
	int apart;
	int distrito;
	int numero;
	int foja;
	int cargo;
	int cidr;
	String nombreDistrito;
	int opid;
	int periodo;
	int liqid;
	int nroCheq;
	String antig;
	String emitirCheq;
	double liquido;
	String observacionesCheque;
	String nombreOpago;
	Date vencimiento;
	String origen;
	String tipoOpago;
	int cajero;
	Date vigOpago;
	String moneda;
	String muestra;
	String caracRevOpago;
	int perOpago;
	int opidIps;    
    int opidIoma;
    Date fpago;
    
        
    
	public Date getFpago() {
		return fpago;
	}


	public void setFpago(Date fpago) {
		this.fpago = fpago;
	}


	public VEInfoCheq() {
		super();
	}


	public boolean equals(Object o) {
		if (o == null)
		  return false;
		if (this == o)
		  return true;
		if (!(o instanceof VEInfoCheq))
		  return false;
		final VEInfoCheq elem = (VEInfoCheq)o;

		if (!this.getDocu().equals(elem.getDocu()))
		  return false;
		if (this.getSecu() != elem.getSecu())
		  return false;		
		if (this.getCidr() != elem.getCidr())
		  return false;		
		if (this.getOpid() != elem.getOpid())
		  return false;		
		if (this.getPeriodo() != elem.getPeriodo())
		  return false;		
		if (this.getLiqid() != elem.getLiqid())
		  return false;		
  
		return true;
	}
	
	public int hashCode() {
		int result = 14;
		result = 29 * result + getDocu().hashCode() + getSecu();
		return result;
	}

	
	/**
	 * @return
	 */
	public String getAntig() {
		return antig;
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
	public int getCajero() {
		return cajero;
	}

	/**
	 * @return
	 */
	public String getCaracRevOpago() {
		return caracRevOpago;
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
	public String getDescripcionCategoria() {
		return descripcionCategoria;
	}

	/**
	 * @return
	 */
	public int getDistrito() {
		return distrito;
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
	public String getEmitirCheq() {
		return emitirCheq;
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
	public int getLiqid() {
		return liqid;
	}

	/**
	 * @return
	 */
	public double getLiquido() {
		return liquido;
	}

	/**
	 * @return
	 */
	public String getMoneda() {
		return moneda;
	}

	/**
	 * @return
	 */
	public String getMuestra() {
		return muestra;
	}

	/**
	 * @return
	 */
	public String getNombreDistrito() {
		return nombreDistrito;
	}

	/**
	 * @return
	 */
	public String getNombreOpago() {
		return nombreOpago;
	}

	/**
	 * @return
	 */
	public String getNombrePers() {
		return nombrePers;
	}

	/**
	 * @return
	 */
	public int getNroCheq() {
		return nroCheq;
	}

	/**
	 * @return
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @return
	 */
	public String getObservacionesCheque() {
		return observacionesCheque;
	}

	/**
	 * @return
	 */
	public int getOpid() {
		return opid;
	}

	/**
	 * @return
	 */
	public int getOpidIoma() {
		return opidIoma;
	}

	/**
	 * @return
	 */
	public int getOpidIps() {
		return opidIps;
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
	public int getPeriodo() {
		return periodo;
	}

	/**
	 * @return
	 */
	public int getPerOpago() {
		return perOpago;
	}

	/**
	 * @return
	 */
	public int getSecu() {
		return secu;
	}

	/**
	 * @return
	 */
	public String getTipoOpago() {
		return tipoOpago;
	}

	/**
	 * @return
	 */
	public Date getVencimiento() {
		return vencimiento;
	}

	/**
	 * @return
	 */
	public Date getVigOpago() {
		return vigOpago;
	}

	/**
	 * @param string
	 */
	public void setAntig(String string) {
		antig = string;
	}

	/**
	 * @param i
	 */
	public void setApart(int i) {
		apart = i;
	}

	/**
	 * @param i
	 */
	public void setCajero(int i) {
		cajero = i;
	}

	/**
	 * @param string
	 */
	public void setCaracRevOpago(String string) {
		caracRevOpago = string;
	}

	/**
	 * @param i
	 */
	public void setCargo(int i) {
		cargo = i;
	}

	/**
	 * @param string
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
	 * @param string
	 */
	public void setDescripcionCategoria(String string) {
		descripcionCategoria = string;
	}

	/**
	 * @param i
	 */
	public void setDistrito(int i) {
		distrito = i;
	}

	/**
	 * @param string
	 */
	public void setDocu(String string) {
		docu = string;
	}

	/**
	 * @param string
	 */
	public void setEmitirCheq(String string) {
		emitirCheq = string;
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
	public void setLiqid(int i) {
		liqid = i;
	}

	/**
	 * @param d
	 */
	public void setLiquido(double d) {
		liquido = d;
	}

	/**
	 * @param string
	 */
	public void setMoneda(String string) {
		moneda = string;
	}

	/**
	 * @param string
	 */
	public void setMuestra(String string) {
		muestra = string;
	}

	/**
	 * @param string
	 */
	public void setNombreDistrito(String string) {
		nombreDistrito = string;
	}

	/**
	 * @param string
	 */
	public void setNombreOpago(String string) {
		nombreOpago = string;
	}

	/**
	 * @param string
	 */
	public void setNombrePers(String string) {
		nombrePers = string;
	}

	/**
	 * @param i
	 */
	public void setNroCheq(int i) {
		nroCheq = i;
	}

	/**
	 * @param i
	 */
	public void setNumero(int i) {
		numero = i;
	}

	/**
	 * @param string
	 */
	public void setObservacionesCheque(String string) {
		observacionesCheque = string;
	}

	/**
	 * @param i
	 */
	public void setOpid(int i) {
		opid = i;
	}

	/**
	 * @param i
	 */
	public void setOpidIoma(int i) {
		opidIoma = i;
	}

	/**
	 * @param i
	 */
	public void setOpidIps(int i) {
		opidIps = i;
	}

	/**
	 * @param string
	 */
	public void setOrigen(String string) {
		origen = string;
	}

	/**
	 * @param i
	 */
	public void setPeriodo(int i) {
		periodo = i;
	}

	/**
	 * @param i
	 */
	public void setPerOpago(int i) {
		perOpago = i;
	}

	/**
	 * @param i
	 */
	public void setSecu(int i) {
		secu = i;
	}

	/**
	 * @param string
	 */
	public void setTipoOpago(String string) {
		tipoOpago = string;
	}

	/**
	 * @param date
	 */
	public void setVencimiento(Date date) {
		vencimiento = date;
	}

	/**
	 * @param date
	 */
	public void setVigOpago(Date date) {
		vigOpago = date;
	}

}