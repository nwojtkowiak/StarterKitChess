package com.capgemini.chess.algorithms.implementation.exceptions;

public class InvalidColorPiece extends InvalidMoveException{

	private static final long serialVersionUID = -1487608854896813664L;
	
	public InvalidColorPiece(){
		super("Color piece is wrong");
	}
	
	public InvalidColorPiece(String message){
		super(message);
	}

}
