package com.joeyksclark.chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueenTest {

    @Test
    public void testCanMoveNoPieces() {
        Board board = new Board();
        Queen queen = new Queen(Color.WHITE);

        //no location set
        assertFalse(queen.canMove(board, board.getSquare(4,4)));
        assertFalse(queen.canMove(board, board.getSquare(7,4)));
        assertFalse(queen.canMove(board, board.getSquare(1,4)));
        assertFalse(queen.canMove(board, board.getSquare(4,0)));
        assertFalse(queen.canMove(board, board.getSquare(4,6)));
        assertFalse(queen.canMove(board, board.getSquare(7,7)));
        assertFalse(queen.canMove(board, board.getSquare(1,1)));
        assertFalse(queen.canMove(board, board.getSquare(5,3)));
        assertFalse(queen.canMove(board, board.getSquare(1,7)));

        queen.setLocation(board.getSquare(4,4));

        assertFalse(queen.canMove(board, board.getSquare(4,4)));
        assertTrue(queen.canMove(board, board.getSquare(7,4)));
        assertTrue(queen.canMove(board, board.getSquare(6,4)));
        assertTrue(queen.canMove(board, board.getSquare(5,4)));
        assertTrue(queen.canMove(board, board.getSquare(4,0)));
        assertTrue(queen.canMove(board, board.getSquare(4,3)));
        assertTrue(queen.canMove(board, board.getSquare(4,6)));
        assertTrue(queen.canMove(board, board.getSquare(4,7)));
        assertTrue(queen.canMove(board, board.getSquare(3,4)));

        assertTrue(queen.canMove(board, board.getSquare(5,5)));
        assertTrue(queen.canMove(board, board.getSquare(7,7)));
        assertTrue(queen.canMove(board, board.getSquare(3,3)));
        assertTrue(queen.canMove(board, board.getSquare(0,0)));
        assertTrue(queen.canMove(board, board.getSquare(5,3)));
        assertTrue(queen.canMove(board, board.getSquare(7,1)));
        assertTrue(queen.canMove(board, board.getSquare(3,5)));
        assertTrue(queen.canMove(board, board.getSquare(1,7)));

    }

    @Test
    public void testCanMoveWithPieces() {
        Board board = new Board();
        Queen queen = new Queen(Color.WHITE);
        queen.setLocation(board.getSquare(4,4));

        //same color pieces
        board.getSquare(4,6).setPiece(new Pawn(Color.WHITE));
        board.getSquare(4,2).setPiece(new Queen(Color.WHITE));
        board.getSquare(2,4).setPiece(new Bishop(Color.WHITE));
        board.getSquare(6,4).setPiece(new King(Color.WHITE));
        board.getSquare(6,6).setPiece(new Pawn(Color.WHITE));
        board.getSquare(2,2).setPiece(new Queen(Color.WHITE));
        board.getSquare(2,6).setPiece(new Queen(Color.WHITE));
        board.getSquare(6,2).setPiece(new King(Color.WHITE));

        assertTrue(queen.canMove(board, board.getSquare(4,5)));
        assertFalse(queen.canMove(board, board.getSquare(4,6)));
        assertFalse(queen.canMove(board, board.getSquare(4,7)));

        assertTrue(queen.canMove(board, board.getSquare(4,3)));
        assertFalse(queen.canMove(board, board.getSquare(4,2)));
        assertFalse(queen.canMove(board, board.getSquare(4,1)));

        assertTrue(queen.canMove(board, board.getSquare(3,4)));
        assertFalse(queen.canMove(board, board.getSquare(2,4)));
        assertFalse(queen.canMove(board, board.getSquare(0,4)));

        assertTrue(queen.canMove(board, board.getSquare(5,4)));
        assertFalse(queen.canMove(board, board.getSquare(6,4)));
        assertFalse(queen.canMove(board, board.getSquare(7,4)));

        assertTrue(queen.canMove(board, board.getSquare(5,5)));
        assertFalse(queen.canMove(board, board.getSquare(6,6)));
        assertFalse(queen.canMove(board, board.getSquare(7,7)));

        assertTrue(queen.canMove(board, board.getSquare(3,3)));
        assertFalse(queen.canMove(board, board.getSquare(2,2)));
        assertFalse(queen.canMove(board, board.getSquare(1,1)));

        assertTrue(queen.canMove(board, board.getSquare(5,3)));
        assertFalse(queen.canMove(board, board.getSquare(6,2)));
        assertFalse(queen.canMove(board, board.getSquare(7,1)));

        assertTrue(queen.canMove(board, board.getSquare(3,5)));
        assertFalse(queen.canMove(board, board.getSquare(2,6)));
        assertFalse(queen.canMove(board, board.getSquare(1,7)));

        //opposite color pieces
        board.getSquare(4,6).setPiece(new King(Color.BLACK));
        board.getSquare(4,2).setPiece(new Knight(Color.BLACK));
        board.getSquare(2,4).setPiece(new Queen(Color.BLACK));
        board.getSquare(6,4).setPiece(new Pawn(Color.BLACK));
        board.getSquare(6,6).setPiece(new King(Color.BLACK));
        board.getSquare(2,2).setPiece(new Knight(Color.BLACK));
        board.getSquare(2,6).setPiece(new Queen(Color.BLACK));
        board.getSquare(6,2).setPiece(new Rook(Color.BLACK));

        assertTrue(queen.canMove(board, board.getSquare(4,5)));
        assertTrue(queen.canMove(board, board.getSquare(4,6)));
        assertFalse(queen.canMove(board, board.getSquare(4,7)));

        assertTrue(queen.canMove(board, board.getSquare(4,3)));
        assertTrue(queen.canMove(board, board.getSquare(4,2)));
        assertFalse(queen.canMove(board, board.getSquare(4,1)));

        assertTrue(queen.canMove(board, board.getSquare(3,4)));
        assertTrue(queen.canMove(board, board.getSquare(2,4)));
        assertFalse(queen.canMove(board, board.getSquare(0,4)));

        assertTrue(queen.canMove(board, board.getSquare(5,4)));
        assertTrue(queen.canMove(board, board.getSquare(6,4)));
        assertFalse(queen.canMove(board, board.getSquare(7,4)));

        assertTrue(queen.canMove(board, board.getSquare(5,5)));
        assertTrue(queen.canMove(board, board.getSquare(6,6)));
        assertFalse(queen.canMove(board, board.getSquare(7,7)));

        assertTrue(queen.canMove(board, board.getSquare(3,3)));
        assertTrue(queen.canMove(board, board.getSquare(2,2)));
        assertFalse(queen.canMove(board, board.getSquare(1,1)));

        assertTrue(queen.canMove(board, board.getSquare(5,3)));
        assertTrue(queen.canMove(board, board.getSquare(6,2)));
        assertFalse(queen.canMove(board, board.getSquare(7,1)));

        assertTrue(queen.canMove(board, board.getSquare(3,5)));
        assertTrue(queen.canMove(board, board.getSquare(2,6)));
        assertFalse(queen.canMove(board, board.getSquare(1,7)));
    }
}