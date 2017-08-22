/**
 * @author <a href="mailto:8445322@gmail.com">Ivan Bonkin</a>.
 */
public class Move {

    private final int from, to;

    private final PieceType piece;

    public Move(int from, int to, PieceType piece) {
        this.from = from;
        this.to = to;
        this.piece = piece;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public PieceType getPiece() {
        return piece;
    }
}
