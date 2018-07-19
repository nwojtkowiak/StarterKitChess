package com.capgemini.chess.algorithms.piecesValidators;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.MoveValidator;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.implementation.exceptions.NotAnyValidMove;
import com.capgemini.chess.algorithms.pieces.interfaces.MoveConditioner;

public abstract class PieceMoveValidator implements MoveConditioner {

	public PieceMoveValidator() {

	}

	@Override
	public abstract boolean moveConditions(Move move, Board board);

	private boolean validateNewMove(Color color, Move move, Piece pieceTo) {
		boolean result = true;
		try {
			MoveValidator moveValidator = new MoveValidator(move.getFrom(), move.getTo());
			moveValidator.setPieceFrom(move.getMovedPiece());
			moveValidator.setPieceTo(pieceTo);
			
			move.setType(moveValidator.checkMoveType(color));

		} catch (InvalidMoveException e) {
			result = false;
		}

		return result;
	}

	public boolean checkMove(int x, int y, Move move, Board board) {

		Color color = move.getMovedPiece().getColor();
		KingMoveValidator kingMoveValidator = new KingMoveValidator();
		boolean isCheck = false;

		Coordinate coordinateTo = new Coordinate(x, y);
		if (!coordinateTo.equals(move.getFrom())) {

			Move moveToCheck = new Move(move.getFrom(), coordinateTo);
			moveToCheck.setMovedPiece(move.getMovedPiece());
			Piece pieceTo = board.getPieceAt(coordinateTo);
			
			if (validateNewMove(color, moveToCheck, pieceTo)) {
				if (moveConditions(moveToCheck, board)) {

					

					board.setStateBoard(null, move.getFrom(), move.getMovedPiece(), coordinateTo);

					isCheck = kingMoveValidator.isCheck(board, color);

					board.setStateBoard(move.getMovedPiece(), move.getFrom(), pieceTo, coordinateTo);

					if (!isCheck) {
						move.setTo(coordinateTo);
						return true;
					}
				}
			}
		}

		return false;
	}

	public Coordinate findMove(Move move, Board board) {

		int fromX = move.getFrom().getX();
		int fromY = move.getFrom().getY();

		for (int x = fromX + 1; x < board.SIZE; x++) {
			for (int y = fromY; y < board.SIZE; y++) {
				if (checkMove(x, y, move, board)) {
					return move.getTo();
				}
			}
			for (int y = fromY; y >= 0; y--) {
				if (checkMove(x, y, move, board)) {
					return move.getTo();
				}
			}
		}

		for (int x = fromX - 1; x >= 0; x--) {
			for (int y = fromY; y < board.SIZE; y++) {
				if (checkMove(x, y, move, board)) {
					return move.getTo();
				}
			}
			for (int y = fromY; y >= 0; y--) {
				if (checkMove(x, y, move, board)) {
					return move.getTo();
				}
			}
		}
		return move.getFrom();
	}

	public boolean validateMove(Move move, Board board) {

		if (moveConditions(move, board)) {
			return true;
		}

		return false;
	}

}
