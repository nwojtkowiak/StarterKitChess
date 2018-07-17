package com.capgemini.chess.algorithms.pieces.interfaces;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;

public interface MoveSearcher extends MoveConditioner{
	
	default boolean findMove(Color color, Board board){
		Coordinate coordinate;
		Piece piece;

		for (int x = 0; x < board.SIZE; x++) {
			for (int y = 0; y < board.SIZE; y++) {
				coordinate = new Coordinate(x, y);
				if (board.getPieceAt(coordinate) == null) {
					
					if (moveConditions(x, y)) {
						return true;
					}
				} else {
					piece = board.getPieceAt(coordinate);
					if (piece.getColor() != color) {
						
						if (moveConditions(x, y)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	

}
