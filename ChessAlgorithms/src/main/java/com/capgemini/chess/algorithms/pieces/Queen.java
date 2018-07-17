package com.capgemini.chess.algorithms.pieces;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.pieces.interfaces.PiecesInterface;

public class Queen extends Bishop{
	
	private int xFrom;
	private int yFrom;
	private int xTo;
	private int yTo;
	private Board board;

	public Queen(Move move, Board board) {
		super(move, board);
		
		this.xFrom = move.getFrom().getX();
		this.yFrom = move.getFrom().getY();
		this.xTo = move.getTo().getX();
		this.yTo = move.getTo().getY();
		this.board = board;
	}
	
	public boolean isAllPathFree(){
		
		Coordinate coordinate;
		
		int factor = 1;
		if( yTo < yFrom || xTo < xFrom){
			factor = -1;
		}
		
		if(yTo != yFrom){
			for(int y = yFrom + factor; Math.abs(yTo - y) > 0; y += factor){
				coordinate = new Coordinate(xTo, y);
				if(board.getPieceAt(coordinate) != null){
					return false;
				}
			}
		}else{
			for(int x = xFrom + factor; Math.abs(xTo - x) > 0; x += factor){
				coordinate = new Coordinate(x, yTo);
				if(board.getPieceAt(coordinate) != null){
					return false;
				}
			}
		}
		
		return super.isAllPathFree();
	}
	
	
	@Override
	public boolean moveConditions() {
		
		//move as Rook
		if ((xFrom == xTo) || (yFrom == yTo)) {
				return isAllPathFree();
		}
		//move as Bishop
		return super.moveConditions();
	}


}
