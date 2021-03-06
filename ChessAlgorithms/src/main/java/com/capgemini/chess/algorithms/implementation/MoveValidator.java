package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.data.patterns.PiecesMoveFactory;
import com.capgemini.chess.algorithms.implementation.exceptions.EmptyFromFieldException;
import com.capgemini.chess.algorithms.implementation.exceptions.IndexOutOfRangeException;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidColorPieceException;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class MoveValidator {

	private Coordinate from;
	private Coordinate to;
	private Piece pieceFrom;
	private Piece pieceTo;

	
	public void setFrom(Coordinate from) {
		this.from = from;
	}

	public void setTo(Coordinate to) {
		this.to = to;
	}

	public void setPieceFrom(Piece pieceFrom) {
		this.pieceFrom = pieceFrom;
	}

	public void setPieceTo(Piece pieceTo) {
		this.pieceTo = pieceTo;
	}
	
	public MoveValidator(Coordinate from, Coordinate to) throws InvalidMoveException {

		this.from = from;
		this.to = to;
		validateRangeOfIndex();
	}

	public void setPieces(Piece pieceFrom, Piece pieceTo) {

		this.pieceFrom = pieceFrom;
		this.pieceTo = pieceTo;
	}

	public MoveValidator() {
	}

	private boolean validateCoordinate(Coordinate coordinate) {

		int x = coordinate.getX();
		int y = coordinate.getY();

		if (x >= 0 && x < 8 && y >= 0 && y < 8) {
			return true;
		}

		return false;
	}

	public void validateRangeOfIndex() throws IndexOutOfRangeException {

		if (!(validateCoordinate(from) && validateCoordinate(to))) {
			throw new IndexOutOfRangeException();
		}

	}

	public Move validateMovePiece(Color nextColor, Board board) throws InvalidMoveException {

		MoveType moveType = checkMoveType(nextColor);

		Move move = new Move(from, to);

		move.setMovedPiece(pieceFrom);
		move.setFrom(from);
		move.setTo(to);
		move.setType(moveType);

		PiecesMoveFactory factory = new PiecesMoveFactory(board);

		if (!factory.checkPath(move)) {
			throw new InvalidMoveException();
		}

		return move;
	}

	public MoveType checkMoveType(Color nextColor) throws InvalidColorPieceException, EmptyFromFieldException {

		if (pieceFrom == null) {
			throw new EmptyFromFieldException();
		}

		Color color = pieceFrom.getColor();

		if (!(color == nextColor)) {
			throw new InvalidColorPieceException("This piece is not yours");
		}

		if (pieceTo == null) {

			return MoveType.ATTACK;

		} else {

			Color colorFrom = pieceFrom.getColor();
			Color colorTo = pieceTo.getColor();

			if (!(colorTo == colorFrom)) {
				return MoveType.CAPTURE;
			}

		}

		throw new InvalidColorPieceException("This piece is yours");

	}

	//search piece from nextColor
	public Move checkAnyValidMove(Color nextColor, Board board) {

		PiecesMoveFactory piecesFactory = new PiecesMoveFactory(board);

		Piece piece;
		Coordinate coordinateFrom;
		Move move = new Move();

		for (int x = 0; x < board.SIZE; x++) {
			for (int y = 0; y < board.SIZE; y++) {

				coordinateFrom = new Coordinate(x, y);
				piece = board.getPieceAt(coordinateFrom);

				if (piece != null && piece.getColor() == nextColor) {
					move.setFrom(coordinateFrom);
					move.setMovedPiece(piece);

					Coordinate coordinateTo = piecesFactory.checkIsAnyMove(move);
					
					if (!coordinateFrom.equals(coordinateTo)) {
						move.setTo(coordinateTo);
						move.setMovedPiece(piece);

						return move;
					}

				}
			}
		}

		return move;
	}

}
