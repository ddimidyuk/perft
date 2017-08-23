package ru.pflb.chess;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return Objects.equals(from, move.from) &&
                Objects.equals(to, move.to) &&
                piece == move.piece;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, piece);
    }

    @Override
    public String toString() {
        return "Move{" +
                "from=" + from +
                ", to=" + to +
                ", piece=" + piece +
                '}';
    }
}
