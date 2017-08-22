package ru.pflb.chess;

/**
 * @author <a href="mailto:8445322@gmail.com">Ivan Bonkin</a>.
 */
public enum MoveType {

    QUIET(0), CAPTURE(1), BLOCKED(-1);

    private final int code;

    MoveType(int code) {
        this.code = code;
    }
}
