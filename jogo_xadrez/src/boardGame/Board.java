package boardGame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
	
	/*
	 * Far� o m�todo respons�vel por atribuir (colocar) uma pe�a na posi��o do tabuleiro na matriz de pe�a
	 * pegar� a matriz pieces na posi��o dada, linha e coluna, e atribuiu a ela a pe�a piece informada
	 * Por �ltimo, falara que a pe�a n�o estar� mais na posi��o nula, mas sim receber� a nova posi��o position informada
	 */
	
	public void placePiece(Piece piece, Position position) {
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	               
}
