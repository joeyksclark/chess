package com.joeyksclark.chess;

public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color);
    }

    public Bishop(Color color, Square location) {
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

        //if no piece at destination or opposite color
        if(destination.getPiece() == null || destination.getPiece().getColor() == getOppositeColor()) {
            int xdiff = this.getLocation().getX() - destination.getX();
            int ydiff = this.getLocation().getY() - destination.getY();

            if(Math.abs(xdiff) == Math.abs(ydiff)) {
                //TODO
                for(int i = 0; i < Math.abs(xdiff); i++) {
                    if(xdiff < 0 && ydiff < 0) {

                    }
                    if(false) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return " B ";
    }
}