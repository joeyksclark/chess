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
        if(this.getLocation() == null || getLocation().equals(destination)) {
            return false;
        }

        if(this.isCaptured()) {
            return false;
        }

        //if no piece at destination or opposite color
        if(destination.getPiece() == null || destination.getPiece().getColor() == getOppositeColor()) {
            int xdiff = getLocation().getX() - destination.getX();
            int ydiff = getLocation().getY() - destination.getY();

            //diagonals
            if (Math.abs(xdiff) == Math.abs(ydiff)) {
                for (int i = 0; i < Math.abs(xdiff); i++) {
                    //right and up
                    if (xdiff < 0 && ydiff < 0) {
                        if (board.getSquare(getLocation().getX() + i, getLocation().getY() + i).getPiece() != null) {
                            return false;
                        }
                        //right and down
                    } else if (xdiff < 0 && ydiff > 0) {
                        if (board.getSquare(getLocation().getX() + i, getLocation().getY() - i).getPiece() != null) {
                            return false;
                        }
                        //left and down
                    } else if (xdiff > 0 && ydiff > 0) {
                        if (board.getSquare(getLocation().getX() - i, getLocation().getY() - i).getPiece() != null) {
                            return false;
                        }
                        //left and up
                    } else if (xdiff > 0 && ydiff < 0) {
                        if (board.getSquare(getLocation().getX() - i, getLocation().getY() + i).getPiece() != null) {
                            return false;
                        }
                    }
                }
                return true;
            //up and down
            } else if (xdiff == 0 && ydiff != 0) {
                for (int i = 0; i < Math.abs(ydiff); i++) {
                    if (ydiff > 0) {
                        if (board.getSquare(getLocation().getX(), getLocation().getY() - i).getPiece() != null) {
                            return false;
                        }
                    } else {
                        if (board.getSquare(getLocation().getX(), getLocation().getY() + i).getPiece() != null) {
                            return false;
                        }
                    }
                }
                return true;
            //left and right
            }else if(xdiff != 0 && ydiff == 0) {
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
        return " Q ";
    }
}