package board;

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
        int[] offsets = board.getOffsets(PieceType.KING);
        for (int i = 0; i < offsets.length; i++) {
            int newPos = kingPos + offsets[i];

            Piece piece = board.getPiece(newPos);
            if (piece.)
        }

    }

    public List<Move> generateRookMoves(Board board, Color color) {
        // TODO
    }

}
