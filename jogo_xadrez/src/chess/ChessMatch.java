package chess;

import boardGame.Board;
import boardGame.Position;
import chess.pieces.Rei;
import chess.pieces.Torre;


/*
 * Classe cora��o do jogo de xadrez
 * Aqui estar�o todas as regras e dados do jogo, como a dimens�o do tabuleiro do Board
 */

public class ChessMatch {
	
	private Board board;
	
	public ChessMatch () {
		board = new Board(8, 8); // especificou a dimens�o do tabuleiro
		initialSetup();
	}

	/* far� um m�todo para mostrar as camadas de xadrez, com as pe�as e tabuleiro, e n�o somente as partes do tabuleiro
	* far� um downcasting da classe board com o (ChessPiece) para indicar que � pe�a de xadrez e n�o comum
	* percorrer� a matriz de pe�as de board e far� donwcasting para a matriz mat
	* pegar� as informa��es do board para essa camada final de ChessPiece
	* retornar� mat, a matriz de pe�as da partida de xadrez
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
	 * Far� m�todo respons�vel por iniciar a partida de xadrez colocando as pe�as no tabuleiro
	 */
	
	private void initialSetup() {
		board.placePiece(new Torre(board, Color.WHITE), new Position(2, 1));
		board.placePiece(new Rei(board, Color.BLACK), new Position(0, 4));
		board.placePiece(new Rei(board, Color.WHITE), new Position(7, 4));


	}
}
