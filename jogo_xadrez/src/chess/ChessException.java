package chess;

public class ChessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	/*
	 * far� m�todo apenas para passar mensagem para a superclasse RuntimeException
	 */
	
	public ChessException(String msg) {
		super(msg);
	}
}


