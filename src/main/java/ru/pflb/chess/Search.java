package ru.pflb.chess;

import java.util.List;

/**
 * @author <a href="mailto:8445322@gmail.com">Ivan Bonkin</a>.
 */
public class Search {

    public static int perft(Board board, int depth) {
        List<Move> moves = new MoveGenerator(board).generateMoves();
        if (depth == 1) {
            return moves.size();
            // TODO - исключить недопустимые ходы
        }
        int positions = 0;
        for (Move move : moves) {
            board.doMove(move);
            positions += perft(board, depth - 1);
            board.undoMove(move);
        }
        return positions;
    }
}
