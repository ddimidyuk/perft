package board;

import static board.Color.BLACK;
import static board.Color.WHITE;
import static board.PieceType.KING;
import static board.PieceType.ROOK;

/**
 * @author <a href="mailto:8445322@gmail.com">Ivan Bonkin</a>.
 */
public class Piece {

    /**
     * Поле пустое и доступно для перемещения.
     */
    public static final Piece EMP = new Piece(null, null);

    /**
     * Поле недоступно для перемещения.
     */
    // TODO
    public static final Piece OUT = new Piece(null, null);

    private final int code;

    public Piece(PieceType pieceType, Color color) {
        this.code = color.getCode() * 6 + pieceType.getCode() + 1;
    }

    /**
     * -1 - за пределами доски
     * 0 - пустое поле внутри доски
     *
     * 1 - белый король
     * 2 - белая ладья
     *
     * 7 - черный король
     * 8 - черная ладья
     */
    public int getCode() {
        return code;
    }

    public PieceType getPieceType() {
        switch (code) {
            case -1:
                return null;
            case 0:
                return null;
            case 1:
            case 7:
                return KING;
            case 2:
            case 8:
                return ROOK;
            default:
                return null;
        }
    }

    public Color getColor() {
        if (code >= 1 && code <= 6) {
            return WHITE;
        } else if (code >= 7 && code <= 12) {
            return BLACK;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isEnemy() {
        return enemy;
    }

    public boolean isFriend() {
        return friend;
    }
}
