package chess;

import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;
import chess.pieces.Rei;
import chess.pieces.Torre;


/*
 * Classe coração do jogo de xadrez
 * Aqui estarão todas as regras e dados do jogo, como a dimensão do tabuleiro do Board
 */

public class ChessMatch {
	
	private Board board;
	
	public ChessMatch () {
		board = new Board(8, 8); // especificou a dimensão do tabuleiro
		initialSetup();
	}

	/* fará um método para mostrar as camadas de xadrez, com as peças e tabuleiro, e não somente as partes do tabuleiro
	* fará um downcasting da classe board com o (ChessPiece) para indicar que é peça de xadrez e não comum
	* percorrerá a matriz de peças de board e fará donwcasting para a matriz mat
	* pegará as informações do board para essa camada final de ChessPiece
	* retornará mat, a matriz de peças da partida de xadrez
	*/
	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()]; // aqui pegou dados de board
		for (int i=0; i<board.getRows(); i++) {
			for (int j=0; j<board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j); // aqui fez o downcasting com (ChessPiece)
			}
		}
		return mat;
	}
	
	// implementará método para mover peça de um ponto a outro, de um ponto de origem para um ponto de destino
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition(); // convertendo as duas posições para posição de matriz
		Position target = targetPosition.toPosition();
		validateSourcePosition(source); // validará se existe a posição de origem com método criado mais abaixo
		Piece capturedPiece = makeMove(source, target); // variável receberá resultado do makeMove, método abaixo para mover as peças já na posição do formato de matriz
		return (ChessPiece)capturedPiece; // fez downcast da variável, pois era do tipo Piece, superclasse de ChessPiece
	}
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source); //retirou a peça da posição de origem
		Piece capturedPiece = board.removePiece(target); // removeu a possível peça da posição de destino e será a peça capturada
		board.placePiece(p, target); // colocou a peça p retirada na posição de destino
		return capturedPiece;
	}
	
	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}
	}
	
	/*
	 * Fará método responsável por iniciar a partida de xadrez colocando as peças no tabuleiro
	 * Usará método para converter da posição de matriz para o sistema de coordenadas do xadrez
	 */
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('c', 1, new Torre(board, Color.WHITE));
        placeNewPiece('c', 2, new Torre(board, Color.WHITE));
        placeNewPiece('d', 2, new Torre(board, Color.WHITE));
        placeNewPiece('e', 2, new Torre(board, Color.WHITE));
        placeNewPiece('e', 1, new Torre(board, Color.WHITE));
        placeNewPiece('d', 1, new Rei(board, Color.WHITE));

        placeNewPiece('c', 7, new Torre(board, Color.BLACK));
        placeNewPiece('c', 8, new Torre(board, Color.BLACK));
        placeNewPiece('d', 7, new Torre(board, Color.BLACK));
        placeNewPiece('e', 7, new Torre(board, Color.BLACK));
        placeNewPiece('e', 8, new Torre(board, Color.BLACK));
        placeNewPiece('d', 8, new Rei(board, Color.BLACK));
	}
}
