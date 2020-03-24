package com.joeyksclark.chess;

public abstract class Piece {
    private Color color;
    private Square location;
    private boolean captured;
    private boolean hasMoved;

    public Piece(Color color) {
        this.color = color;
        this.hasMoved = false;
    }

    public Piece(Color color, Square location) {
        this.color = color;
        this.location = location;
        this.hasMoved = false;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
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

    public abstract boolean canMove(Board board, Square destination);
}