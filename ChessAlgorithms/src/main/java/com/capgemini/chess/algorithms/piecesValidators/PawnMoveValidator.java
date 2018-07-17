package com.capgemini.chess.algorithms.piecesValidators;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.pieces.interfaces.PiecesMoveValidatorInterface;

public class PawnMoveValidator implements PiecesMoveValidatorInterface {

	private int xFrom;
	private int yFrom;
	private int xTo;
	private int yTo;
	private int startY = 1;
	private int factor = 1;
	
	private Color color;
	MoveType moveType;
	private Board board;

	public PawnMoveValidator(Move move, Board board) {
		this.xFrom = move.getFrom().getX();
		this.yFrom = move.getFrom().getY();
		this.xTo = move.getTo().getX();
		this.yTo = move.getTo().getY();
		this.moveType = move.getType();
		this.color = move.getMovedPiece().getColor();
		this.board = board;
	}

	public boolean isAllPathFree(){
		
		Coordinate coordinate = new Coordinate(xFrom + factor, yFrom);
		
		if(board.getPieceAt(coordinate) != null){
			return false;
		}
		
		return true;
	}
	
	private boolean moveConditionsWhenAttack(int startY, int factor) {

		if (xFrom == xTo) {
			if (yFrom == startY) {
				if (yFrom + 2 * factor == yTo){ 
					return isAllPathFree();
				}else if(yFrom + 1 * factor == yTo) {
					return true;
				}
			} else {
				if (yFrom + 1 * factor == yTo) {
					return true;
				}
			}

		}
		return false;
	}

	private boolean moveConditionsWhenCapture(int startY, int factor) {

		if ((xFrom- 1 == xTo) || (xFrom + 1 == xTo)) {

			if (yFrom + 1 * factor == yTo) {
				return true;
			}

		}
		return false;

	}

	@Override
	public boolean moveConditions() {
		if (color.equals(Color.BLACK)) {
			startY = 6;
			factor = -1;
		}

		// when destination field is empty
		if (moveType.equals(MoveType.ATTACK)) {
			return moveConditionsWhenAttack(startY, factor);
			// when destination field is not empty
		} else if (moveType.equals(MoveType.CAPTURE)) {
			return moveConditionsWhenCapture(startY, factor);
		}

		return false;
	}

}