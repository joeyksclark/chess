package com.joeyksclark.chess;

public class Chess {
    public static void main(String[] args) {
        Board board = new Board();
        board.printBoard();

        System.out.println();

        board.newGame();
        board.printBoard();
    }
}
