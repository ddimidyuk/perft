/**
 * @author <a href="mailto:8445322@gmail.com">Ivan Bonkin</a>.
 */
public enum Piece {

    KING(0), ROOK(1);

    private final int code;

    Piece(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
