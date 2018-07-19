package com.capgemini.chess.algorithms.piecesValidators;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.enums.PieceType;
import com.capgemini.chess.algorithms.data.generated.Board;

public class PawnMoveValidator extends PieceMoveValidator {

	public PawnMoveValidator() {
	}

	public boolean isAllPathFree(int xFrom, int yFrom, int factor, Board board) {

		Coordinate coordinate = new Coordinate(xFrom, yFrom + factor);
		Piece piece = board.getPieceAt(coordinate);

		if (piece != null) {
			return false;
		}

		return true;
	}

	private boolean moveConditionsWhenAttack(Move move, int startY, int factor, Board board) {
		int xFrom = move.getFrom().getX();
		int yFrom = move.getFrom().getY();
		int xTo = move.getTo().getX();
		int yTo = move.getTo().getY();

		if (xFrom == xTo) {
			if (yFrom == startY) {
				if (yFrom + 2 * factor == yTo) {
					return isAllPathFree(xFrom, yFrom, factor, board);
				} else if (yFrom + 1 * factor == yTo) {
					return true;
				}
			} else {
				if (yFrom + 1 * factor == yTo) {
					return true;
				}
			}

		}
		return false;
	}

	private MoveType checkEnPassant(MoveType moveType, Board board) {
		int sizeHistory = board.getMoveHistory().size();
		Move lastMove;

		if (sizeHistory > 0) {
			lastMove = board.getMoveHistory().get(sizeHistory - 1);
		} else {
			return moveType;
		}

		Coordinate from = lastMove.getFrom();
		Coordinate to = lastMove.getTo();

		if (lastMove.getMovedPiece().getType() == PieceType.PAWN) {

			if (from.getY() + 2 == to.getY() || from.getY() - 2 == to.getY()) {
				return MoveType.EN_PASSANT;
			}
		}

		return moveType;

	}

	private boolean moveConditionsWhenCapture(Move move, int startY, int factor) {

		int xFrom = move.getFrom().getX();
		int yFrom = move.getFrom().getY();
		int xTo = move.getTo().getX();
		int yTo = move.getTo().getY();

		if ((xFrom - 1 == xTo) || (xFrom + 1 == xTo)) {

			if (yFrom + 1 * factor == yTo) {
				return true;
			}

		}
		return false;

	}

	@Override
	public boolean moveConditions(Move move, Board board) {
		Color color = move.getMovedPiece().getColor();
		MoveType moveType = move.getType();

		// when white
		int startY = 1;
		int factor = 1;

		// when black then change
		if (color == Color.BLACK) {
			startY = 6;
			factor = -1;
		}

		moveType = checkEnPassant(moveType, board);
		// when destination field is empty
		if (moveType == MoveType.ATTACK) {

			return moveConditionsWhenAttack(move, startY, factor, board);

			// when destination field is not empty
		} else if (moveType == MoveType.CAPTURE) {

			return moveConditionsWhenCapture(move, startY, factor);

		} else if (moveType == MoveType.EN_PASSANT) {
			if (moveConditionsWhenCapture(move, startY, factor)) {
				move.setType(moveType);
				return true;
			}
			return moveConditionsWhenAttack(move, startY, factor, board);

		}

		return false;
	}

}
