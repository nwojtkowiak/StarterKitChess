package com.capgemini.chess.algorithms.implementation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.BoardState;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.EmptyFromFieldException;
import com.capgemini.chess.algorithms.implementation.exceptions.IndexOutOfRangeException;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidColorPieceException;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class PieceMoveValidatorTest {

	@Test
	public void shouldReturnCheckMateWhenPlayerNotHasMoveAndCheck() {

		// give
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

		// give
		Board board = new Board();

		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.BLACK_ROOK, new Coordinate(3, 0));
		board.setPieceAt(Piece.WHITE_KNIGHT, new Coordinate(2, 4));
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(3, 4));
		BoardManager boardManager = new BoardManager(board);

		// when
		boardManager.performMove(new Coordinate(2, 4), new Coordinate(3, 2));
		boardManager.updateBoardState();

		assertEquals(BoardState.CHECK, board.getState());
	}

	@Test(expected = InvalidColorPieceException.class)
	public void shouldReturnInvalidColorPieceException() throws InvalidMoveException {
		// give
		Board board = new Board();

		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(3, 4));
		BoardManager boardManager = new BoardManager(board);

		// when
		boardManager.performMove(new Coordinate(4, 0), new Coordinate(4, 1));

	}

	@Test(expected = IndexOutOfRangeException.class)
	public void shouldReturnIndexOutOfBoundsException() throws InvalidMoveException {
		// give
		Board board = new Board();

		board.setPieceAt(Piece.WHITE_KING, new Coordinate(3, 4));
		BoardManager boardManager = new BoardManager(board);

		// when
		boardManager.performMove(new Coordinate(3, 4), new Coordinate(8, 1));

	}

	@Test(expected = EmptyFromFieldException.class)
	public void shouldReturnEmptyFromFieldException() throws InvalidMoveException {
		// give
		Board board = new Board();

		board.setPieceAt(Piece.WHITE_KING, new Coordinate(3, 4));
		BoardManager boardManager = new BoardManager(board);

		// when
		boardManager.performMove(new Coordinate(0, 4), new Coordinate(1, 1));

	}

	@Test
	public void shouldReturnInvalidExceptionWithYourColor() {
		// give
		Board board = new Board();

		board.setPieceAt(Piece.WHITE_KING, new Coordinate(3, 4));
		board.setPieceAt(Piece.WHITE_PAWN, new Coordinate(3, 5));
		BoardManager boardManager = new BoardManager(board);
		String message = "";
		// when
		try {
			boardManager.performMove(new Coordinate(3, 4), new Coordinate(3, 5));
		} catch (InvalidColorPieceException e) {
			message = e.getMessage();
		} catch (InvalidMoveException e) {
			message = e.getMessage();
		}

		assertEquals("Invalid move! This piece is yours", message);
	}

	@Test
	public void shouldReturnInvalidExceptionWithNotYourColor() {
		// give
		Board board = new Board();

		board.setPieceAt(Piece.BLACK_KING, new Coordinate(3, 4));
		BoardManager boardManager = new BoardManager(board);
		String message = "";

		// when
		try {
			boardManager.performMove(new Coordinate(3, 4), new Coordinate(1, 1));
		} catch (InvalidColorPieceException e) {
			message = e.getMessage();
		} catch (InvalidMoveException e) {
			message = e.getMessage();
		}

		assertEquals("Invalid move! This piece is not yours", message);
	}
}
