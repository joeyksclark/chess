package com.joeyksclark.chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightTest {

    @Test
    public void testCanMoveNoPieces() {
        Board board = new Board();
        Knight knight = new Knight(Color.WHITE);

        //no location set
        assertFalse(knight.canMove(board, board.getSquare(4,4)));
        assertFalse(knight.canMove(board, board.getSquare(0,0)));

        knight.setLocation(board.getSquare(4,4));
        assertFalse(knight.canMove(board, board.getSquare(4,4)));
        assertFalse(knight.canMove(board, board.getSquare(0,0)));
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                    knight.canMove(board, board.getSquare(-1, -1)));

        assertTrue(knight.canMove(board, board.getSquare(5,6)));
        assertTrue(knight.canMove(board, board.getSquare(6,5)));
        assertTrue(knight.canMove(board, board.getSquare(3,2)));
        assertTrue(knight.canMove(board, board.getSquare(2,3)));
        assertTrue(knight.canMove(board, board.getSquare(2,5)));
        assertTrue(knight.canMove(board, board.getSquare(3,6)));
        assertTrue(knight.canMove(board, board.getSquare(5,2)));
        assertTrue(knight.canMove(board, board.getSquare(6,3)));
    }

    @Test
    public void testCanMoveWithPieces() {
        Board board = new Board();
        Knight knight = new Knight(Color.WHITE);
        knight.setLocation(board.getSquare(4,4));

        //same color pieces
        board.getSquare(5,6).setPiece(new Pawn(Color.WHITE));
        board.getSquare(6,5).setPiece(new Rook(Color.WHITE));
        board.getSquare(3,2).setPiece(new Queen(Color.WHITE));
        board.getSquare(2,3).setPiece(new King(Color.WHITE));

        assertFalse(knight.canMove(board, board.getSquare(5,6)));
        assertFalse(knight.canMove(board, board.getSquare(6,5)));
        assertFalse(knight.canMove(board, board.getSquare(3,2)));
        assertFalse(knight.canMove(board, board.getSquare(2,3)));

        //opposite color pieces
        board.getSquare(2,5).setPiece(new Bishop(Color.BLACK));
        board.getSquare(3,6).setPiece(new Knight(Color.BLACK));
        board.getSquare(5,2).setPiece(new Queen(Color.BLACK));
        board.getSquare(6,3).setPiece(new Pawn(Color.BLACK));

        assertTrue(knight.canMove(board, board.getSquare(2,5)));
        assertTrue(knight.canMove(board, board.getSquare(3,6)));
        assertTrue(knight.canMove(board, board.getSquare(5,2)));
        assertTrue(knight.canMove(board, board.getSquare(6,3)));
    }
}
