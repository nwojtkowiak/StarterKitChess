package com.capgemini.chess.algorithms.pieces;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.pieces.interfaces.PiecesInterface;

public class Pawn implements PiecesInterface {

	private Coordinate from;
	private Coordinate to;
	private Color color;
	MoveType moveType;

	public Pawn(Move move) {
		this.from = move.getFrom();
		this.to = move.getTo();
		this.moveType = move.getType();
		this.color = move.getMovedPiece().getColor();
	}

	private boolean moveConditionsWhenAttack(int startY, int multiply) {
		
		if (from.getX() == to.getX()) {
			if (from.getY() == startY) {
				if (from.getY() + 2 * multiply == to.getY()) {
					return true;
				}
			} else {
				if (from.getY() + 1 * multiply == to.getY()) {
					return true;
				}
			}

		}
		return false;
	}

	private boolean moveConditionsWhenCapture(int startY, int multiply) {

		if ((from.getX() - 1 == to.getX()) || (from.getX() + 1 == to.getX())) {

			if (from.getY() == startY) {
				if (from.getY() + 2 * multiply == to.getY()) {
					return true;
				}
			} else {
				if (from.getY() + 1 * multiply == to.getY()) {
					return true;
				}
			}

		}
		return false;

	}

	@Override
	public boolean moveConditions() {
		int startY;
		int multiply;

		if (color.equals(Color.WHITE)) {
			startY = 1;
			multiply = 1;
		} else {
			startY = 6;
			multiply = -1;
		}

		// when destination field is empty
		if (this.moveType.equals(MoveType.ATTACK)) {
			return moveConditionsWhenAttack(startY, multiply);
			// when destination field is not empty
		} else if (this.moveType.equals(MoveType.CAPTURE)) {
			return moveConditionsWhenCapture(startY, multiply);
		}
		
	

		return false;
	}

	@Override
	public boolean validateMove() throws InvalidMoveException {

		if (moveConditions()) {
			return true;
		}

		throw new InvalidMoveException();
	}

}
