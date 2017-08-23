package ru.pflb.chess;

/**
 * @author <a href="mailto:8445322@gmail.com">Ivan Bonkin</a>.
 */
public enum Color {

    WHITE(0), BLACK(1);

    private final int code;

    Color(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    /**
     * @return противоположный цвет
     */
    public int getOppositeCode() {
        return code ^ 1;
    }

    public Color getOpposite() {
        return this == WHITE ? BLACK : WHITE;
    }
}
