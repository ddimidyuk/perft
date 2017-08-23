package ru.pflb.chess;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.pflb.chess.Piece.W_KING;
import static ru.pflb.chess.Square.*;


/**
 * @author <a href="mailto:8445322@gmail.com">Ivan Bonkin</a>.
 */
public class MoveGeneratorTest {

    @Test
    public void generateKingMoves() {

        Board board = new Board("3k4/K7/8/8/8/8/8/8 w - -");

        List<Move> moves = new MoveGenerator(board).generateKingMoves();

        assertThat(moves).contains(
                new Move(A7, A6, W_KING),
                new Move(A7, B6, W_KING),
                new Move(A7, B7, W_KING),
                new Move(A7, A8, W_KING),
                new Move(A7, B8, W_KING));
    }

}