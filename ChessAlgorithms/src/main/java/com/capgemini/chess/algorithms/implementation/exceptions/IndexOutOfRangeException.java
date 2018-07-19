package com.capgemini.chess.algorithms.implementation.exceptions;

public class IndexOutOfRangeException extends InvalidMoveException {

	private static final long serialVersionUID = -6192223649163000328L;

	public IndexOutOfRangeException() {
		super("Invalid coordinates!");
	}

}
