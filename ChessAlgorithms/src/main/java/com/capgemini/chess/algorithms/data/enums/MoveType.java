package com.capgemini.chess.algorithms.data.enums;

/**
 * Types of moves
 * 
 * @author Michal Bejm
 *
 */
public enum MoveType {
	ATTACK, //zwykly ruch
	CAPTURE, //bicie
	CASTLING,
	EN_PASSANT;
}
