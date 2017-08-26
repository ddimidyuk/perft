package ru.pflb.chess;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="mailto:8445322@gmail.com">Ivan Bonkin</a>.
 */
public class SearchTest {

    @Test
    public void perftTest() {
        long start = System.currentTimeMillis();
        //Board board = new Board("3kr3/K7/8/8/8/8/8/8 w - -");
        //Board board = new Board("2k5/8/8/8/8/8/8/7K w - -");
        Board board = new Board("8/8/6k1/8/4b3/8/6K1/8 w - -");
        int movesNb = Search.perft(board, 4);
        System.out.println(System.currentTimeMillis()-start);

        assertThat(movesNb).isEqualTo(36);
    }

}