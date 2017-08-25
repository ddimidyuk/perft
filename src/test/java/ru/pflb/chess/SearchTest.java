package ru.pflb.chess;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="mailto:8445322@gmail.com">Ivan Bonkin</a>.
 */
public class SearchTest {

    @Test
    public void perftTest() {
        //Board board = new Board("3kr3/K7/8/8/8/8/8/8 w - -");
        Board board = new Board("K1k7/8/8/8/8/8/8/8 w - -");
        int movesNb = Search.perft(board, 1);

        assertThat(movesNb).isEqualTo(65);
    }

}