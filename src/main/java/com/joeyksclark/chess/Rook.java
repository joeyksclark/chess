package com.joeyksclark.chess;

public class Rook extends Piece {
    public Rook(Color color) {
        super(color);
    }

    public Rook(Color color, Square location) {
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

        //custom logic

        return false;
    }

    @Override
    public String toString() {
        if(getColor() == Color.WHITE) {
            return DisplayColors.WHITE + " R " + DisplayColors.RESET;
        } else if(getColor() == Color.BLACK) {
            return DisplayColors.GREEN + " R " + DisplayColors.RESET;
        }
        return DisplayColors.RED + " R " + DisplayColors.RESET;
    }
}