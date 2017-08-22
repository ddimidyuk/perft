package ru.pflb.chess;

/**
 * @author <a href="mailto:8445322@gmail.com">Ivan Bonkin</a>.
 */
public enum Square {
    A8(91), B8(92),
    A7(81), B7(81),
    A6(71), B6(72);

    final int mailbox120;

    Square(int mailbox120) {
        this.mailbox120 = mailbox120;
    }
}
