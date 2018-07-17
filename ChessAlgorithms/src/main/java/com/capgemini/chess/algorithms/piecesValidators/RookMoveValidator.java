package com.capgemini.chess.algorithms.piecesValidators;

import org.omg.CosNaming.NamingContextPackage.CannotProceed;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.pieces.interfaces.PiecesMoveValidatorInterface;

public class RookMoveValidator implements PiecesMoveValidatorInterface {

//	private Coordinate from;
//	private Coordinate to;
	private int xFrom;
	private int yFrom;
	private int xTo;
	private int yTo;
	private Board board;

	public RookMoveValidator(Move move, Board board) {
		
		this.xFrom = move.getFrom().getX();
		this.yFrom = move.getFrom().getY();
		this.xTo = move.getTo().getX();
		this.yTo = move.getTo().getY();
		
		this.board = board;
	}
	
	
	@Override
	public boolean moveConditions() {
		
		RookMove rookMove = new RookMove(xFrom, yFrom, xTo, yTo);
		if(rookMove.check()){
			return rookMove.isAllPathFree(board);
		}

		return false;
	}



}
