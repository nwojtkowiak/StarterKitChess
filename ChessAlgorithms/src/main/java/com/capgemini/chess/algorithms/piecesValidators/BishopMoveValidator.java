package com.capgemini.chess.algorithms.piecesValidators;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.pieces.interfaces.PiecesMoveValidatorInterface;

public class BishopMoveValidator implements PiecesMoveValidatorInterface {

	private int xFrom;
	private int yFrom;
	private int xTo;
	private int yTo;
	
	private Board board;

	public BishopMoveValidator(Move move, Board board) {
		
		this.xFrom = move.getFrom().getX();
		this.yFrom = move.getFrom().getY();
		this.xTo = move.getTo().getX();
		this.yTo = move.getTo().getY();
		
		this.board = board;
	}
	

	
	@Override
	public boolean moveConditions() {

		BishopMove bishopMove = new BishopMove(xFrom, yFrom, xTo, yTo);
		if(bishopMove.check()){
			return bishopMove.isAllPathFree(board);
		}

		return false;
	}


}
