package com.capgemini.chess.algorithms.implementation.exceptions;

public class EmptyFromFieldException extends InvalidMoveException {

	private static final long serialVersionUID = 4562712696947466297L;

	public EmptyFromFieldException() {
		super("Invalid coordinates!");
	}

}
