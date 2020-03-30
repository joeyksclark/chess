package com.joeyksclark.chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BishopTest {

    @Test
    public void testCanMoveNoPieces() {
        Board board = new Board();
        Bishop bishop = new Bishop(Color.BLACK);

        //no location set
        assertFalse(bishop.canMove(board, board.getSquare(4,4)));
        assertFalse(bishop.canMove(board, board.getSquare(7,7)));
        assertFalse(bishop.canMove(board, board.getSquare(1,1)));
        assertFalse(bishop.canMove(board, board.getSquare(5,3)));
        assertFalse(bishop.canMove(board, board.getSquare(1,7)));

        bishop.setLocation(board.getSquare(4,4));
        assertFalse(bishop.canMove(board, board.getSquare(4,4)));
        assertTrue(bishop.canMove(board, board.getSquare(5,5)));
        assertTrue(bishop.canMove(board, board.getSquare(7,7)));
        assertTrue(bishop.canMove(board, board.getSquare(3,3)));
        assertTrue(bishop.canMove(board, board.getSquare(0,0)));
        assertTrue(bishop.canMove(board, board.getSquare(5,3)));
        assertTrue(bishop.canMove(board, board.getSquare(7,1)));
        assertTrue(bishop.canMove(board, board.getSquare(3,5)));
        assertTrue(bishop.canMove(board, board.getSquare(1,7)));
    }

    @Test
    public void testCanMoveWithPieces() {
        Board board = new Board();
        Bishop bishop = new Bishop(Color.BLACK);
        bishop.setLocation(board.getSquare(4,4));

        //same color pieces
        board.getSquare(6,6).setPiece(new Pawn(Color.BLACK));
        board.getSquare(2,2).setPiece(new Rook(Color.BLACK));
        board.getSquare(2,6).setPiece(new Queen(Color.BLACK));
        board.getSquare(6,2).setPiece(new King(Color.BLACK));

        assertTrue(bishop.canMove(board, board.getSquare(5,5)));
        assertFalse(bishop.canMove(board, board.getSquare(6,6)));
        assertFalse(bishop.canMove(board, board.getSquare(7,7)));

        assertTrue(bishop.canMove(board, board.getSquare(3,3)));
        assertFalse(bishop.canMove(board, board.getSquare(2,2)));
        assertFalse(bishop.canMove(board, board.getSquare(1,1)));

        assertTrue(bishop.canMove(board, board.getSquare(5,3)));
        assertFalse(bishop.canMove(board, board.getSquare(6,2)));
        assertFalse(bishop.canMove(board, board.getSquare(7,1)));

        assertTrue(bishop.canMove(board, board.getSquare(3,5)));
        assertFalse(bishop.canMove(board, board.getSquare(2,6)));
        assertFalse(bishop.canMove(board, board.getSquare(1,7)));

        //opposite color pieces
        board.getSquare(6,6).setPiece(new King(Color.WHITE));
        board.getSquare(2,2).setPiece(new Knight(Color.WHITE));
        board.getSquare(2,6).setPiece(new Rook(Color.WHITE));
        board.getSquare(6,2).setPiece(new Queen(Color.WHITE));

        assertTrue(bishop.canMove(board, board.getSquare(5,5)));
        assertTrue(bishop.canMove(board, board.getSquare(6,6)));
        assertFalse(bishop.canMove(board, board.getSquare(7,7)));

        assertTrue(bishop.canMove(board, board.getSquare(3,3)));
        assertTrue(bishop.canMove(board, board.getSquare(2,2)));
        assertFalse(bishop.canMove(board, board.getSquare(1,1)));

        assertTrue(bishop.canMove(board, board.getSquare(5,3)));
        assertTrue(bishop.canMove(board, board.getSquare(6,2)));
        assertFalse(bishop.canMove(board, board.getSquare(7,1)));

        assertTrue(bishop.canMove(board, board.getSquare(3,5)));
        assertTrue(bishop.canMove(board, board.getSquare(2,6)));
        assertFalse(bishop.canMove(board, board.getSquare(1,7)));
    }
}
