package chess;

import boardGame.Board;
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
	
	/*
	 * Fará método responsável por iniciar a partida de xadrez colocando as peças no tabuleiro
	 */
	
	private void initialSetup() {
		board.placePiece(new Torre(board, Color.WHITE), new Position(2, 1));
		board.placePiece(new Rei(board, Color.BLACK), new Position(0, 4));
		board.placePiece(new Rei(board, Color.WHITE), new Position(7, 4));


	}
}
