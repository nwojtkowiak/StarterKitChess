package com.capgemini.chess.algorithms.piecesValidators;

import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.generated.Board;

public class BishopMoveValidator extends PieceMoveValidator {

	public BishopMoveValidator(Move move, Board board) {
		super(move.getFrom().getX(),move.getFrom().getY(), move.getTo().getX(),move.getTo().getY(), board);
	}
	

	@Override
	public boolean moveConditions() {

		BishopMove bishopMove = new BishopMove(xFrom, yFrom, xTo, yTo);
		if(bishopMove.check()){
			return bishopMove.isAllPathFree(board);
		}

		return false;
	}



}
