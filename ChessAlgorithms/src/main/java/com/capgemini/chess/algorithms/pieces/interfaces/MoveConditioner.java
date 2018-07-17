package com.capgemini.chess.algorithms.pieces.interfaces;

public interface MoveConditioner {
	
	boolean moveConditions();
	boolean moveConditions(int xTo, int yTo);
	

}
