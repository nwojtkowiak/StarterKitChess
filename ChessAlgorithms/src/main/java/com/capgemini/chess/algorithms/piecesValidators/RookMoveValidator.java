package com.capgemini.chess.algorithms.piecesValidators;

import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.generated.Board;

public class RookMoveValidator extends PieceMoveValidator {

	public RookMoveValidator() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean moveConditions(Move move, Board board) {

		int xFrom = move.getFrom().getX();
		int yFrom = move.getFrom().getY();
		int xTo = move.getTo().getX();
		int yTo = move.getTo().getY();

		RookMove rookMove = new RookMove(xFrom, yFrom, xTo, yTo);
		if (rookMove.check()) {
			return rookMove.isAllPathFree(board);
		}

		return false;
	}

}
