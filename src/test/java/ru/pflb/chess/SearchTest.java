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
        Board board = new Board("4kb2/8/8/8/8/8/8/4K2R w - -");
        //Board board = new Board("k7/6Q1/8/8/8/4q3/8/2K5 w - -");
        int movesNb = Search.perft(board, 5);
        System.out.println(System.currentTimeMillis()-start);

        assertThat(movesNb).isEqualTo(73468);
    }

}