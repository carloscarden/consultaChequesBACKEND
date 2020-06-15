package model;

import java.io.Serializable;

public class ChequesParaImprimir implements Serializable {
	public  DetCodigo codigosCheque;
	public DetCheque detalleCheque;



	public DetCodigo getCodigosCheque() {
		return codigosCheque;
	}


	public void setCodigosCheque(DetCodigo codigosCheque) {
		this.codigosCheque = codigosCheque;
	}


	public DetCheque getDetalleCheque() {
		return detalleCheque;
	}


	public void setDetalleCheque(DetCheque detalleCheque) {
		this.detalleCheque = detalleCheque;
	}


	public ChequesParaImprimir() {
		super();
		// p Auto-generated constructor stub
	}

}
