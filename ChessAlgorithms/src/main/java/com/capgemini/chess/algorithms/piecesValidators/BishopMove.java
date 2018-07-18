package com.capgemini.chess.algorithms.piecesValidators;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.generated.Board;

public class BishopMove {
//TODO przeniesc jako parametr Move
	private int xFrom;
	private int yFrom;
	private int xTo;
	private int yTo;

	public BishopMove(int xFrom, int yFrom, int xTo, int yTo) {
		this.xFrom = xFrom;
		this.yFrom = yFrom;
		this.xTo = xTo;
		this.yTo = yTo;
	}

	public boolean isAllPathFree(Board board){
		
		Coordinate coordinate;
		
		int factorX = 1, factorY = 1;
		if( yTo < yFrom ){
			factorY = -1;
		}
		if( xTo < xFrom){
			factorX = -1;
		}
		
		for(int x = xFrom + factorX, y = yFrom + factorY; Math.abs(x - xTo) > 0; x += factorX, y+=factorY ){
			coordinate = new Coordinate(x, y);
			
			if(board.getPieceAt(coordinate) != null){
				return false;
			}
		}
		
		return true;
	}
	
	public boolean check() {
		//if (Math.abs(xFrom - yFrom) == Math.abs(xTo - yTo)) {
		if (Math.abs(xFrom - xTo) == Math.abs(yFrom - yTo)) {
			return true;
		}

		return false;
	}

}
