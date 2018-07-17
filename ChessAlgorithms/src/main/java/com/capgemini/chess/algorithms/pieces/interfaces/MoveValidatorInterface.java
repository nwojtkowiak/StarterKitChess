package com.capgemini.chess.algorithms.pieces.interfaces;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;

public interface MoveValidatorInterface extends MoveConditioner{
	
	default boolean validateMove() {
		if (moveConditions()) {
			return true;
		}

		return false;
	}

}
