package com.capgemini.chess.algorithms.piecesValidators;


import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.generated.Board;

public class KinghtMoveValidator extends PieceMoveValidator{

	public KinghtMoveValidator() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//TODO zmienic aby nie mialo board w parametrze
	@Override
	public boolean moveConditions(Move move, Board board) {
		
		int xFrom = move.getFrom().getX();
		int yFrom = move.getFrom().getY();
		int xTo = move.getTo().getX();
		int yTo = move.getTo().getY();
		
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
