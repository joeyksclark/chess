package com.joeyksclark.chess;

public class Knight extends Piece {
    public Knight(Color color) {
        super(color);
    }

    public Knight(Color color, Square location) {
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

        if(destination.getPiece() == null) {
            int xdiff = Math.abs(this.getLocation().getX() - destination.getX());
            int ydiff = Math.abs(this.getLocation().getY() - destination.getY());

            if(xdiff == 1 && ydiff == 2) {
                return true;
            }
            if(xdiff == 2 && ydiff == 1) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return " H ";
    }
}