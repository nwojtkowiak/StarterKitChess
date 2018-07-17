package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.enums.PieceType;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.data.patterns.PiecesMoveFactory;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class MoveValidator {

	private Coordinate from;
	private Coordinate to;
	private Piece pieceFrom;
	private Piece pieceTo;
	private Color nextColor;
	private Board board;
	
	public MoveValidator(Coordinate from, Coordinate to, Color nextColor) throws InvalidMoveException {
		
		this.from = from;
		this.to = to;
		this.nextColor = nextColor;
		validateRangeOfIndex();
	}

	public void setPieces(Piece pieceFrom, Piece pieceTo) {
		
		this.pieceFrom = pieceFrom;
		this.pieceTo = pieceTo;
	}
	
	public void setBoard(Board board){
		this.board = board;
	}

	public Move checkAllValidations() throws InvalidMoveException {
		
		Move move = new Move(from, to);
		move = validateMovePiece();
		return move;
	}

	private boolean validateCoordinate(Coordinate coordinate) {
		
		int x = coordinate.getX();
		int y = coordinate.getY();
		
		if (x >= 0 && x < 8 && y >= 0 && y < 8) {
			return true;
		}

		return false;
	}

	public void validateRangeOfIndex() throws InvalidMoveException {
		
		if (!(validateCoordinate(from) && validateCoordinate(to))) {
			throw new InvalidMoveException();
		}

	}

	public Move validateMovePiece() throws InvalidMoveException {

		MoveType moveType = checkMoveType();
		
		Move move = new Move(from, to);
		
		move.setMovedPiece(pieceFrom);
		move.setFrom(from);
		move.setTo(to);
		move.setType(moveType);
		
		PiecesMoveFactory factory = new PiecesMoveFactory();
		
		if(!factory.checkPath(move, board)){
			throw new InvalidMoveException();
		}

		return move;
	}
	
	public MoveType checkMoveType() throws InvalidMoveException{
		
		if(pieceFrom == null){
			throw new InvalidMoveException();
		}
		
		Color color = pieceFrom.getColor();
		
		if(!color.equals(nextColor)){
			throw new InvalidMoveException(); //nie moja figura
		}
		
		if(pieceTo == null){
			
			return MoveType.ATTACK;
			
		}else{
			
			Color colorFrom = pieceFrom.getColor();
			Color colorTo = pieceTo.getColor();
			
			if(!colorTo.equals(colorFrom)){
				return MoveType.CAPTURE;
			}
				
		}
		
		throw new InvalidMoveException();
		
	}
	


}
