package chess;

import boardGame.Board;
import boardGame.Piece;
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
	
	// implementar� m�todo para mover pe�a de um ponto a outro, de um ponto de origem para um ponto de destino
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition(); // convertendo as duas posi��es para posi��o de matriz
		Position target = targetPosition.toPosition();
		validateSourcePosition(source); // validar� se existe a posi��o de origem com m�todo criado mais abaixo
		Piece capturedPiece = makeMove(source, target); // vari�vel receber� resultado do makeMove, m�todo abaixo para mover as pe�as j� na posi��o do formato de matriz
		return (ChessPiece)capturedPiece; // fez downcast da vari�vel, pois era do tipo Piece, superclasse de ChessPiece
	}
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source); //retirou a pe�a da posi��o de origem
		Piece capturedPiece = board.removePiece(target); // removeu a poss�vel pe�a da posi��o de destino e ser� a pe�a capturada
		board.placePiece(p, target); // colocou a pe�a p retirada na posi��o de destino
		return capturedPiece;
	}
	
	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}
	}
	
	/*
	 * Far� m�todo respons�vel por iniciar a partida de xadrez colocando as pe�as no tabuleiro
	 * Usar� m�todo para converter da posi��o de matriz para o sistema de coordenadas do xadrez
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
