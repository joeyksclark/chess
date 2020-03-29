package com.joeyksclark.chess;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class KingTest {

    @Test
    public void testCanMoveNoPieces() {
        Board board = new Board();
        King king = new King(Color.BLACK);

        //no location set
        assertFalse(king.canMove(board, board.getSquare(4,4)));
        assertFalse(king.canMove(board, board.getSquare(5,4)));
        assertFalse(king.canMove(board, board.getSquare(4,3)));
        assertFalse(king.canMove(board, board.getSquare(0,0)));

        king.setLocation(board.getSquare(4,4));
        assertFalse(king.canMove(board, board.getSquare(4,4)));
        assertTrue(king.canMove(board, board.getSquare(5,4)));
        assertTrue(king.canMove(board, board.getSquare(3,4)));
        assertTrue(king.canMove(board, board.getSquare(5,3)));
        assertTrue(king.canMove(board, board.getSquare(4,3)));
        assertTrue(king.canMove(board, board.getSquare(3,5)));
        assertTrue(king.canMove(board, board.getSquare(4,5)));
        assertTrue(king.canMove(board, board.getSquare(5,5)));
        assertTrue(king.canMove(board, board.getSquare(3,3)));
    }

    @Test
    public void testCanMoveWithPieces() {
        Board board = new Board();
        King king = new King(Color.BLACK);

        king.setLocation(board.getSquare(4,4));
        board.getSquare(5,4).setPiece(new Rook(Color.WHITE));
        board.getSquare(3,4).setPiece(new Queen(Color.WHITE));
        board.getSquare(5,3).setPiece(new Bishop(Color.WHITE));
        board.getSquare(4,3).setPiece(new Knight(Color.WHITE));

        assertFalse(king.canMove(board, board.getSquare(4,4)));
        assertTrue(king.canMove(board, board.getSquare(5,4)));
        assertTrue(king.canMove(board, board.getSquare(3,4)));
        assertTrue(king.canMove(board, board.getSquare(5,3)));
        assertTrue(king.canMove(board, board.getSquare(4,3)));

        board.getSquare(3,5).setPiece(new Pawn(Color.BLACK));
        board.getSquare(4,5).setPiece(new Bishop(Color.BLACK));
        board.getSquare(5,5).setPiece(new King(Color.BLACK));
        board.getSquare(3,3).setPiece(new Rook(Color.BLACK));

        assertFalse(king.canMove(board, board.getSquare(4,4)));
        assertFalse(king.canMove(board, board.getSquare(3,5)));
        assertFalse(king.canMove(board, board.getSquare(4,5)));
        assertFalse(king.canMove(board, board.getSquare(5,5)));
        assertFalse(king.canMove(board, board.getSquare(3,3)));
    }
}
