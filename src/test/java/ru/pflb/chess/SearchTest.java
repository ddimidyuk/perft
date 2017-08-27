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
        //Board board = new Board("2k5/8/8/8/8/8/8/3K4 w - -");
        Board board = new Board("r1bqkb1r/8/8/8/8/8/8/R1BQKB1R w - -");
        int movesNb = Search.perft(board, 3);
        System.out.println(System.currentTimeMillis()-start);

        assertThat(movesNb).isEqualTo(73468);
    }

}