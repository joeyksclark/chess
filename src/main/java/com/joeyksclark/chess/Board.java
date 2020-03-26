package com.joeyksclark.chess;

public class Board{
    private Square[][] board = new Square[8][8];

    public Board() {
        //blank board
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                board[i][j] = new Square(i,j);
            }
        }
    }

    public Square getSquare(int x, int y) {
        //TODO add bound checking
        return board[x][y];
    }

    //not sure if this has any use or should exist
    //thus the private for now
    private void setSquare(int x, int y, Square square) {
        board[x][y] = square;
    }

    public void newGame() {
        Square tempSquare;
        Piece tempPiece;

        for(int i = 0; i < 8; i++) {
            //white pawns
            tempSquare = getSquare(1,i);
            tempPiece = new Pawn(Color.WHITE, tempSquare);
            tempSquare.setPiece(tempPiece);
            board[1][i] = tempSquare;

            //black pawns
            tempSquare = getSquare(6,i);
            tempPiece = new Pawn(Color.BLACK, tempSquare);
            tempSquare.setPiece(tempPiece);
            board[6][i] = tempSquare;
        }

        //white pieces
        tempSquare = getSquare(0,0);
        tempPiece = new Rook(Color.WHITE, tempSquare);
        tempSquare.setPiece(tempPiece);

        tempSquare = getSquare(0,1);
        tempPiece = new Knight(Color.WHITE, tempSquare);
        tempSquare.setPiece(tempPiece);

        tempSquare = getSquare(0,2);
        tempPiece = new Bishop(Color.WHITE, tempSquare);
        tempSquare.setPiece(tempPiece);

        tempSquare = getSquare(0,3);
        tempPiece = new Queen(Color.WHITE, tempSquare);
        tempSquare.setPiece(tempPiece);

        tempSquare = getSquare(0,4);
        tempPiece = new King(Color.WHITE, tempSquare);
        tempSquare.setPiece(tempPiece);

        tempSquare = getSquare(0,5);
        tempPiece = new Bishop(Color.WHITE, tempSquare);
        tempSquare.setPiece(tempPiece);

        tempSquare = getSquare(0,6);
        tempPiece = new Knight(Color.WHITE, tempSquare);
        tempSquare.setPiece(tempPiece);

        tempSquare = getSquare(0,7);
        tempPiece = new Rook(Color.WHITE, tempSquare);
        tempSquare.setPiece(tempPiece);

        //black pieces
        tempSquare = getSquare(7,0);
        tempPiece = new Rook(Color.BLACK, tempSquare);
        tempSquare.setPiece(tempPiece);

        tempSquare = getSquare(7,1);
        tempPiece = new Knight(Color.BLACK, tempSquare);
        tempSquare.setPiece(tempPiece);

        tempSquare = getSquare(7,2);
        tempPiece = new Bishop(Color.BLACK, tempSquare);
        tempSquare.setPiece(tempPiece);

        tempSquare = getSquare(7,3);
        tempPiece = new Queen(Color.BLACK, tempSquare);
        tempSquare.setPiece(tempPiece);

        tempSquare = getSquare(7,4);
        tempPiece = new King(Color.BLACK, tempSquare);
        tempSquare.setPiece(tempPiece);

        tempSquare = getSquare(7,5);
        tempPiece = new Bishop(Color.BLACK, tempSquare);
        tempSquare.setPiece(tempPiece);

        tempSquare = getSquare(7,6);
        tempPiece = new Knight(Color.BLACK, tempSquare);
        tempSquare.setPiece(tempPiece);

        tempSquare = getSquare(7,7);
        tempPiece = new Rook(Color.BLACK, tempSquare);
        tempSquare.setPiece(tempPiece);
    }

    public void printBoard() {
        String line;

        for(int i = 0; i < 8; i++) {
            line = "";
            for(int j = 0; j < 8; j++) {
                line += getSquare(i,j).toString();
            }
            System.out.println(line);
        }
    }
}