package ru.pflb.chess;

/**
 * @author <a href="mailto:8445322@gmail.com">Ivan Bonkin</a>.
 */
public class Square {

    public static final Square A8 = new Square(91);
    public static final Square A7 = new Square(81);
    public static final Square A6 = new Square(71);
    public static final Square B8 = new Square(92);
    public static final Square B7 = new Square(82);
    public static final Square B6 = new Square(72);

    private final int square;

    public Square(int mailbox120) {
        this.square = mailbox120;
    }

    public Square addOffset(int offset) {
        return new Square(square + offset);
    }
}
