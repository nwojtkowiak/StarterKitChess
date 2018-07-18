package com.capgemini.chess.algorithms.pieces.interfaces;

import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.generated.Board;

public interface MoveConditioner {
	
	//boolean moveConditions(Coordinate coordinate, Move move, Board board);
	boolean moveConditions(Move move, Board board);
	
	

}
