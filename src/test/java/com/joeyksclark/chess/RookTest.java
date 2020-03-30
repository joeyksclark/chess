package com.joeyksclark.chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RookTest {

    @Test
    public void testCanMoveNoPieces() {
        Board board = new Board();
        Rook rook = new Rook(Color.WHITE);

        //no location set
        assertFalse(rook.canMove(board, board.getSquare(4,4)));
        assertFalse(rook.canMove(board, board.getSquare(7,4)));
        assertFalse(rook.canMove(board, board.getSquare(1,4)));
        assertFalse(rook.canMove(board, board.getSquare(4,0)));
        assertFalse(rook.canMove(board, board.getSquare(4,6)));

        rook.setLocation(board.getSquare(4,4));
        assertFalse(rook.canMove(board, board.getSquare(4,4)));
        assertTrue(rook.canMove(board, board.getSquare(7,4)));
        assertTrue(rook.canMove(board, board.getSquare(6,4)));
        assertTrue(rook.canMove(board, board.getSquare(5,4)));
        assertTrue(rook.canMove(board, board.getSquare(4,0)));
        assertTrue(rook.canMove(board, board.getSquare(4,3)));
        assertTrue(rook.canMove(board, board.getSquare(4,6)));
        assertTrue(rook.canMove(board, board.getSquare(4,7)));
        assertTrue(rook.canMove(board, board.getSquare(3,4)));
    }

    @Test
    public void testCanMoveWithPieces() {
        Board board = new Board();
        Rook rook = new Rook(Color.WHITE);
        rook.setLocation(board.getSquare(4,4));

        //same color pieces
        board.getSquare(4,6).setPiece(new Pawn(Color.WHITE));
        board.getSquare(4,2).setPiece(new Rook(Color.WHITE));
        board.getSquare(2,4).setPiece(new Queen(Color.WHITE));
        board.getSquare(6,4).setPiece(new King(Color.WHITE));

        assertTrue(rook.canMove(board, board.getSquare(4,5)));
        assertFalse(rook.canMove(board, board.getSquare(4,6)));
        assertFalse(rook.canMove(board, board.getSquare(4,7)));

        assertTrue(rook.canMove(board, board.getSquare(4,3)));
        assertFalse(rook.canMove(board, board.getSquare(4,2)));
        assertFalse(rook.canMove(board, board.getSquare(4,1)));

        assertTrue(rook.canMove(board, board.getSquare(3,4)));
        assertFalse(rook.canMove(board, board.getSquare(2,4)));
        assertFalse(rook.canMove(board, board.getSquare(0,4)));

        assertTrue(rook.canMove(board, board.getSquare(5,4)));
        assertFalse(rook.canMove(board, board.getSquare(6,4)));
        assertFalse(rook.canMove(board, board.getSquare(7,4)));

        //opposite color pieces
        board.getSquare(4,6).setPiece(new King(Color.BLACK));
        board.getSquare(4,2).setPiece(new Knight(Color.BLACK));
        board.getSquare(2,4).setPiece(new Rook(Color.BLACK));
        board.getSquare(6,4).setPiece(new Pawn(Color.BLACK));

        assertTrue(rook.canMove(board, board.getSquare(4,5)));
        assertTrue(rook.canMove(board, board.getSquare(4,6)));
        assertFalse(rook.canMove(board, board.getSquare(4,7)));

        assertTrue(rook.canMove(board, board.getSquare(4,3)));
        assertTrue(rook.canMove(board, board.getSquare(4,2)));
        assertFalse(rook.canMove(board, board.getSquare(4,1)));

        assertTrue(rook.canMove(board, board.getSquare(3,4)));
        assertTrue(rook.canMove(board, board.getSquare(2,4)));
        assertFalse(rook.canMove(board, board.getSquare(0,4)));

        assertTrue(rook.canMove(board, board.getSquare(5,4)));
        assertTrue(rook.canMove(board, board.getSquare(6,4)));
        assertFalse(rook.canMove(board, board.getSquare(7,4)));
    }
}
