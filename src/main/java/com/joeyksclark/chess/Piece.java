package com.joeyksclark.chess;

public abstract class Piece {
    private Color color;
    private Square location;
    private boolean captured;
    private boolean hasMoved;

    public Piece(Color color) {
        this.color = color;
        this.captured = false;
        this.hasMoved = false;
    }

    public Piece(Color color, Square location) {
        this.color = color;
        this.location = location;
        this.captured = false;
        this.hasMoved = false;
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

    public boolean hasMoved() {
        return this.hasMoved;
    }

    public void setMoved() {
        this.hasMoved = true;
    }

    public boolean equals(Object b) {
        if(b == this) {
            return true;
        }

        if(b == null || b.getClass() != getClass()) {
            return false;
        }

        Piece p = (Piece) b;

        if((p.isCaptured() == isCaptured()) && (p.hasMoved() == hasMoved()) && (p.getColor() == getColor())) {
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