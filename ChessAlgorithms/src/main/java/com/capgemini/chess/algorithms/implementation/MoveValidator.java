package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.enums.PieceType;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class MoveValidator {

	private Coordinate from;
	private Coordinate to;
	private Piece pieceFrom;
	private Piece pieceTo;

	public MoveValidator(Coordinate from, Coordinate to) throws InvalidMoveException {
		this.from = from;
		this.to = to;
		validateRangeOfIndex();
	}

	public void setPieces(Piece pieceFrom, Piece pieceTo) {
		this.pieceFrom = pieceFrom;
		this.pieceTo = pieceTo;
	}

	public Move checkAllValidations() throws InvalidMoveException {
		Move move = new Move(from, to);

		//validateRangeOfIndex();

		move.setType(validateMovePiece());
		move.setMovedPiece(pieceFrom);

		return move;
	}

	private boolean validateCoordinate(Coordinate coordinate) {
		if (coordinate.getX() >= 0 && coordinate.getX() < 8 && coordinate.getY() >= 0 && coordinate.getY() < 8) {
			return true;
		}

		return false;
	}

	public void validateRangeOfIndex() throws InvalidMoveException {
		if (!(validateCoordinate(this.from) && validateCoordinate(this.to))) {
			throw new InvalidMoveException();
		}

	}

	public MoveType validateMovePiece() throws InvalidMoveException {
		PieceType pieceType = this.pieceFrom.getType();
		MoveType moveType = null;

		if (pieceType.equals(PieceType.PAWN)) {
			moveType = validateMovePawn();
		} else if (pieceType.equals(PieceType.ROOK)) {
			moveType = validateMoveRook();
		} else if (pieceType.equals(PieceType.BISHOP)){
			moveType = validateMoveBishop();
		} else if (pieceType.equals(PieceType.QUEEN)){
			moveType = validateMoveQueen();
		}

		return moveType;
	}
	

	public MoveType validateMovePawn() throws InvalidMoveException {
		Color colorFrom = this.pieceFrom.getColor();
		// PieceType pieceToType = this.pieceTo != null ? this.pieceTo.getType()
		// : null;
		Color colorTo;
		int startY;
		int multiply;

		// when pawn is white
		if (colorFrom.equals(Color.WHITE)) {
			startY = 1;
			multiply = 1;
		} else {
			startY = 6;
			multiply = -1;
		}

		// when destination field is empty
		if (this.pieceTo == null) {
			if (this.from.getX() == this.to.getX()) {
				if (this.from.getY() == startY) {
					if (this.from.getY() + 2 * multiply == this.to.getY()) {
						return MoveType.ATTACK;
					}
				} else {
					if (this.from.getY() + 1 * multiply == this.to.getY()) {
						return MoveType.ATTACK;
					}
				}
				throw new InvalidMoveException();
			}
			// when destination field is not empty
		} else {
			colorTo = this.pieceTo.getColor();
			if ((this.from.getX() - 1 == this.to.getX()) || (this.from.getX() + 1 == this.to.getX())) {
				if (!colorFrom.equals(colorTo)) {
					if (this.from.getY() == startY) {
						if (this.from.getY() + 2 * multiply == this.to.getY()) {
							return MoveType.CAPTURE;
						}
					} else {
						if (this.from.getY() + 1 * multiply == this.to.getY()) {
							return MoveType.CAPTURE;
						}
					}
				}
			}

		}
		throw new InvalidMoveException();
	}

	public MoveType conditionsForRook(){
		Color colorFrom = this.pieceFrom.getColor();
	
		if (this.pieceTo == null) {
			if ((this.from.getX() == this.to.getX()) || (this.from.getY() == this.to.getY())) {
				return MoveType.ATTACK;
			}
			// when destination field is not empty
		} else {
			if (!colorFrom.equals(this.pieceTo.getColor())) {
				if ((this.from.getX() == this.to.getX()) || (this.from.getY() == this.to.getY())) {
					return MoveType.CAPTURE;
				}
			}

		}
		
		return null;
	}
	
	public MoveType validateMoveRook() throws InvalidMoveException {
		MoveType moveType = conditionsForRook();
		
		if(moveType != null){
			return moveType;
		}
		
		throw new InvalidMoveException();
	}
	
	public MoveType conditionsForBishop(){
		Color colorFrom = this.pieceFrom.getColor();
		int xFrom = this.from.getX();
		int xTo = this.to.getX();
		int yFrom = this.from.getY();
		int yTo = this.to.getY();
		
		if(this.pieceTo == null){
			
			if(( xTo < xFrom  && yTo < yFrom) || ( xTo > xFrom  && yTo > yFrom)){
				
				if( xTo - yTo == xFrom - yFrom){
					return MoveType.ATTACK;
				}
			}
			if(( xTo < xFrom  && yTo > yFrom) || ( xTo > xFrom  && yTo < yFrom)){
				
				if( xTo + yTo == xFrom + yFrom){
					return MoveType.ATTACK;
				}
			}
		}else if(!colorFrom.equals(this.pieceTo.getColor())){
			
			if(( xTo < xFrom  && yTo < yFrom) || ( xTo > xFrom  && yTo > yFrom)){
				
				if( xTo - yTo == xFrom - yFrom){
					return MoveType.CAPTURE;
				}
			}
			if(( xTo < xFrom  && yTo > yFrom) || ( xTo > xFrom  && yTo < yFrom)){
				
				if( xTo + yTo == xFrom + yFrom){
					return MoveType.CAPTURE;
				}
			}
			
		}
		
		return null;
	}
	
	
	public MoveType validateMoveBishop() throws InvalidMoveException{
		MoveType moveType = conditionsForBishop();
		if(moveType != null){
			return moveType;
		}
		
		throw new InvalidMoveException();
	}
	
	public MoveType validateMoveQueen() throws InvalidMoveException{
		MoveType moveType = conditionsForBishop();
		moveType = moveType!=null ? moveType : conditionsForRook();
		
		if(moveType != null){
			return moveType;
		}
		
		throw new InvalidMoveException();
	}
}
