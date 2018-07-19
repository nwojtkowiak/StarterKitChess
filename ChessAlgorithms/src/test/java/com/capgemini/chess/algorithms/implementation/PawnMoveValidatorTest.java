package com.capgemini.chess.algorithms.implementation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;



public class PawnMoveValidatorTest {

	
	@Test
	public void shouldReturnFalseWhenPathIsNotFree() {
		
		//give
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_PAWN, new Coordinate(1, 1));
		board.setPieceAt(Piece.WHITE_PAWN, new Coordinate(1, 2));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		boolean exceptionThrown = false;
		try {
			boardManager.performMove(new Coordinate(1, 1), new Coordinate(1, 3));
		} catch (InvalidMoveException e) {
			exceptionThrown = true;
		}
		
		assertTrue(exceptionThrown);
	}
	
	@Test
	public void shouldReturnTrueWhenAttackFromStartField() throws InvalidMoveException{
		
		//give
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_PAWN, new Coordinate(1, 1));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(1, 1), new Coordinate(1, 2));
		
		// then
		assertEquals(MoveType.ATTACK, move.getType());
		assertEquals(new Coordinate(1, 2),  move.getTo());
	}
	
	@Test
	public void shouldReturnTrueWhenAttackFromNotStartField() throws InvalidMoveException{
		
		//give
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_PAWN, new Coordinate(1, 2));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(1, 2), new Coordinate(1, 3));
		
		// then
		assertEquals(MoveType.ATTACK, move.getType());
		assertEquals(new Coordinate(1, 3),  move.getTo());
	}
	
	

}
