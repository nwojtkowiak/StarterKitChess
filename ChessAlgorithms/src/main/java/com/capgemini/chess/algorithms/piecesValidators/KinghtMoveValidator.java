package com.capgemini.chess.algorithms.piecesValidators;


import com.capgemini.chess.algorithms.data.Move;

public class KinghtMoveValidator extends PieceMoveValidator{

	public KinghtMoveValidator(Move move) {
		super(move.getFrom().getX(), move.getFrom().getY(), move.getTo().getX(), move.getTo().getY());
	}
	
	@Override
	public boolean moveConditions() {
		
		if(xFrom - 1 == xTo || xFrom + 1 == xTo){
			if(yFrom + 2 == yTo || yFrom - 2  == yTo){
				return true;
			}
		}else if(xFrom - 2 == xTo || xFrom + 2 == xTo){
			if(yFrom + 1 == yTo || yFrom - 1  == yTo){
				return true;
			}
		}
		return false;
	}



}
