package com.joeyksclark.chess;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    }
}
