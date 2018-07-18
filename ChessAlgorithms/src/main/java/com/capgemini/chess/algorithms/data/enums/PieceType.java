package com.capgemini.chess.algorithms.data.enums;

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
	KING,
    QUEEN,
    BISHOP,
    KNIGHT,
    ROOK,
    PAWN;
	
	private PieceMoveValidator piece;
	
	private PieceType() {
		
		// TODO Auto-generated constructor stub
	}
	
	
}
