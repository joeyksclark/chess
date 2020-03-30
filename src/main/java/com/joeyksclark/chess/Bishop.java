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
        if(getLocation() == null || getLocation().equals(destination)) {
            return false;
        }

        if(isCaptured()) {
            return false;
        }

        //if no piece at destination or opposite color
        if(destination.getPiece() == null || destination.getPiece().getColor() == getOppositeColor()) {
            int xdiff = getLocation().getX() - destination.getX();
            int ydiff = getLocation().getY() - destination.getY();

            if(Math.abs(xdiff) == Math.abs(ydiff)) {
                for(int i = 0; i < Math.abs(xdiff); i++) {
                    //right and up
                    if(xdiff < 0 && ydiff < 0) {
                        if(board.getSquare(getLocation().getX()+i, getLocation().getY()+i).getPiece() != null) {
                            return false;
                        }
                    //right and down
                    } else if(xdiff < 0 && ydiff > 0) {
                        if(board.getSquare(getLocation().getX()+i, getLocation().getY()-i).getPiece() != null) {
                            return false;
                        }
                    //left and down
                    } else if(xdiff > 0 && ydiff > 0) {
                        if(board.getSquare(getLocation().getX()-i, getLocation().getY()-i).getPiece() != null) {
                            return false;
                        }
                    //left and up
                    } else if(xdiff > 0 && ydiff < 0) {
                        if(board.getSquare(getLocation().getX()-i, getLocation().getY()+i).getPiece() != null) {
                            return false;
                        }
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