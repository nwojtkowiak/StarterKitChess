package com.capgemini.chess.algorithms.piecesValidators;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.pieces.interfaces.MoveSearcher;
import com.capgemini.chess.algorithms.pieces.interfaces.MoveValidatorInterface;

public class QueenMoveValidator extends PieceMoveValidator {

	public QueenMoveValidator(Move move, Board board) {
		super(move.getFrom().getX(),move.getFrom().getY(), move.getTo().getX(),move.getTo().getY(), board);
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
