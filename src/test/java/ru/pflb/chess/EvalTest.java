package ru.pflb.chess;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="mailto:8445322@gmail.com">Ivan Bonkin</a>.
 */
public class EvalTest {

    @Test
    public void generateKingMoves() {

        Board board = new Board("K1k5/R7/8/8/8/8/8/8 w - -");

        int cp = new Eval(board).getValue();

        assertThat(cp).isEqualTo(500);
    }

}