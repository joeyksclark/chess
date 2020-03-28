package com.joeyksclark.chess;

public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color);
    }

    public Pawn(Color color, Square location) {
        super(color, location);
    }

    @Override
    public boolean canMove(Board board, Square destination) {
        if(this.getLocation() == null) {
            return false;
        }

        if(this.isCaptured()) {
            return false;
        }

        //if hasn't moved, ydiff = 2, xdiff = 0, nothing at destination or in the way
        //else if ydiff = 1, xdiff = 0, nothing at destination
        //TODO implement en passant

        return false;
    }

    @Override
    public String toString() {
        if(getColor() == Color.WHITE) {
            return DisplayColors.WHITE + " P " + DisplayColors.RESET;
        } else if(getColor() == Color.BLACK) {
            return DisplayColors.GREEN + " P " + DisplayColors.RESET;
        }
        return DisplayColors.RED + " P " + DisplayColors.RESET;
    }
}