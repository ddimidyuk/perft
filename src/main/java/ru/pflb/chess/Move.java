package ru.pflb.chess;

/**
 * @author <a href="mailto:8445322@gmail.com">Ivan Bonkin</a>.
 */
public class Move {

    private final Square from, to;

    private final PieceType piece;

    public Move(Square from, Square to, PieceType piece) {
        this.from = from;
        this.to = to;
        this.piece = piece;
    }

    public PieceType getPiece() {
        return piece;
    }
}
