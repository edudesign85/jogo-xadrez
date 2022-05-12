package boardGame;

public class Piece {
	
	protected Position position;
	private Board board;
	
	/*
	 * passará apenas o tabuleiro, pois a posição inicialmente é nula
	 * não era necessário declarar, pois Java já colocaria como nulo, pois não estava no construtor
	 * Colocará o null para destacar
	 * tirará o set para não permitir que o tabuleiro seja alterado facilmente e evite erros de programadores
	 * deixará protected, pois somente classes no mesmo pacote e subclasses poderão acessar o tabuleiro de uma peça
	 */
	
	public Piece(Board board) { 
		this.board = board;
		position = null;   
	}
	protected Board getBoard() {
		return board;
	}
}
