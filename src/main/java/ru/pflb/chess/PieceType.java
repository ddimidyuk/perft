package ru.pflb.chess;

/**
 * @author <a href="mailto:8445322@gmail.com">Ivan Bonkin</a>.
 */
public enum PieceType {

    KING(0), ROOK(1), QUEEN(2), BISHOP(3);

    private final int code;

    PieceType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
