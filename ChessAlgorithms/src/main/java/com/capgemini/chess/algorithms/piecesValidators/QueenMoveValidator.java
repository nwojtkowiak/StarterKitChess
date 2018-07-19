package com.capgemini.chess.algorithms.piecesValidators;

import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.generated.Board;

public class QueenMoveValidator extends PieceMoveValidator {

	public QueenMoveValidator() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean moveConditions(Move move, Board board) {

		int xFrom = move.getFrom().getX();
		int yFrom = move.getFrom().getY();
		int xTo = move.getTo().getX();
		int yTo = move.getTo().getY();

		// move as Rook
		RookMove rookMove = new RookMove(xFrom, yFrom, xTo, yTo);
		if (rookMove.check()) {
			return rookMove.isAllPathFree(board);
		}

		// move as Bishop
		BishopMove bishopMove = new BishopMove(xFrom, yFrom, xTo, yTo);
		if (bishopMove.check()) {
			return bishopMove.isAllPathFree(board);
		}

		return false;
	}

}
