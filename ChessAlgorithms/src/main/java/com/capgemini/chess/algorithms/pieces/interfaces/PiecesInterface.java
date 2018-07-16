package com.capgemini.chess.algorithms.pieces.interfaces;


import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public interface PiecesInterface {
	boolean moveConditions();
	
	default boolean validateMove() throws InvalidMoveException{
		if (moveConditions()) {
			return true;
		}

		throw new InvalidMoveException();
	}

}
