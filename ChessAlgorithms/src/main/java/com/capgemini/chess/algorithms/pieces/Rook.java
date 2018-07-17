package com.capgemini.chess.algorithms.pieces;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.pieces.interfaces.PiecesInterface;

public class Rook implements PiecesInterface{

//	private Coordinate from;
//	private Coordinate to;
	private int xFrom;
	private int yFrom;
	private int xTo;
	private int yTo;
	private Board board;

	public Rook(Move move, Board board) {
		
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
		
		return true;
	}
	
	@Override
	public boolean moveConditions() {
		
		if ((xFrom == xTo) || (yFrom == yTo)) {
				return isAllPathFree();
		}
		
		return false;
	}



}
