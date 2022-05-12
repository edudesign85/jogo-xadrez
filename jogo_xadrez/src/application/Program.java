package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		/* 
		 * instanciará uma partida de xadrex e imprimirá o tabuleiro da partida com um método da classe UI
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
