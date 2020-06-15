package model;

import java.io.Serializable;
import java.util.Date;

public class VInfoCheq implements Serializable {
  
	int pin;
	Date vigdPers;
	Date vighPers;
	String docu;
	String nombrePers;
	String sexo;
	int secu;
	Date vigdCar;
	Date vighCar;
	String esDeno;
	
    Cat cat;
    Rev rev;
    Reg reg;
    Org tipoOrg;
    Dep dependencia;
    
	double hs;
	String dobEscolCargo;
	String sit;
	int item;
	int apart;
	String codMov;
	String fcion;
	String convenio;
	String garantia;
	String movilidad;
	String presentismo;
	int escuid;
	Date vigdEstab;
	Date vighEstab;
	int distrito;
	int numero;
	String nombreEstab;
	String ccticas;
	int rural;
	int secciones;
	int turnos;
	int subvencion;
	int dobEscolEstab;
	String nombreDistrito;
	double inas;
	int opid;
	int periodo;
	int fecAfec;
	int liqid;
	String tipoCheque;
	int nroCheq;
	String antig;
	String emitirCheq;
	double liquido;
	String observacionesCheque;
	int escuidCheque;
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
	Date vigdInt;
	Date vighInt;
	Integer escuidInt;

    String catInt;
    Integer dependenciaInt;
    String tipoOrgInt;
   
	Double hsInt;
	String dobEscolInt;
	Integer itemInt;
	Integer apartInt;
	String codMovInt;
	String movInt;
	Date vigdEstabInt;
	Date vighEstabInt;
	Integer distritoInt;
	Integer numeroInt;
	String nombreEstabInt;
	String ccticasInt;
	Integer ruralInt;
	Integer seccionesInt;
	Integer turnosInt;
	Integer subvencionInt;
	Integer dobEscolEstabInt;
	Integer escuidEscart;
	String nomDistInt;
	Date fpago ;

	
	public Date getFpago() {
		return fpago;
	}


	public void setFpago(Date fpago) {
		this.fpago = fpago;
	}


	public VInfoCheq() {
		super();
	}


	public boolean equals(Object o) {
		if (o == null)
		  return false;
		if (this == o)
		  return true;
		if (!(o instanceof VInfoCheq))
		  return false;
		final VInfoCheq elem = (VInfoCheq)o;

		if (this.getPin() != elem.getPin())
		  return false;
		
		if (this.getSecu() != elem.getSecu())
			  return false;
		
		if (this.getOpid() != elem.getOpid())
			  return false;
			  
		if (this.getPeriodo() != elem.getPeriodo())
			  return false;
			  
		if (this.getFecAfec() != elem.getFecAfec())
			  return false;
			  
		if (this.getLiqid() != elem.getLiqid())
			  return false;
			  
		if (!this.getEsDeno().equals(elem.getEsDeno()))  
		  return false;
		  
		return true;
	}
	
	public int hashCode() {
		int result = 14;
		result = 29 * result + getPin() + getLiqid();
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
	public String getCcticas() {
		return ccticas;
	}

	/**
	 * @return
	 */
	public String getCodMov() {
		return codMov;
	}

	/**
	 * @return
	 */
	public String getConvenio() {
		return convenio;
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
	public String getDobEscolCargo() {
		return dobEscolCargo;
	}

	/**
	 * @return
	 */
	public int getDobEscolEstab() {
		return dobEscolEstab;
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
	public int getEscuid() {
		return escuid;
	}

	/**
	 * @return
	 */
	public int getEscuidCheque() {
		return escuidCheque;
	}

	/**
	 * @return
	 */
	public String getEsDeno() {
		return esDeno;
	}

	/**
	 * @return
	 */
	public String getFcion() {
		return fcion;
	}

	/**
	 * @return
	 */
	public int getFecAfec() {
		return fecAfec;
	}

	/**
	 * @return
	 */
	public String getGarantia() {
		return garantia;
	}

	/**
	 * @return
	 */
	public double getHs() {
		return hs;
	}

	/**
	 * @return
	 */
	public double getInas() {
		return inas;
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
	public String getMovilidad() {
		return movilidad;
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
	public String getNombreEstab() {
		return nombreEstab;
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
	public int getPin() {
		return pin;
	}

	/**
	 * @return
	 */
	public String getPresentismo() {
		return presentismo;
	}


	/**
	 * @return
	 */
	public int getRural() {
		return rural;
	}

	/**
	 * @return
	 */
	public int getSecciones() {
		return secciones;
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
	public String getSexo() {
		return sexo;
	}

	/**
	 * @return
	 */
	public String getSit() {
		return sit;
	}

	/**
	 * @return
	 */
	public int getSubvencion() {
		return subvencion;
	}

	/**
	 * @return
	 */
	public String getTipoCheque() {
		return tipoCheque;
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
	public int getTurnos() {
		return turnos;
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
	public Date getVigdCar() {
		return vigdCar;
	}

	/**
	 * @return
	 */
	public Date getVigdEstab() {
		return vigdEstab;
	}

	/**
	 * @return
	 */
	public Date getVigdPers() {
		return vigdPers;
	}

	/**
	 * @return
	 */
	public Date getVighCar() {
		return vighCar;
	}

	/**
	 * @return
	 */
	public Date getVighEstab() {
		return vighEstab;
	}

	/**
	 * @return
	 */
	public Date getVighPers() {
		return vighPers;
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
	 * @param string
	 */
	public void setCcticas(String string) {
		ccticas = string;
	}

	/**
	 * @param string
	 */
	public void setCodMov(String string) {
		codMov = string;
	}

	/**
	 * @param string
	 */
	public void setConvenio(String string) {
		convenio = string;
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
	public void setDobEscolCargo(String string) {
		dobEscolCargo = string;
	}

	/**
	 * @param i
	 */
	public void setDobEscolEstab(int i) {
		dobEscolEstab = i;
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
	public void setEscuid(int i) {
		escuid = i;
	}

	/**
	 * @param i
	 */
	public void setEscuidCheque(int i) {
		escuidCheque = i;
	}

	/**
	 * @param string
	 */
	public void setEsDeno(String string) {
		esDeno = string;
	}

	/**
	 * @param string
	 */
	public void setFcion(String string) {
		fcion = string;
	}

	/**
	 * @param i
	 */
	public void setFecAfec(int i) {
		fecAfec = i;
	}

	/**
	 * @param string
	 */
	public void setGarantia(String string) {
		garantia = string;
	}

	/**
	 * @param d
	 */
	public void setHs(double d) {
		hs = d;
	}

	/**
	 * @param d
	 */
	public void setInas(double d) {
		inas = d;
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
	public void setMovilidad(String string) {
		movilidad = string;
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
	public void setNombreEstab(String string) {
		nombreEstab = string;
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
	public void setPin(int i) {
		pin = i;
	}

	/**
	 * @param string
	 */
	public void setPresentismo(String string) {
		presentismo = string;
	}

	/**
	 * @param i
	 */
	public void setRural(int i) {
		rural = i;
	}

	/**
	 * @param i
	 */
	public void setSecciones(int i) {
		secciones = i;
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
	public void setSexo(String string) {
		sexo = string;
	}

	/**
	 * @param string
	 */
	public void setSit(String string) {
		sit = string;
	}

	/**
	 * @param i
	 */
	public void setSubvencion(int i) {
		subvencion = i;
	}

	/**
	 * @param string
	 */
	public void setTipoCheque(String string) {
		tipoCheque = string;
	}

	/**
	 * @param string
	 */
	public void setTipoOpago(String string) {
		tipoOpago = string;
	}

	/**
	 * @param i
	 */
	public void setTurnos(int i) {
		turnos = i;
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
	public void setVigdCar(Date date) {
		vigdCar = date;
	}

	/**
	 * @param date
	 */
	public void setVigdEstab(Date date) {
		vigdEstab = date;
	}

	/**
	 * @param date
	 */
	public void setVigdPers(Date date) {
		vigdPers = date;
	}

	/**
	 * @param date
	 */
	public void setVighCar(Date date) {
		vighCar = date;
	}

	/**
	 * @param date
	 */
	public void setVighEstab(Date date) {
		vighEstab = date;
	}

	/**
	 * @param date
	 */
	public void setVighPers(Date date) {
		vighPers = date;
	}

	/**
	 * @param date
	 */
	public void setVigOpago(Date date) {
		vigOpago = date;
	}

	/**
	 * @return
	 */
	public Date getVigdInt() {
		return vigdInt;
	}

	/**
	 * @param date
	 */
	public void setVigdInt(Date date) {
		vigdInt = date;
	}

	/**
	 * @return
	 */
	public Integer getApartInt() {
		return apartInt;
	}

	/**
	 * @return
	 */
	public String getCcticasInt() {
		return ccticasInt;
	}

	/**
	 * @return
	 */
	public String getCodMovInt() {
		return codMovInt;
	}


	/**
	 * @return
	 */
	public Integer getDistritoInt() {
		return distritoInt;
	}

	/**
	 * @return
	 */
	public Integer getDobEscolEstabInt() {
		return dobEscolEstabInt;
	}

	/**
	 * @return
	 */
	public String getDobEscolInt() {
		return dobEscolInt;
	}

	/**
	 * @return
	 */
	public Integer getEscuidEscart() {
		return escuidEscart;
	}


	/**
	 * @return
	 */
	public Integer getItemInt() {
		return itemInt;
	}

	/**
	 * @return
	 */
	public String getMovInt() {
		return movInt;
	}

	/**
	 * @return
	 */
	public String getNombreEstabInt() {
		return nombreEstabInt;
	}

	/**
	 * @return
	 */
	public String getNomDistInt() {
		return nomDistInt;
	}

	/**
	 * @return
	 */
	public Integer getNumeroInt() {
		return numeroInt;
	}

	/**
	 * @return
	 */
	public Integer getRuralInt() {
		return ruralInt;
	}

	/**
	 * @return
	 */
	public Integer getSeccionesInt() {
		return seccionesInt;
	}

	/**
	 * @return
	 */
	public Integer getSubvencionInt() {
		return subvencionInt;
	}

	/**
	 * @return
	 */
	public Integer getTurnosInt() {
		return turnosInt;
	}

	/**
	 * @return
	 */
	public Date getVigdEstabInt() {
		return vigdEstabInt;
	}

	/**
	 * @return
	 */
	public Date getVighEstabInt() {
		return vighEstabInt;
	}

	/**
	 * @return
	 */
	public Date getVighInt() {
		return vighInt;
	}

	/**
	 * @param i
	 */
	public void setApartInt(Integer i) {
		apartInt = i;
	}

	/**
	 * @param string
	 */
	public void setCcticasInt(String string) {
		ccticasInt = string;
	}

	/**
	 * @param string
	 */
	public void setCodMovInt(String string) {
		codMovInt = string;
	}

	/**
	 * @param i
	 */
	public void setDistritoInt(Integer i) {
		distritoInt = i;
	}

	/**
	 * @param i
	 */
	public void setDobEscolEstabInt(Integer i) {
		dobEscolEstabInt = i;
	}

	/**
	 * @param string
	 */
	public void setDobEscolInt(String string) {
		dobEscolInt = string;
	}

	/**
	 * @param i
	 */
	public void setEscuidEscart(Integer i) {
		escuidEscart = i;
	}


	/**
	 * @param i
	 */
	public void setItemInt(Integer i) {
		itemInt = i;
	}

	/**
	 * @param string
	 */
	public void setMovInt(String string) {
		movInt = string;
	}

	/**
	 * @param string
	 */
	public void setNombreEstabInt(String string) {
		nombreEstabInt = string;
	}

	/**
	 * @param string
	 */
	public void setNomDistInt(String string) {
		nomDistInt = string;
	}

	/**
	 * @param i
	 */
	public void setNumeroInt(Integer i) {
		numeroInt = i;
	}

	/**
	 * @param i
	 */
	public void setRuralInt(Integer i) {
		ruralInt = i;
	}

	/**
	 * @param i
	 */
	public void setSeccionesInt(Integer i) {
		seccionesInt = i;
	}

	/**
	 * @param i
	 */
	public void setSubvencionInt(Integer i) {
		subvencionInt = i;
	}

	/**
	 * @param i
	 */
	public void setTurnosInt(Integer i) {
		turnosInt = i;
	}

	/**
	 * @param date
	 */
	public void setVigdEstabInt(Date date) {
		vigdEstabInt = date;
	}

	/**
	 * @param date
	 */
	public void setVighEstabInt(Date date) {
		vighEstabInt = date;
	}

	/**
	 * @param date
	 */
	public void setVighInt(Date date) {
		vighInt = date;
	}


	/**
	 * @return
	 */
	public Integer getEscuidInt() {
		return escuidInt;
	}

	/**
	 * @return
	 */
	public Double getHsInt() {
		return hsInt;
	}

	/**
	 * @param i
	 */
	public void setEscuidInt(Integer i) {
		escuidInt = i;
	}

	/**
	 * @param d
	 */
	public void setHsInt(Double d) {
		hsInt = d;
	}

 
  	public Cat getCat() {
		return cat;
	}

	/**
	 * @return
	 */
	public Dep getDependencia() {
		return dependencia;
	}

	/**
	 * @return
	 */
	public Reg getReg() {
		return reg;
	}

	/**
	 * @return
	 */
	public Rev getRev() {
		return rev;
	}

	/**
	 * @return
	 */
	public Org getTipoOrg() {
		return tipoOrg;
	}

 	public void setCat(Cat cat) {
		this.cat = cat;
	}

	/**
	 * @param dep
	 */
	public void setDependencia(Dep dep) {
		dependencia = dep;
	}

	/**
	 * @param reg
	 */
	public void setReg(Reg reg) {
		this.reg = reg;
	}

	/**
	 * @param rev
	 */
	public void setRev(Rev rev) {
		this.rev = rev;
	}

	/**
	 * @param org
	 */
	public void setTipoOrg(Org org) {
		tipoOrg = org;
	}

	/**
	 * @return
	 */
	public String getCatInt() {
		return catInt;
	}

	/**
	 * @return
	 */
	public Integer getDependenciaInt() {
		return dependenciaInt;
	}

	/**
	 * @return
	 */
	public String getTipoOrgInt() {
		return tipoOrgInt;
	}

	/**
	 * @param string
	 */
	public void setCatInt(String string) {
		catInt = string;
	}

	/**
	 * @param integer
	 */
	public void setDependenciaInt(Integer integer) {
		dependenciaInt = integer;
	}

	/**
	 * @param string
	 */
	public void setTipoOrgInt(String string) {
		tipoOrgInt = string;
	}

}