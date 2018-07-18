package com.capgemini.chess.algorithms.piecesValidators;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.enums.PieceType;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.data.patterns.PiecesMoveFactory;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class KingMoveValidator extends PieceMoveValidator {

	private Board board;
	private Color color;

	public KingMoveValidator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KingMoveValidator(Color color) {
		this.color = color;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	@Override
	public boolean moveConditions(Move move, Board board) {
		
		int xFrom = move.getFrom().getX();
		int yFrom = move.getFrom().getY();
		int xTo = move.getTo().getX();
		int yTo = move.getTo().getY();
		

		if ((xTo >= xFrom - 1 && xTo <= xFrom + 1) && (yTo >= yFrom - 1 && yTo <= yFrom + 1)) {
			return true;

		}
		return false;
	}

	public Coordinate whereIs() {

		Piece[][] pieces = board.getPieces();
		Coordinate coordinate = new Coordinate(0, 0);
		PieceType pieceType;
		Color color;

		for (int x = 0; x < board.SIZE; x++) {
			for (int y = 0; y < board.SIZE; y++) {
				if (pieces[x][y] != null) {
					pieceType = pieces[x][y].getType();
					color = pieces[x][y].getColor();
					if (pieceType == PieceType.KING && color == this.color) {
						coordinate = new Coordinate(x, y);
					}
				}
			}
		}

		return coordinate;

	}

	public boolean isCheck() {

		Coordinate kingCoordinate = whereIs();
		Coordinate coordinate;
		PiecesMoveFactory pieceFactory = new PiecesMoveFactory(board);
		Move move = new Move();
		Piece piece;
		boolean result = false;

		move.setTo(kingCoordinate);
		move.setType(MoveType.CAPTURE);

		for (int x = 0; x < board.SIZE; x++) {
			for (int y = 0; y < board.SIZE; y++) {

				coordinate = new Coordinate(x, y);

				if (board.getPieceAt(coordinate) != null) {

					piece = board.getPieceAt(coordinate);

					if (!(piece.getColor() == this.color)) {

						move.setFrom(coordinate);
						move.setMovedPiece(piece);

						if (pieceFactory.checkPath(move)) {
							return true;
						}
					}
				}
			}
		}
		return result;
	}

}
