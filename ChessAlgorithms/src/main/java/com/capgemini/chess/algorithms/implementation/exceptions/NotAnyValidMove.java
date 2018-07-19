package com.capgemini.chess.algorithms.implementation.exceptions;

public class NotAnyValidMove extends InvalidMoveException{
	
	private static final long serialVersionUID = 64075718306047988L;

	public NotAnyValidMove() {
		super("You don't have any valid move");
	}
}
