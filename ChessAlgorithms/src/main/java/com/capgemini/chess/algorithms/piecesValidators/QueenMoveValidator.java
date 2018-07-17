package com.capgemini.chess.algorithms.piecesValidators;

import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.pieces.interfaces.PiecesMoveValidatorInterface;

public class QueenMoveValidator implements PiecesMoveValidatorInterface {

	private int xFrom;
	private int yFrom;
	private int xTo;
	private int yTo;
	private Board board;

	public QueenMoveValidator(Move move, Board board) {

		this.xFrom = move.getFrom().getX();
		this.yFrom = move.getFrom().getY();
		this.xTo = move.getTo().getX();
		this.yTo = move.getTo().getY();
		this.board = board;
	}

	@Override
	public boolean moveConditions() {

		// move as Rook
		RookMove rookMove = new RookMove(xFrom, yFrom, xTo, yTo);
		if (rookMove.check()) {
			return rookMove.isAllPathFree(board);
		}

		// move as Bishop
		BishopMove bishopMove = new BishopMove(xFrom, yFrom, xTo, yTo);
		if (bishopMove.check()) {
			return bishopMove.isAllPathFree(board);
		}

		return false;
	}



}
