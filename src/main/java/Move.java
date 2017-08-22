/**
 * @author <a href="mailto:8445322@gmail.com">Ivan Bonkin</a>.
 */
public class Move {

    private final int from, to;

    private final Piece piece;

    public Move(int from, int to, Piece piece) {
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

    public Piece getPiece() {
        return piece;
    }
}
