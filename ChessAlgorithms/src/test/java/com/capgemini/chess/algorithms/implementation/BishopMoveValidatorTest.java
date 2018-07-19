package com.capgemini.chess.algorithms.implementation;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class BishopMoveValidatorTest {

	@Test
	public void shouldReturnFalseWhenPathIsNotFree() {
		
		//give
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_BISHOP, new Coordinate(4, 5));
		board.setPieceAt(Piece.WHITE_PAWN, new Coordinate(2, 3));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		boolean exceptionThrown = false;
		try {
			boardManager.performMove(new Coordinate(4, 5), new Coordinate(1, 2));
		} catch (InvalidMoveException e) {
			exceptionThrown = true;
		}
		
		assertTrue(exceptionThrown);
	}
	
	@Test
	public void shouldReturnTrueWhenAttackLeftDown() throws InvalidMoveException{
		
		//give
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_BISHOP, new Coordinate(4, 5));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(4, 5), new Coordinate(1, 2));
		
		// then
		assertEquals(MoveType.ATTACK, move.getType());
		assertEquals(new Coordinate(1, 2),  move.getTo());
	}
	
	@Test
	public void shouldReturnTrueWhenAttackRightDown() throws InvalidMoveException{
		
		//give
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_BISHOP, new Coordinate(4, 5));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(4, 5), new Coordinate(7, 2));
		
		// then
		assertEquals(MoveType.ATTACK, move.getType());
		assertEquals(new Coordinate(7, 2),  move.getTo());
	}

}
