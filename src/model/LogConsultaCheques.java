package model;

import java.io.Serializable;
import java.util.Date;

public class LogConsultaCheques implements Serializable {
    int id;
    String docuConsulta;
    int secuConsulta;
    int ejercicioConsulta;
    String usuario;
    Date fechaConsulta;
 	
	public LogConsultaCheques() {
		super();
	}


	public boolean equals(Object o) {
		LogConsultaCheques elem = (LogConsultaCheques)o; 
		if (this.getId() != elem.getId()){
			return true;
		}else{
			return false;
		}
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDocuConsulta() {
		return docuConsulta;
	}


	public void setDocuConsulta(String docuConsulta) {
		this.docuConsulta = docuConsulta;
	}


	public int getSecuConsulta() {
		return secuConsulta;
	}


	public void setSecuConsulta(int secuConsulta) {
		this.secuConsulta = secuConsulta;
	}


	public int getEjercicioConsulta() {
		return ejercicioConsulta;
	}


	public void setEjercicioConsulta(int ejercicioConsulta) {
		this.ejercicioConsulta = ejercicioConsulta;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public Date getFechaConsulta() {
		return fechaConsulta;
	}


	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}
	

}