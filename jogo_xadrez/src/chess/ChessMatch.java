package chess;

import boardGame.Board;
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
	
	/*
	 * Fará método responsável por iniciar a partida de xadrez colocando as peças no tabuleiro
	 * Usará método para converter da posição de matriz para o sistema de coordenadas do xadrez
	 */
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('b', 6, new Torre(board, Color.WHITE));
		placeNewPiece('e', 8, new Rei(board, Color.BLACK));
		placeNewPiece('e', 1, new Rei(board, Color.WHITE));


	}
}
