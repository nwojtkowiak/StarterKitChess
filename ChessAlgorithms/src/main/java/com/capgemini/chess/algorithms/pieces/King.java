package com.capgemini.chess.algorithms.pieces;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.pieces.interfaces.PiecesInterface;

public class King implements PiecesInterface{

	private Coordinate from;
	private Coordinate to;

	public King(Move move) {
		this.from = move.getFrom();
		this.to = move.getTo();
	}
	
	@Override
	public boolean moveConditions() {
		int xFrom = this.from.getX();
		int xTo = this.to.getX();
		int yFrom = this.from.getY();
		int yTo = this.to.getY();
		
		if((xFrom + 1 == xTo || xFrom - 1 == xTo) &&  yFrom == yTo){
			
			return true;
			
		}else if( xFrom - 1 == xTo || xFrom + 1 == xTo ){
			
			if(  yTo <= yFrom -1  && yFrom +1 <= yTo ){
				
				return true;
			}
			
		}
		return false;
	}

	

}
