package com.capgemini.chess.algorithms.data.patterns;

import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.enums.PieceType;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.piecesValidators.BishopMoveValidator;
import com.capgemini.chess.algorithms.piecesValidators.KingMoveValidator;
import com.capgemini.chess.algorithms.piecesValidators.KinghtMoveValidator;
import com.capgemini.chess.algorithms.piecesValidators.PawnMoveValidator;
import com.capgemini.chess.algorithms.piecesValidators.QueenMoveValidator;
import com.capgemini.chess.algorithms.piecesValidators.RookMoveValidator;

public class PiecesFactory {

	public boolean checkPath(Move move, Board board) throws InvalidMoveException {
		PieceType pieceType = move.getMovedPiece().getType();
		
		if (pieceType.equals(PieceType.PAWN)) {
			return new PawnMoveValidator(move, board).validateMove();

		} else if (pieceType.equals(PieceType.BISHOP)) {
			return new BishopMoveValidator(move, board).validateMove();

		} else if (pieceType.equals(PieceType.KNIGHT)) {
			return new KinghtMoveValidator(move).validateMove();

		} else if (pieceType.equals(PieceType.ROOK)) {
			return new RookMoveValidator(move, board).validateMove();

		} else if (pieceType.equals(PieceType.QUEEN)) {
			return new QueenMoveValidator(move, board).validateMove();

		} else if (pieceType.equals(PieceType.KING)) {
			return new KingMoveValidator(move).validateMove();

		}

		return false;

	}
}
