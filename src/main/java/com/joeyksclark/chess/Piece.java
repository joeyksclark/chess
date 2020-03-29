package com.joeyksclark.chess;

public abstract class Piece {
    private Color color;
    private Square location;
    private boolean captured;
    private boolean hasMoved;
    private int numMoves;

    public Piece(Color color) {
        this.color = color;
        this.captured = false;
        this.numMoves = 0;
    }

    public Piece(Color color, Square location) {
        this.color = color;
        this.location = location;
        this.captured = false;
        this.hasMoved = false;
        this.numMoves = 0;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getOppositeColor() {
        if(this.color != null) {
            if(this.color == Color.WHITE) {
                return Color.BLACK;
            }
            if(this.color == Color.BLACK) {
                return Color.WHITE;
            }
        }

        return null;
    }

    public Square getLocation() {
        return this.location;
    }

    public void setLocation(Square square) {
        this.location = square;
    }

    public boolean isCaptured() {
        return captured;
    }

    public void setCaptured(boolean captured) {
        this.captured = captured;
    }

    public int getNumMoves() {
        return numMoves;
    }

    public void incrementNumMoves() {
        this.numMoves++;
    }

    public boolean equals(Object b) {
        if(b == this) {
            return true;
        }

        if(b == null || b.getClass() != getClass()) {
            return false;
        }

        Piece p = (Piece) b;

        if((p.isCaptured() == isCaptured()) && (p.getNumMoves() == getNumMoves()) && (p.getColor() == getColor())) {
            if(p.getLocation() != null) {
                return p.getLocation().getX() == getLocation().getX() &&
                        p.getLocation().getY() == getLocation().getY();
            }
            return true;
        }

        return false;
    }

    public abstract boolean canMove(Board board, Square destination);
    public abstract String toString();
}