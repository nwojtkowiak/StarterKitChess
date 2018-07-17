package com.capgemini.chess.algorithms.pieces;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.pieces.interfaces.PiecesInterface;

public class Bishop implements PiecesInterface {

	private int xFrom;
	private int yFrom;
	private int xTo;
	private int yTo;
	
	private Board board;

	
	public Bishop(Move move, Board board) {
		
		this.xFrom = move.getFrom().getX();
		this.yFrom = move.getFrom().getY();
		this.xTo = move.getTo().getX();
		this.yTo = move.getTo().getY();
		
		this.board = board;
	}
	
	public boolean isAllPathFree(){
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

	@Override
	public boolean moveConditions() {

		if (Math.abs(xFrom - yFrom) == Math.abs(xTo - yTo) ) {
				return isAllPathFree();
		}

		return false;
	}



}
