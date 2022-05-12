package boardGame;

public class Piece {
	
	protected Position position;
	private Board board;
	
	/*
	 * passar� apenas o tabuleiro, pois a posi��o inicialmente � nula
	 * n�o era necess�rio declarar, pois Java j� colocaria como nulo, pois n�o estava no construtor
	 * Colocar� o null para destacar
	 * tirar� o set para n�o permitir que o tabuleiro seja alterado facilmente e evite erros de programadores
	 * deixar� protected, pois somente classes no mesmo pacote e subclasses poder�o acessar o tabuleiro de uma pe�a
	 */
	
	public Piece(Board board) { 
		this.board = board;
		position = null;   
	}
	protected Board getBoard() {
		return board;
	}
}
