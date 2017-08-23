package ru.pflb.chess;

import java.util.Objects;

/**
 * @author <a href="mailto:8445322@gmail.com">Ivan Bonkin</a>.
 */
public class Square {

    public static final Square A8 = new Square(98);
    public static final Square B8 = new Square(97);
    public static final Square C8 = new Square(96);
    public static final Square D8 = new Square(95);
    public static final Square E8 = new Square(94);
    public static final Square F8 = new Square(93);
    public static final Square G8 = new Square(92);
    public static final Square H8 = new Square(91);
    public static final Square A7 = new Square(88);
    public static final Square B7 = new Square(87);
    public static final Square A6 = new Square(78);
    public static final Square B6 = new Square(77);

    private final int square;

    public Square(int mailbox120) {
        this.square = mailbox120;
    }

    public Square addOffset(int offset) {
        return new Square(square + offset);
    }

    public int getCode() {
        return square;
    }

    @Override
    public String toString() {
        return "Square(" + square + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square1 = (Square) o;
        return square == square1.square;
    }

    @Override
    public int hashCode() {
        return Objects.hash(square);
    }
}
