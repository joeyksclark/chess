package com.joeyksclark.chess;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class KnightTest {

    //without pieces
    //with pieces of same color
    //with pieces of opposite color
    //out of bounds

    @Test
    public void testCanMove() {
        Board board = new Board();
        Knight knight = new Knight(Color.WHITE);

        assertFalse(knight.canMove(board, board.getSquare(4,4)));

        knight.setLocation(board.getSquare(4,4));
        assertFalse(knight.canMove(board, board.getSquare(4,4)));

    }
}
