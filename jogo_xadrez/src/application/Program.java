package application;

import boardGame.Board;
import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {
		
		/* 
		 * instanciará uma partida de xadrex e imprimirá o tabuleiro da partida com um método da classe UI
		 */
		
		ChessMatch chessMatch = new ChessMatch();
		UI.printBoard(chessMatch.getPieces());

	}
}
