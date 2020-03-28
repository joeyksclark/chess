package com.joeyksclark.chess;

public class Square {
    private int x;
    private int y;
    private Piece piece;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Square(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        if(piece == null){
            return " . ";
        } else {
            return piece.toString();
        }
    }

    @Override
    public boolean equals(Object b) {
        if(b == this) {
            return true;
        }

        if(b == null || b.getClass() != getClass()) {
            return false;
        }

        Square s = (Square) b;

        if((s.getX() == x) && (s.getY() == y)) {
            if(s.getPiece() != null) {
                return s.getPiece().equals(getPiece());
            } else {
                return getPiece() == null;
            }
        }

        return false;
    }
}