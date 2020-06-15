package model;

import java.io.Serializable;
import java.util.Date;

public class CambDoc implements Serializable {
    int idcambdoc;
    String docunew;
    int secunew;
    String docuold;
    int secuold;
    String esdeno;
    int idant;
    int idsig;
    Date vigh;
	Date vigd;
	
	public CambDoc() {
		super();
	}


	public boolean equals(Object o) {
		if (o == null)
		  return false;
		if (this == o)
		  return true;
		if (!(o instanceof CambDoc))
		  return false;
		final CambDoc elem = (CambDoc)o;

		if (this.getIdcambdoc() != elem.getIdcambdoc())
		  return false;
		
		return true;
	}

	/**
	 * @return
	 */
	public String getDocunew() {
		return docunew;
	}

	/**
	 * @return
	 */
	public String getDocuold() {
		return docuold;
	}

	/**
	 * @return
	 */
	public String getEsdeno() {
		return esdeno;
	}

	/**
	 * @return
	 */
	public int getIdant() {
		return idant;
	}

	/**
	 * @return
	 */
	public int getIdcambdoc() {
		return idcambdoc;
	}

	/**
	 * @return
	 */
	public int getIdsig() {
		return idsig;
	}

	/**
	 * @return
	 */
	public int getSecunew() {
		return secunew;
	}

	/**
	 * @return
	 */
	public int getSecuold() {
		return secuold;
	}

	/**
	 * @return
	 */
	public Date getVigd() {
		return vigd;
	}

	/**
	 * @return
	 */
	public Date getVigh() {
		return vigh;
	}

	/**
	 * @param string
	 */
	public void setDocunew(String string) {
		docunew = string;
	}

	/**
	 * @param string
	 */
	public void setDocuold(String string) {
		docuold = string;
	}

	/**
	 * @param string
	 */
	public void setEsdeno(String string) {
		esdeno = string;
	}

	/**
	 * @param i
	 */
	public void setIdant(int i) {
		idant = i;
	}

	/**
	 * @param i
	 */
	public void setIdcambdoc(int i) {
		idcambdoc = i;
	}

	/**
	 * @param i
	 */
	public void setIdsig(int i) {
		idsig = i;
	}

	/**
	 * @param i
	 */
	public void setSecunew(int i) {
		secunew = i;
	}

	/**
	 * @param i
	 */
	public void setSecuold(int i) {
		secuold = i;
	}

	/**
	 * @param date
	 */
	public void setVigd(Date date) {
		vigd = date;
	}

	/**
	 * @param date
	 */
	public void setVigh(Date date) {
		vigh = date;
	}

}