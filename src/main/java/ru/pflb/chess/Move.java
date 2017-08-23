package ru.pflb.chess;

import java.util.Objects;
import java.util.Optional;

/**
 * @author <a href="mailto:8445322@gmail.com">Ivan Bonkin</a>.
 */
public class Move {

    private final Square from, to;

    private final Piece piece;

    private final Optional<Piece> capture;

    public Move(Square from, Square to, Piece piece, Piece capture) {
        this.from = from;
        this.to = to;
        this.piece = piece;
        this.capture = Optional.of(capture);
    }

    public Move(Square from, Square to, Piece piece) {
        this.from = from;
        this.to = to;
        this.piece = piece;
        this.capture = Optional.empty();
    }

    public Piece getPiece() {
        return piece;
    }

    public Square getFrom() {
        return from;
    }

    public Square getTo() {
        return to;
    }

    public Optional<Piece> getCapture() {
        return capture;
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

    /**
     * @return <a href="полная запись ходов">https://ru.wikipedia.org/wiki/%D0%A8%D0%B0%D1%85%D0%BC%D0%B0%D1%82%D0%BD%D0%B0%D1%8F_%D0%BD%D0%BE%D1%82%D0%B0%D1%86%D0%B8%D1%8F</a>
     */
    @Override
    public String toString() {
        return piece.getPieceType().name().substring(0, 1) + from + "-" + to;
    }
}
