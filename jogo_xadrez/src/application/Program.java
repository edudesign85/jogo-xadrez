package application;

import boardGame.Board;
import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {
		
		/* 
		 * instanciar� uma partida de xadrex e imprimir� o tabuleiro da partida com um m�todo da classe UI
		 */
		
		ChessMatch chessMatch = new ChessMatch();
		UI.printBoard(chessMatch.getPieces());

	}
}
