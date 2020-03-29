package com.joeyksclark.chess;

public class King extends Piece {
    public King(Color color) {
        super(color);
    }

    public King(Color color, Square location) {
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

        if(destination.getPiece() == null || destination.getPiece().getColor() == getOppositeColor()) {
            int xdiff = Math.abs(this.getLocation().getX() - destination.getX());
            int ydiff = Math.abs(this.getLocation().getY() - destination.getY());

            if(xdiff <= 1 && ydiff <= 1 && !destination.equals(getLocation())) {
                return true;
            }
        }

        //TODO implement castling

        return false;
    }

    @Override
    public String toString() {
        return " K ";
    }
}