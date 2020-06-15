package exception;

public class AccesoAutorizadoException extends Exception {

	private static final long serialVersionUID = -273720467019037489L;
	/**
	 * 
	 */
	public AccesoAutorizadoException(){
		super();
	}
	public AccesoAutorizadoException(String msg){
		super(msg);
	}

}
