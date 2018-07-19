package com.capgemini.chess.algorithms.data.enums;

import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.piecesValidators.BishopMoveValidator;
import com.capgemini.chess.algorithms.piecesValidators.KingMoveValidator;
import com.capgemini.chess.algorithms.piecesValidators.KinghtMoveValidator;
import com.capgemini.chess.algorithms.piecesValidators.PawnMoveValidator;
import com.capgemini.chess.algorithms.piecesValidators.PieceMoveValidator;
import com.capgemini.chess.algorithms.piecesValidators.QueenMoveValidator;
import com.capgemini.chess.algorithms.piecesValidators.RookMoveValidator;

/**
 * Chess piece types
 * 
 * @author Michal Bejm
 *
 */
public enum PieceType {
	KING( getKingMoveValidator() ),
    QUEEN( getQueenMoveValidator() ),
    BISHOP( getBishopMoveValidator()),
    KNIGHT( getKinghtMoveValidator()),
    ROOK( getRookMoveValidator()),
    PAWN( getPawnMoveValidator());
	
	private PieceMoveValidator piece;
	
	private PieceType(PieceMoveValidator piece) {
		this.piece = piece;
		// TODO Auto-generated constructor stub
	}
	
	
	public PieceMoveValidator getInstant(){
		return piece;
	}
	
	 static PieceMoveValidator getPawnMoveValidator(){
		return new PawnMoveValidator(); 
		
	}
	
	static PieceMoveValidator getQueenMoveValidator(){
		return new QueenMoveValidator(); 
		
	}
	
	static PieceMoveValidator getBishopMoveValidator(){
		return new BishopMoveValidator(); 
		
	}
	
	static PieceMoveValidator getKingMoveValidator(){
		return new KingMoveValidator(); 
		
	}
	static PieceMoveValidator getKinghtMoveValidator(){
		return new KinghtMoveValidator(); 
		
	}
	static PieceMoveValidator getRookMoveValidator(){
		return new RookMoveValidator(); 
		
	}
	
}
