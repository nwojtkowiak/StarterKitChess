package com.capgemini.chess.algorithms.implementation.exceptions;

public class InvalidColorPieceException extends InvalidMoveException {

	private static final long serialVersionUID = -1487608854896813664L;

	public InvalidColorPieceException() {
		super("Color piece is wrong");
	}

	public InvalidColorPieceException(String message) {
		super(message);
	}

}
