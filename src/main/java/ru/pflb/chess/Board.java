package ru.pflb.chess;

import static ru.pflb.chess.Color.BLACK;
import static ru.pflb.chess.Color.WHITE;
import static ru.pflb.chess.Piece.EMP;
import static ru.pflb.chess.Piece.OUT;
import static ru.pflb.chess.PieceType.KING;
import static ru.pflb.chess.PieceType.ROOK;

/**
 * @author <a href="mailto:8445322@gmail.com">Ivan Bonkin</a>.
 */
public class Board {

    private int[] kingPos120 = {0, 0};
    private int[][] rookPos120 = {
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0}
    };

    private Color sideToMove;

    private int rooksNb[] = {0, 0};

    private int[][] offset = {
        // KING
        { -11, -10, -9, -1, 1,  9, 10, 11 },
        // ROOK
        { -10,  -1,  1, 10, 0,  0,  0,  0 }
    };

    private Piece[] mailbox120 = {
        OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, // 0-9
        OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, OUT, // 10-19
        OUT, EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP, OUT, // 20-29
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
        for (int square = 98, fenIndex = 0; fenIndex < fen.length(); fenIndex++, square--) {
            char c = fen.charAt(fenIndex);
            switch (c) {
                case 'K':
                    mailbox120[square] = new Piece(KING, WHITE);
                    kingPos120[WHITE.getCode()] = square;
                    break;
                case 'R':
                    mailbox120[square] = new Piece(ROOK, WHITE);
                    break;
                case 'k':
                    mailbox120[square] = new Piece(KING, BLACK);
                    kingPos120[BLACK.getCode()] = square;
                    break;
                case 'r':
                    mailbox120[square] = new Piece(ROOK, BLACK);
                    break;
                case '/':
                    square -= 1;
                    break;
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                    square -= c - '1';
                    break;
                case ' ':
                    return;
            }

        }
    }

    public Color getSideToMove() {
        return sideToMove;
    }

    public int getKingPos(Color color) {
        return kingPos120[color.getCode()];
    }

    public int getRookPos(Color color, int index) {
        return rookPos120[color.getCode()][index];
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
