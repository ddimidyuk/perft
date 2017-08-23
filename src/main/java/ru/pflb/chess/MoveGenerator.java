package ru.pflb.chess;

import java.util.ArrayList;
import java.util.List;

import static ru.pflb.chess.PieceType.KING;
import static ru.pflb.chess.PieceType.ROOK;

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
        List<Move> moves = new ArrayList<Move>();
        for (int i = 0; i < offsets.length; i++) {
            int newPos = kingPos + offsets[i];

            Piece piece = board.getPiece(newPos);
            if (piece.isEmpty() && piece.isEnemy(sideToMove)) {
                moves.add(new Move(new Square(kingPos), new Square(newPos), KING));
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
                        moves.add(new Move(new Square(rookPos), new Square(newPos), ROOK));
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
