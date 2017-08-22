import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:8445322@gmail.com">Ivan Bonkin</a>.
 */
public class MoveGenerator {

    public List<Move> generateMoves(Board board, Color color) {
        List<Move> moves = new ArrayList<Move>();

        moves.addAll(generateKingMoves(board, color));
        moves.addAll(generateRookMoves(board, color));

        return moves;
    }

    public List<Move> generateKingMoves(Board board, Color color) {
        int kingPos = board.getKingPos(color);

    }

    public List<Move> generateRookMoves(Board board, Color color) {
        // TODO
    }

}
