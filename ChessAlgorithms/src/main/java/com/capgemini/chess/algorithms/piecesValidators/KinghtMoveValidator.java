package com.capgemini.chess.algorithms.piecesValidators;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.pieces.interfaces.PiecesMoveValidatorInterface;

public class KinghtMoveValidator implements PiecesMoveValidatorInterface{

	private int xFrom;
	private int yFrom;
	private int xTo;
	private int yTo;

	public KinghtMoveValidator(Move move) {
		this.xFrom = move.getFrom().getX();
		this.yFrom = move.getFrom().getY();
		this.xTo = move.getTo().getX();
		this.yTo = move.getTo().getY();
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
