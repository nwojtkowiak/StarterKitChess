package com.capgemini.chess.algorithms.piecesValidators;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.pieces.interfaces.MoveConditioner;

public abstract class PieceMoveValidator implements MoveConditioner {


	protected Board board;
	protected Color color;

		
	public PieceMoveValidator(){
		
	}
	


	
	@Override
	public abstract boolean moveConditions(Move move, Board board);
		
	
	public Coordinate findMove(Color color, Coordinate coordinateFrom, Board board){
		Coordinate coordinateTo = new Coordinate(-1, -1);

		for (int x = 0; x < board.SIZE; x++) {
			for (int y = 0; y < board.SIZE; y++) {
				
				coordinateTo = new Coordinate(x, y);
				Move move = new Move(coordinateFrom, coordinateTo);
				if (moveConditions(move, board)) {
					return coordinateTo;
				}
			}
		}
		return coordinateTo;
	}
	
	public boolean validateMove(Move move, Board board) {
		
		if (moveConditions(move, board)) {
			return true;
		}

		return false;
	}

	
	

}
