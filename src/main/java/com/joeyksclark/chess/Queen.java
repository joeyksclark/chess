package com.joeyksclark.chess;

public class Queen extends Piece {
    public Queen(Color color) {
        super(color);
    }

    public Queen(Color color, Square location) {
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
        return " Q ";
    }
}