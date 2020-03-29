package com.joeyksclark.chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PawnTest {

    @Test
    public void testCanMoveNoPieces() {
        Board board = new Board();
        Pawn pawn = new Pawn(Color.WHITE);

        //no location set
        assertFalse(pawn.canMove(board, board.getSquare(4,4)));
        assertFalse(pawn.canMove(board, board.getSquare(0,0)));
        assertFalse(pawn.canMove(board, board.getSquare(1,2)));
        assertFalse(pawn.canMove(board, board.getSquare(1,5)));

        pawn.setLocation(board.getSquare(0, 1));
        assertTrue(pawn.canMove(board, board.getSquare(0,2)));
        assertTrue(pawn.canMove(board, board.getSquare(0,3)));
        assertFalse(pawn.canMove(board, board.getSquare(0,4)));
        assertFalse(pawn.canMove(board, board.getSquare(1,2)));
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                pawn.canMove(board, board.getSquare(-1, 2)));

        pawn.incrementNumMoves();
        assertTrue(pawn.canMove(board, board.getSquare(0,2)));
        assertFalse(pawn.canMove(board, board.getSquare(0,3)));
        assertFalse(pawn.canMove(board, board.getSquare(0,4)));
    }

    @Test
    public void testCanMoveWithPieces() {
        Board board = new Board();
        Pawn pawn = new Pawn(Color.WHITE);
        pawn.setLocation(board.getSquare(2, 1));

        assertTrue(pawn.canMove(board, board.getSquare(2,2)));
        assertTrue(pawn.canMove(board, board.getSquare(2,3)));
        assertFalse(pawn.canMove(board, board.getSquare(2,4)));
        assertFalse(pawn.canMove(board, board.getSquare(3,2)));
        assertFalse(pawn.canMove(board, board.getSquare(1,2)));

        board.getSquare(2,3).setPiece(new Queen(Color.WHITE));
        assertTrue(pawn.canMove(board, board.getSquare(2,2)));
        assertFalse(pawn.canMove(board, board.getSquare(2,3)));
        assertFalse(pawn.canMove(board, board.getSquare(2,4)));
        assertFalse(pawn.canMove(board, board.getSquare(3,2)));
        assertFalse(pawn.canMove(board, board.getSquare(1,2)));

        board.getSquare(2,2).setPiece(new Knight(Color.BLACK));
        assertFalse(pawn.canMove(board, board.getSquare(2,2)));
        assertFalse(pawn.canMove(board, board.getSquare(2,3)));
        assertFalse(pawn.canMove(board, board.getSquare(2,4)));
        assertFalse(pawn.canMove(board, board.getSquare(3,2)));
        assertFalse(pawn.canMove(board, board.getSquare(1,2)));

        board.getSquare(3,2).setPiece(new Rook(Color.WHITE));
        board.getSquare(1,2).setPiece(new King(Color.WHITE));
        assertFalse(pawn.canMove(board, board.getSquare(2,2)));
        assertFalse(pawn.canMove(board, board.getSquare(2,3)));
        assertFalse(pawn.canMove(board, board.getSquare(2,4)));
        assertFalse(pawn.canMove(board, board.getSquare(3,2)));
        assertFalse(pawn.canMove(board, board.getSquare(1,2)));

        board.getSquare(3,2).setPiece(new Queen(Color.BLACK));
        board.getSquare(1,2).setPiece(new Pawn(Color.BLACK));
        assertFalse(pawn.canMove(board, board.getSquare(2,2)));
        assertFalse(pawn.canMove(board, board.getSquare(2,3)));
        assertFalse(pawn.canMove(board, board.getSquare(2,4)));
        assertTrue(pawn.canMove(board, board.getSquare(3,2)));
        assertTrue(pawn.canMove(board, board.getSquare(1,2)));
    }
}
