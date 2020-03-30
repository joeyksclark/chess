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

        if(destination.getPiece() == null || destination.getPiece().getColor() == getOppositeColor()) {
            int xdiff = this.getLocation().getX() - destination.getX();
            int ydiff = this.getLocation().getY() - destination.getY();

            //move in y direction
            if(xdiff == 0 && ydiff != 0) {
                for(int i = 0; i < Math.abs(ydiff); i++) {
                    if(ydiff > 0) {
                        if(board.getSquare(getLocation().getX(), getLocation().getY()-i).getPiece() != null) {
                            return false;
                        }
                    } else {
                        if(board.getSquare(getLocation().getX(), getLocation().getY()+i).getPiece() != null) {
                            return false;
                        }
                    }
                }
                return true;
            }

            //move in x direction
            if(xdiff != 0 && ydiff == 0) {
                for(int i = 0; i < Math.abs(xdiff); i++) {
                    if(xdiff > 0) {
                        if(board.getSquare(getLocation().getX()-i, getLocation().getY()).getPiece() != null) {
                            return false;
                        }
                    } else {
                        if(board.getSquare(getLocation().getX()+i, getLocation().getY()).getPiece() != null) {
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
        return " R ";
    }
}