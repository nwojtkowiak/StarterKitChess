package com.capgemini.chess.algorithms.piecesValidators;

import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.pieces.interfaces.MoveValidatorInterface;

public class PieceMoveValidator implements MoveValidatorInterface {

	protected int xFrom;
	protected int yFrom;
	protected int xTo;
	protected int yTo;
	protected Board board;

	public PieceMoveValidator(){
		
	}
	public PieceMoveValidator(int xFrom, int yFrom, int xTo, int yTo) {
		super();
		this.xFrom = xFrom;
		this.yFrom = yFrom;
		this.xTo = xTo;
		this.yTo = yTo;
	}
	public PieceMoveValidator(int xFrom, int yFrom, int xTo, int yTo, Board board) {
		this.xFrom = xFrom;
		this.yFrom = yFrom;
		this.xTo = xTo;
		this.yTo = yTo;
		this.board = board;
	}

	private void setTo(int xTo, int yTo) {
		this.xTo = xTo;
		this.yTo = yTo;
	}
	
	@Override
	public boolean moveConditions() {
		return false;
	}

	@Override
	public boolean moveConditions(int xTo, int yTo) {
		setTo(xTo, yTo);
		return moveConditions();
	}

}
