package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		/* 
		 * instanciar� uma partida de xadrex e imprimir� o tabuleiro da partida com um m�todo da classe UI
		 */
		
		Scanner sc = new  Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch ();

		while (true) {
			UI.printBoard(chessMatch.getPieces());
			System.out.println();
			System.out.print("Source: ");
			ChessPosition source = UI.readChessPosition(sc);
	
			System.out.println();
			System.out.print("Target: ");
			ChessPosition target = UI.readChessPosition(sc);
	
			ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
		}
	}
}
