package chess.pieces;

import boardGame.Board;
import chess.ChessPiece;
import chess.Color;

public class Torre extends ChessPiece {

	public Torre(Board board, Color color) {
		super(board, color); // construtor apenas pegou dados e repassou a chamada para a superclasse ChessPiece
	}
	
	/*
	 * Converterá a peça em sua primeira letra em string para imprimir no tabuleiro
	 */
	
	@Override
	public String toString() {
		return "T";
	}
	
	

}
