package com.capgemini.chess.algorithms.data.patterns;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.enums.PieceType;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.piecesValidators.BishopMoveValidator;
import com.capgemini.chess.algorithms.piecesValidators.KingMoveValidator;
import com.capgemini.chess.algorithms.piecesValidators.KinghtMoveValidator;
import com.capgemini.chess.algorithms.piecesValidators.PawnMoveValidator;
import com.capgemini.chess.algorithms.piecesValidators.PieceMoveValidator;
import com.capgemini.chess.algorithms.piecesValidators.QueenMoveValidator;
import com.capgemini.chess.algorithms.piecesValidators.RookMoveValidator;

public class PiecesMoveFactory {

	private Board board;
	
	public PiecesMoveFactory(Board board){
		this.board = board;
	}
	
	public boolean checkPath(Move move) {
		PieceType pieceType = move.getMovedPiece().getType();

		if (pieceType == PieceType.PAWN) {
			return new PawnMoveValidator().validateMove( move, board);

		} else if (pieceType == PieceType.BISHOP) {
			return new BishopMoveValidator().validateMove( move, board);

		} else if (pieceType == PieceType.KNIGHT) {
			return new KinghtMoveValidator().validateMove( move, board);

		} else if (pieceType == PieceType.ROOK) {
			return new RookMoveValidator().validateMove( move, board);

		} else if (pieceType == PieceType.QUEEN) {
			return new QueenMoveValidator().validateMove( move, board);

		} else if (pieceType == PieceType.KING) {
			return new KingMoveValidator().validateMove( move, board);

		}

		return false;

	}

	public Coordinate checkIsAnyMove(Move move, Coordinate coordinate) {
		
		//PieceMoveValidator pieceValidator = new PieceMoveValidator();
		PieceType pieceType = move.getMovedPiece().getType();
		
		if (pieceType == PieceType.PAWN) {
			return new PawnMoveValidator().findMove(move, board);

		} else if (pieceType == PieceType.BISHOP) {
			return new BishopMoveValidator().findMove(move, board);
 
		} else if (pieceType == PieceType.KNIGHT) {
			return new KinghtMoveValidator().findMove(move, board);

		} else if (pieceType == PieceType.ROOK) {
			return new RookMoveValidator().findMove(move, board);

		} else if (pieceType == PieceType.QUEEN) {
			return new QueenMoveValidator().findMove(move, board);

		} else if (pieceType == PieceType.KING) {
			return new KingMoveValidator().findMove(move, board);

		}

		return coordinate;
	}
}
