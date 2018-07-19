package com.capgemini.chess.algorithms.implementation;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.BoardState;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class PieceMoveValidatorTest {

	@Test
	public void shouldReturnCheckMateWhenPlayerNotHasMoveAndCheck() {
		
		//give
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.BLACK_ROOK, new Coordinate(0, 0));
		board.setPieceAt(Piece.BLACK_ROOK, new Coordinate(0, 1));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		boardManager.updateBoardState();
		
		
		assertEquals(BoardState.CHECK_MATE, board.getState());
	}
	
	
	@Test
	public void shouldReturnCheckWhenPlayerHasCheck() throws InvalidMoveException {
		
		//give
		Board board = new Board();
		
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.BLACK_ROOK, new Coordinate(3, 0));
		board.setPieceAt(Piece.WHITE_KNIGHT, new Coordinate(2, 4));
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(3, 4));
		BoardManager boardManager = new BoardManager(board);
		boardManager.performMove(new Coordinate(2, 4), new Coordinate(3, 2));
		
		
//		// when
//		Move moveKnight = boardManager.performMove(new Coordinate(1, 4), new Coordinate(2, 5));
		
		// when
		boardManager.updateBoardState();
		
		
		assertEquals(BoardState.CHECK, board.getState());
	}
	
}
