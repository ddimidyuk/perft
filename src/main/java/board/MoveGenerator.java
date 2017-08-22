package board;

import java.util.ArrayList;
import java.util.List;

import static board.PieceType.KING;
import static board.PieceType.ROOK;

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

    public List<Move> generateKingMoves(Board board, Color sideToMove) {
        int kingPos = board.getKingPos(sideToMove);
        int[] offsets = board.getOffsets(KING);
        ArrayList<Move> moves = new ArrayList<Move>();
        for (int i = 0; i < offsets.length; i++) {
            int newPos = kingPos + offsets[i];

            Piece piece = board.getPiece(newPos);
            if (piece.isEmpty() && piece.isEnemy(sideToMove)) {
                moves.add(new Move(kingPos, newPos, KING));
            } else {
                // не можем ходить:
                // либо своя фигура
                // либо ход за пределы доски
            }
        }

        return moves;
    }

    public List<Move> generateRookMoves(Board board, Color sideToMove) {
        List<Move> moves = new ArrayList<Move>();
        for (int r = 0; r < board.getRooksNb(sideToMove); r++) {
            int rookPos = board.getRookPos(sideToMove, r);
            int[] offsets = board.getOffsets(ROOK);

            for (int i = 0; i < offsets.length; i++) {
                for (int newPos = rookPos + offsets[i]; ; newPos += offsets[i]) {
                    Piece piece = board.getPiece(newPos);
                    if (piece.isEmpty() && piece.isEnemy(sideToMove)) {
                        moves.add(new Move(rookPos, newPos, KING));
                    } else {
                        // не можем ходить:
                        // либо своя фигура
                        // либо ход за пределы доски
                        break;
                    }
                }
            }
        }


        return moves;
    }

}
