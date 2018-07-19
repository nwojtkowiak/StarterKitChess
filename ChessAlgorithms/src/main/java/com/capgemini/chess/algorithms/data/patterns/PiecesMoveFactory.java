package com.capgemini.chess.algorithms.data.patterns;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.PieceType;
import com.capgemini.chess.algorithms.data.generated.Board;

public class PiecesMoveFactory {

	private Board board;
	
	public PiecesMoveFactory(Board board){
		this.board = board;
	}
	
	public boolean checkPath(Move move) {
		PieceType pieceType = move.getMovedPiece().getType();
		
		return pieceType.getInstant().validateMove(move, board);

	}

	public Coordinate checkIsAnyMove(Move move) {
		
		PieceType pieceType = move.getMovedPiece().getType();
		return pieceType.getInstant().findMove(move, board);
		
	}
}
