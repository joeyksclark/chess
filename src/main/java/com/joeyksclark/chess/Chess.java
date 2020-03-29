package com.joeyksclark.chess;

public class Chess {
    public static void main(String[] args) {
        Board board = new Board();
        board.printBoard(Color.WHITE);

        System.out.println("------------------------");

        board.newGame();
        System.out.println("White:");
        board.printBoard(Color.WHITE);

        System.out.println("------------------------");

        System.out.println("Black:");
        board.printBoard(Color.BLACK);
    }
}
