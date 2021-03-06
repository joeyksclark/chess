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

        int xdiff = this.getLocation().getX() - destination.getX();
        int ydiff = this.getLocation().getY() - destination.getY();

        if(getColor() == Color.WHITE && ydiff < 0 && Math.abs(xdiff) <= 1) {

            //can move forward one if no pieces are in the way
            if(ydiff == -1 && xdiff == 0 && destination.getPiece() == null) {
                return true;
            }

            //can move forward two if no pieces and hasn't moved
            if(ydiff == -2 && xdiff == 0 && getNumMoves() == 0 && destination.getPiece() == null &&
            board.getSquare(destination.getX(), destination.getY()-1).getPiece() == null) {
                return true;
            }

            //can move diagonal if piece of opposite color there
            if(ydiff == -1 && Math.abs(xdiff) == 1 && destination.getPiece() != null &&
                    destination.getPiece().getColor() == getOppositeColor()) {
                return true;
            }
        }

        if(getColor() == Color.BLACK && ydiff > 0 && Math.abs(xdiff) <= 1) {
            //can move forward one if no pieces are in the way
            if(ydiff == 1 && xdiff == 0 && destination.getPiece() == null) {
                return true;
            }

            //can move forward two if no pieces and hasn't moved
            if(ydiff == 2 && xdiff == 0 && getNumMoves() == 0 && destination.getPiece() == null &&
                    board.getSquare(destination.getX(), destination.getY()-1).getPiece() == null) {
                return true;
            }

            //can move diagonal if piece of opposite color there
            if(ydiff == 1 && Math.abs(xdiff) == 1 && destination.getPiece() != null &&
                    destination.getPiece().getColor() == getOppositeColor()) {
                return true;
            }
        }

        //TODO implement en passant

        return false;
    }

    @Override
    public String toString() {
        return " P ";
    }
}