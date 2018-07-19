package com.capgemini.chess.algorithms.piecesValidators;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.generated.Board;

public class RookMove {

	private int xFrom;
	private int yFrom;
	private int xTo;
	private int yTo;

	public RookMove(int xFrom, int yFrom, int xTo, int yTo) {
		this.xFrom = xFrom;
		this.yFrom = yFrom;
		this.xTo = xTo;
		this.yTo = yTo;
	}

	public boolean isAllPathFree(Board board) {

		Coordinate coordinate;

		int factor = 1;
		if (yTo < yFrom || xTo < xFrom) {
			factor = -1;
		}

		if (yTo != yFrom) {
			for (int y = yFrom + factor; Math.abs(yTo - y) > 0; y += factor) {
				coordinate = new Coordinate(xTo, y);
				if (board.getPieceAt(coordinate) != null) {
					return false;
				}
			}
		} else {
			for (int x = xFrom + factor; Math.abs(xTo - x) > 0; x += factor) {
				coordinate = new Coordinate(x, yTo);
				if (board.getPieceAt(coordinate) != null) {
					return false;
				}
			}
		}

		return true;
	}

	public boolean check() {

		if ((xFrom == xTo) || (yFrom == yTo)) {
			return true;
		}

		return false;
	}

}
