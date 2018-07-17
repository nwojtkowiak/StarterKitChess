package com.capgemini.chess.algorithms.pieces.interfaces;

public interface PiecesMoveValidatorInterface {
	boolean moveConditions();

	
	default boolean validateMove() {
		if (moveConditions()) {
			return true;
		}

		return false;
	}

}
