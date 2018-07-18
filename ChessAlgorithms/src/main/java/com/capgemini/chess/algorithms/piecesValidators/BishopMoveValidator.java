package com.capgemini.chess.algorithms.piecesValidators;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.generated.Board;

public class BishopMoveValidator extends PieceMoveValidator {

	
	public BishopMoveValidator() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean moveConditions(Move move, Board board) {
		int xFrom = move.getFrom().getX();
		int yFrom = move.getFrom().getY();
		int xTo = move.getTo().getX();
		int yTo = move.getTo().getY();
		
	
		BishopMove bishopMove = new BishopMove(xFrom, yFrom, xTo, yTo);
		if(bishopMove.check()){
			return bishopMove.isAllPathFree(board);
		}

		return false;
	}



}
