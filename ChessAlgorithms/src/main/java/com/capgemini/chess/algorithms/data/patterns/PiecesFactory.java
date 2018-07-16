package com.capgemini.chess.algorithms.data.patterns;

import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.enums.PieceType;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.pieces.Bishop;
import com.capgemini.chess.algorithms.pieces.King;
import com.capgemini.chess.algorithms.pieces.Kinght;
import com.capgemini.chess.algorithms.pieces.Pawn;
import com.capgemini.chess.algorithms.pieces.Queen;
import com.capgemini.chess.algorithms.pieces.Rook;

public class PiecesFactory {

	public boolean checkPath(Move move) throws InvalidMoveException {
		PieceType pieceType = move.getMovedPiece().getType();
		
		if (pieceType.equals(PieceType.PAWN)) {
			return new Pawn(move).validateMove();

		} else if (pieceType.equals(PieceType.BISHOP)) {
			return new Bishop(move).validateMove();

		} else if (pieceType.equals(PieceType.KNIGHT)) {
			return new Kinght(move).validateMove();

		} else if (pieceType.equals(PieceType.ROOK)) {
			return new Rook(move).validateMove();

		} else if (pieceType.equals(PieceType.QUEEN)) {
			return new Queen(move).validateMove();

		} else if (pieceType.equals(PieceType.KING)) {
			return new King(move).validateMove();

		}

		return false;

	}
}
