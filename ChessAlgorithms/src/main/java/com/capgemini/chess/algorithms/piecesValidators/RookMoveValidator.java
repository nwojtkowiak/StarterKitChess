package com.capgemini.chess.algorithms.piecesValidators;

import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.generated.Board;

public class RookMoveValidator extends PieceMoveValidator {

	public RookMoveValidator(Move move, Board board) {
		super(move.getFrom().getX(),move.getFrom().getY(), move.getTo().getX(),move.getTo().getY(), board);
	}

	@Override
	public boolean moveConditions() {

		RookMove rookMove = new RookMove(xFrom, yFrom, xTo, yTo);
		if (rookMove.check()) {
			return rookMove.isAllPathFree(board);
		}

		return false;
	}
	

}
