package ru.pflb.chess;

import static ru.pflb.chess.Color.*;
import static ru.pflb.chess.Piece.*;
import static ru.pflb.chess.PieceType.*;

/**
 * @author <a href="mailto:8445322@gmail.com">Ivan Bonkin</a>.
 */
public class Board {

    private int[] kingPos64 = {0, 0};
    private int[][] rookPos64 = {
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0}
    };

    private int rooksNb[] = {0, 0};

    private int[][] offset = {
        // KING
        { -11, -10, -9, -1, 1,  9, 10, 11 },
        // ROOK
        { -10,  -1,  1, 10, 0,  0,  0,  0 }
    };

    private Piece[] mailbox120 = {
        OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT,
        OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT,
        OUT, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, OUT,
        OUT, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, OUT,
        OUT, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, OUT,
        OUT, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, OUT,
        OUT, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, OUT,
        OUT, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, OUT,
        OUT, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, OUT,
        OUT, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, OUT,
        OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT,
        OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT
    };

    int[] mailbox64 = {
        21, 22, 23, 24, 25, 26, 27, 28,
        31, 32, 33, 34, 35, 36, 37, 38,
        41, 42, 43, 44, 45, 46, 47, 48,
        51, 52, 53, 54, 55, 56, 57, 58,
        61, 62, 63, 64, 65, 66, 67, 68,
        71, 72, 73, 74, 75, 76, 77, 78,
        81, 82, 83, 84, 85, 86, 87, 88,
        91, 92, 93, 94, 95, 96, 97, 98
    };

    public Board(String fen) {
        for (int square = 0, fenIndex = 0; fenIndex < fen.length(); fenIndex++) {
            Piece piece;
            switch (fen.charAt(fenIndex)) {
                case 'K':
                    piece = new Piece(KING, WHITE);
                    break;
                case 'R':
                    piece = new Piece(ROOK, WHITE);
                    break;
                case 'k':
                    piece = new Piece(KING, BLACK);
                    break;
                case 'r':
                    piece = new Piece(ROOK, BLACK);
                    break;
            }

        }
    }

    public int getKingPos(Color color) {
        return mailbox64[kingPos64[color.getCode()]];
    }

     public int getRookPos(Color color, int index) {
        return rookPos64[color.getCode()][index];
     }

     public int[] getOffsets(PieceType piece) {
         return offset[piece.getCode()];
     }

    public Piece getPiece(int newPos) {
        return mailbox120[newPos];
    }

    public int getRooksNb(Color color) {
        return rooksNb[color.getCode()];
    }
}
