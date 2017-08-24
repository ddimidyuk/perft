package ru.pflb.chess;

import static ru.pflb.chess.Color.BLACK;
import static ru.pflb.chess.Color.WHITE;

/**
 * @author <a href="mailto:8445322@gmail.com">Ivan Bonkin</a>.
 */
public class Eval {

    private final int value;

    public Eval(Board board) {
        this.value = evaluate(board);
    }

    private final int evaluate(Board board) {
        int cp = 0;

        cp += (board.getRooksNb(WHITE) - board.getRooksNb(BLACK)) * 500;
        // TODO - добавить другие фигуры

        return cp;
    }

    public int getValue() {
        return value;
    }
}
