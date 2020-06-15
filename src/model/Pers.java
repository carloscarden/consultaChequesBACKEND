package model;

import java.io.Serializable;
import java.util.Date;

public class Pers implements Serializable {
	int pin;
	Date vigd;
	Date vigh;
    String docu;
    String nombre;
    Date alta;
    String sexo;
    	


	public Pers() {
		super();
	}


	public boolean equals(Object o) {
		if (o == null)
		  return false;
		if (this == o)
		  return true;
		if (!(o instanceof Pers))
		  return false;
		final Pers elem = (Pers)o;
		
		if (this.getPin() != elem.getPin())
		  return false;
		
		if (!this.getVigd().equals(elem.getVigd()))
		  return false;
		
		if (!this.getVigh().equals(elem.getVigh()))
		  return false;
		  
		return true;

	}

	public int hashCode() {
		int result = 14;
		result = 29 * result + getPin() + getVigd().hashCode() + getVigh().hashCode();
		return result;
	}

	public Date getAlta() {
		return alta;
	}


	public String getDocu() {
		return docu;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPin() {
		return pin;
	}

	public String getSexo() {
		return sexo;
	}

    public Date getVigd() {
		return vigd;
	}

	public Date getVigh() {
		return vigh;
	}

	public void setAlta(Date date) {
		alta = date;
	}

	public void setDocu(String string) {
		docu = string;
	}

	public void setNombre(String string) {
		nombre = string;
	}

	public void setPin(int i) {
		pin = i;
	}

	public void setSexo(String string) {
		sexo = string;
	}

	public void setVigd(Date date) {
		vigd = date;
	}

	public void setVigh(Date date) {
		vigh = date;
	}




}