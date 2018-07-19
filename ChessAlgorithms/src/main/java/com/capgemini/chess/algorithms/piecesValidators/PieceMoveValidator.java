package com.capgemini.chess.algorithms.piecesValidators;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.NotAnyValidMove;
import com.capgemini.chess.algorithms.pieces.interfaces.MoveConditioner;

public abstract class PieceMoveValidator implements MoveConditioner {

	public PieceMoveValidator() {

	}

	@Override
	public abstract boolean moveConditions(Move move, Board board);

	public Coordinate findMove(Move move, Board board) {
		Coordinate coordinateTo = move.getFrom();
		Color color = move.getMovedPiece().getColor();

		KingMoveValidator kingMoveValidator = new KingMoveValidator();
		boolean isCheck = false;
		for (int x = 0; x < board.SIZE; x++) {
			for (int y = 0; y < board.SIZE; y++) {

				coordinateTo = new Coordinate(x, y);
				Move moveToCheck = new Move(move.getFrom(), coordinateTo);
				moveToCheck.setMovedPiece(move.getMovedPiece());

				if (moveConditions(moveToCheck, board)) {
					Piece pieceTo = board.getPieceAt(coordinateTo);

					board.setStateBoard(null, move.getFrom(), move.getMovedPiece(), coordinateTo);

					isCheck = kingMoveValidator.isCheck(board, color);

					board.setStateBoard(move.getMovedPiece(), move.getFrom(), pieceTo, coordinateTo);
					
					if (!isCheck) {
						return coordinateTo;
					}
				}
			}
		}
		return coordinateTo;
	}

	public boolean validateMove(Move move, Board board) {

		if (moveConditions(move, board)) {
			return true;
		}

		return false;
	}

}
