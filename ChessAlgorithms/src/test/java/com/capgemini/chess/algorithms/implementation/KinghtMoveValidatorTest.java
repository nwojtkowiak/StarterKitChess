package com.capgemini.chess.algorithms.implementation;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class KinghtMoveValidatorTest {

	@Test
	public void shouldReturnTrueWhenAttackLeftUp() throws InvalidMoveException{
		
		//give
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KNIGHT, new Coordinate(4, 4));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(4, 4), new Coordinate(2, 5));
		
		// then
		assertEquals(MoveType.ATTACK, move.getType());
		assertEquals(new Coordinate(2, 5),  move.getTo());
	}
	
	@Test
	public void shouldReturnTrueWhenAttackRightUp() throws InvalidMoveException{
		
		//give
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KNIGHT, new Coordinate(4, 4));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(4, 4), new Coordinate(6, 5));
		
		// then
		assertEquals(MoveType.ATTACK, move.getType());
		assertEquals(new Coordinate(6, 5),  move.getTo());
	}
	
	@Test
	public void shouldReturnTrueWhenAttackLeftDown() throws InvalidMoveException{
		
		//give
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KNIGHT, new Coordinate(4, 4));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(4, 4), new Coordinate(2, 3));
		
		// then
		assertEquals(MoveType.ATTACK, move.getType());
		assertEquals(new Coordinate(2, 3),  move.getTo());
	}
	
	@Test
	public void shouldReturnTrueWhenAttackRightDown() throws InvalidMoveException{
		
		//give
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KNIGHT, new Coordinate(4, 4));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(4, 4), new Coordinate(6, 3));
		
		// then
		assertEquals(MoveType.ATTACK, move.getType());
		assertEquals(new Coordinate(6, 3),  move.getTo());
	}
	
	@Test
	public void shouldReturnTrueWhenAttackUpLeft() throws InvalidMoveException{
		
		//give
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KNIGHT, new Coordinate(4, 4));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(4, 4), new Coordinate(3, 6));
		
		// then
		assertEquals(MoveType.ATTACK, move.getType());
		assertEquals(new Coordinate(3, 6),  move.getTo());
	}
	
	@Test
	public void shouldReturnTrueWhenAttackUpRight() throws InvalidMoveException{
		
		//give
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KNIGHT, new Coordinate(4, 4));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(4, 4), new Coordinate(5, 6));
		
		// then
		assertEquals(MoveType.ATTACK, move.getType());
		assertEquals(new Coordinate(5, 6),  move.getTo());
	}
	
	@Test
	public void shouldReturnTrueWhenAttackDownLeft() throws InvalidMoveException{
		
		//give
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KNIGHT, new Coordinate(4, 4));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(4, 4), new Coordinate(3, 2));
		
		// then
		assertEquals(MoveType.ATTACK, move.getType());
		assertEquals(new Coordinate(3, 2),  move.getTo());
	}
	
	@Test
	public void shouldReturnTrueWhenAttackDownRight() throws InvalidMoveException{
		
		//give
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KNIGHT, new Coordinate(4, 4));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(4, 4), new Coordinate(5, 2));
		
		// then
		assertEquals(MoveType.ATTACK, move.getType());
		assertEquals(new Coordinate(5, 2),  move.getTo());
	}
	
	
	@Test
	public void shouldReturnFalseWhenMoveIsWrong() {
		
		//give
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KNIGHT, new Coordinate(4, 5));
		
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

}
