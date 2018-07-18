package com.capgemini.chess.algorithms.piecesValidators;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.enums.PieceType;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.data.patterns.PiecesMoveFactory;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class KingMoveValidator extends PieceMoveValidator {

	public KingMoveValidator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean checkCastling(Move move, Board board){
		//int sizeHistory = board.getMoveHistory().size();
		Coordinate from = move.getFrom();
		Coordinate to = move.getTo();
		Coordinate coordinateForRook = new Coordinate(from.getX(), from.getY());
		
		boolean result = false;
		
		for(Move mv : board.getMoveHistory()){
			if(mv.getMovedPiece().getType() == PieceType.KING || mv.getMovedPiece().getType() == PieceType.ROOK){
				if(mv.getFrom().equals(from)){
					return false;
				}
			}
		}
		
		RookMove rookMove = new RookMove(from.getX(), to.getY(), to.getX(), to.getY());
		if(!rookMove.isAllPathFree(board)){
			return false;
		}
		
		//check if King is checked
		if(isCheck(from, board, move.getMovedPiece().getColor())){
			return false;
		}
		
		if(to.getX() == from.getX() - 2){
			coordinateForRook = new Coordinate(from.getX() - 1, from.getY());
		}else if (to.getX() == from.getX() + 2){
			coordinateForRook = new Coordinate(from.getX() + 1, from.getY());
		}
		
		//check if field for Rook is checked
		if(isCheck(coordinateForRook, board, move.getMovedPiece().getColor())){
			return false;
		}
		
		move.setType(MoveType.CASTLING);
		return true;
	}
	@Override
	public boolean moveConditions(Move move, Board board) {
		
		int xFrom = move.getFrom().getX();
		int yFrom = move.getFrom().getY();
		int xTo = move.getTo().getX();
		int yTo = move.getTo().getY();
		
		if( yTo == yFrom && (xTo == xFrom + 2 || xTo == xFrom -2)) {
			return checkCastling(move, board);
		}
		if ((xTo >= xFrom - 1 && xTo <= xFrom + 1) && (yTo >= yFrom - 1 && yTo <= yFrom + 1)) {
			return true;

		}
		return false;
	}

	public Coordinate whereIs(Board board, Color kingColor) {

		Piece[][] pieces = board.getPieces();
		Coordinate coordinate = new Coordinate(0, 0);
		PieceType pieceType;
		Color colorPiece;

		for (int x = 0; x < board.SIZE; x++) {
			for (int y = 0; y < board.SIZE; y++) {
				if (pieces[x][y] != null) {
					pieceType = pieces[x][y].getType();
					colorPiece = pieces[x][y].getColor();
					if (pieceType == PieceType.KING && colorPiece == kingColor) {
						coordinate = new Coordinate(x, y);
					}
				}
			}
		}

		return coordinate;

	}

	public boolean isCheck(Coordinate kingCoordinate, Board board, Color kingColor){
		
		Coordinate coordinate;
		PiecesMoveFactory pieceFactory = new PiecesMoveFactory(board);
		Move move = new Move();
		Piece piece;
		boolean result = false;

		move.setTo(kingCoordinate);
		move.setType(MoveType.CAPTURE);

		for (int x = 0; x < board.SIZE; x++) {
			for (int y = 0; y < board.SIZE; y++) {

				coordinate = new Coordinate(x, y);

				if (board.getPieceAt(coordinate) != null) {

					piece = board.getPieceAt(coordinate);

					if (!(piece.getColor() == kingColor)) {

						move.setFrom(coordinate);
						move.setMovedPiece(piece);

						if (pieceFactory.checkPath(move)) {
							return true;
						}
					}
				}
			}
		}
		return result;
	}
	
	public boolean isCheck(Board board, Color kingColor) {

		Coordinate kingCoordinate = whereIs(board, kingColor);
		return isCheck(kingCoordinate,board, kingColor);
	}

}
