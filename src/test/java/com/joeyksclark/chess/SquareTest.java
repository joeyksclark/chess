package com.joeyksclark.chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SquareTest {

    @Test
    public void testSquareNoPiece() {
        Square square = new Square(1,2);
        assertEquals(1, square.getX());
        assertEquals(2, square.getY());
        assertEquals(null, square.getPiece());

        square.setX(3);
        assertEquals(3, square.getX());
        assertEquals(2, square.getY());
        assertEquals(null, square.getPiece());

        square.setY(4);
        assertEquals(3, square.getX());
        assertEquals(4, square.getY());
        assertEquals(null, square.getPiece());
    }

    @Test
    public void testSquareWithPiece() {
        Square square = new Square(1,2, new Knight(Color.WHITE));
        assertEquals(square.getPiece(), new Knight(Color.WHITE));
        assertNotEquals(square.getPiece(), new Knight(Color.BLACK));

        square.setPiece(new Knight(Color.BLACK));
        assertEquals(square.getPiece(), new Knight(Color.BLACK));
        assertNotEquals(square.getPiece(), new Knight(Color.WHITE));

        square.setPiece(new Queen(Color.BLACK));
        assertEquals(square.getPiece(), new Queen(Color.BLACK));
        assertNotEquals(square.getPiece(), new Knight(Color.WHITE));
        assertNotEquals(square.getPiece(), new Knight(Color.BLACK));
    }
}
