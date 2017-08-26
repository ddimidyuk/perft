package ru.pflb.chess;

import java.util.ArrayList;
import java.util.List;

import static ru.pflb.chess.Color.WHITE;
import static ru.pflb.chess.Piece.*;
import static ru.pflb.chess.PieceType.*;

/**
 * @author <a href="mailto:8445322@gmail.com">Ivan Bonkin</a>.
 */
public class MoveGenerator {

    private int[][] validationWards = {
            // rank&file
            {-1, 1, 10, -10},
            // diags
            {-11, -9, 9, 11}
    };

    private final Board board;

    //проверка на шах
    private boolean leftInCheck(int pos, Color color) {
        boolean isCheck = false;
        boolean isFirst = false;
        int kingPos = pos;
        int[] offsetsLine = board.getOffsets(ROOK);
        int[] offsetsDiag = board.getOffsets(BISHOP);
        loop:
        for (int j = 1; j < 2; j++) {
            for (int i = 0; i < offsetsLine.length; i++) {
                if (offsetsLine[i] == 0) continue;
                isFirst = true;
                for (int newPos = kingPos + offsetsLine[i]; offsetsLine[i] != 0; newPos += offsetsLine[i]) {
                    Piece piece = board.getPiece(newPos);

                    if (isFirst) {
                        //проверка на короля
                            if (KING.equals(piece.getPieceType()) && (!piece.getColor().equals(color))) {
                                isCheck = true;
                                break loop;
                            }
                        }

                    isFirst = false;
                    if (piece.isEmpty()) {
                        continue;
                    } else if (piece.isEnemy(color) && (piece.getPieceType().equals(ROOK) || piece.getPieceType().equals(QUEEN))) {
                        isCheck = true;
                        break loop;
                    } else {
                        // не можем ходить:
                        // либо своя фигура
                        // либо ход за пределы доски
                        break;
                    }
                }
            }
            for (int i = 0; i < offsetsDiag.length; i++) {
                if (offsetsDiag[i] == 0) continue;
                isFirst = true;

                for (int newPos = kingPos + offsetsDiag[i]; offsetsDiag[i] != 0; newPos += offsetsDiag[i]) {
                    Piece piece = board.getPiece(newPos);
                    if (isFirst) {
                        //проверка на короля
                        if (KING.equals(piece.getPieceType()) && (!piece.getColor().equals(color))) {
                            isCheck = true;
                            break loop;
                        }
                    }
                    isFirst = false;
                    if (piece.isEmpty()) {
                        continue;
                    } else if (piece.isEnemy(color) && (piece.getPieceType().equals(BISHOP) || piece.getPieceType().equals(QUEEN))) {
                        isCheck = true;
                        break loop;
                    } else {
                        // не можем ходить:
                        // либо своя фигура
                        // либо ход за пределы доски
                        break;
                    }
                }
            }
        }
        return isCheck;
    }

    //находиться ли король по горизонтали

    private boolean isRank(Piece king, int square) {
        boolean isRank = false;
        loop:
        for (int i = 1; i >= -1; i -= 2) {
            for (int newPos = square + i; ; newPos += i) {
                Piece piece = board.getPiece(newPos);
                if (piece.getCode() == king.getCode()) {
                    isRank = true;
                    break loop;
                } else {
                    // не можем ходить:
                    // либо чужая фигура
                    // либо своя фигура
                    // либо ход за пределы доски
                    break;
                }
            }
        }
        return isRank;
    }

    //находиться ли король по вертикали
    private boolean isFile(Piece king, int square) {
        boolean isFile = false;
        loop:
        for (int i = 10; i >= -10; i -= 20) {
            for (int newPos = square + i; ; newPos += i) {
                Piece piece = board.getPiece(newPos);
                if (piece.getCode() == king.getCode()) {
                    isFile = true;
                    break loop;
                } else {
                    // не можем ходить:
                    // либо чужая фигура
                    // либо своя фигура
                    // либо ход за пределы доски
                    break;
                }
            }
        }
        return isFile;
    }

    //находиться ли король по диагонали1
    private boolean isDiag1(Piece king, int square) {
        boolean isDiag1 = false;
        loop:
        for (int i = 11; i >= -11; i -= 22) {
            for (int newPos = square + i; ; newPos += i) {
                Piece piece = board.getPiece(newPos);
                if (piece.getCode() == king.getCode()) {
                    isDiag1 = true;
                    break loop;
                } else {
                    // не можем ходить:
                    // либо чужая фигура
                    // либо своя фигура
                    // либо ход за пределы доски
                    break;
                }
            }
        }
        return isDiag1;
    }

    //находиться ли король по диагонали2
    private boolean isDiag2(Piece king, int square) {
        boolean isDiag2 = false;
        loop:
        for (int i = 9; i >= -9; i -= 18) {
            for (int newPos = square + i; ; newPos += i) {
                Piece piece = board.getPiece(newPos);
                if (piece.getCode() == king.getCode()) {
                    isDiag2 = true;
                    break loop;
                } else {
                    // не можем ходить:
                    // либо чужая фигура
                    // либо своя фигура
                    // либо ход за пределы доски
                    break;
                }
            }
        }
        return isDiag2;
    }

    public MoveGenerator(Board board) {
        this.board = board;
    }

    public List<Move> generateMoves() {
        List<Move> moves = new ArrayList<Move>();

        moves.addAll(generateKingMoves());
        moves.addAll(generateRookMoves());
        moves.addAll(generateQueenMoves());
        moves.addAll(generateBishopMoves());

        return moves;
    }

    public List<Move> generateKingMoves() {
        int kingPos = board.getKingPos(board.getSideToMove());
        int[] offsets = board.getOffsets(KING);
        List<Move> moves = new ArrayList<Move>();
        for (int i = 0; i < offsets.length; i++) {
            int newPos = kingPos + offsets[i];
            Piece piece = board.getPiece(newPos);
            if (piece.getCode() != -1) {
                if (leftInCheck(newPos, board.getSideToMove()))
                    continue;
            }
            if (piece.isEmpty()) {
                moves.add(new Move(new Square(kingPos), new Square(newPos), board.getSideToMove() == WHITE ? W_KING : B_KING));
            } else if (piece.isEnemy(board.getSideToMove())) {
                moves.add(new Move(new Square(kingPos), new Square(newPos), board.getSideToMove() == WHITE ? W_KING : B_KING, piece));
            } else {
                // не можем ходить:
                // либо своя фигура
                // либо ход за пределы доски
            }
        }

        return moves;
    }

    public List<Move> generateQueenMoves() {
        int queenPos = board.getQueenPos(board.getSideToMove());
        int[] offsets = board.getOffsets(QUEEN);
        List<Move> moves = new ArrayList<Move>();
        for (int i = 0; i < offsets.length; i++) {
            for (int newPos = queenPos + offsets[i]; ; newPos += offsets[i]) {
                if (queenPos == 0) break;
//                if (leftInCheck(board.getSideToMove() == WHITE ? W_KING : B_KING))
//                    break;
                Piece piece = board.getPiece(newPos);
                if (piece.isEmpty()) {
                    moves.add(new Move(new Square(queenPos), new Square(newPos), board.getSideToMove() == WHITE ? W_QUEEN : B_QUEEN));
                } else if (piece.isEnemy(board.getSideToMove())) {
                    moves.add(new Move(new Square(queenPos), new Square(newPos), board.getSideToMove() == WHITE ? W_QUEEN : B_QUEEN, piece));
                } else {
                    // не можем ходить:
                    // либо своя фигура
                    // либо ход за пределы доски
                    break;
                }
            }
        }

        return moves;
    }

    public List<Move> generateRookMoves() {
        List<Move> moves = new ArrayList<Move>();
        for (int r = 0; r < board.getRooksNb(board.getSideToMove()); r++) {
            int rookPos = board.getRookPos(board.getSideToMove(), r);
            //флаги наличия короля по горизонтали и вертикали
            boolean kingIsRank = false;
            boolean kingIsFile = false;
            int[] offsets = board.getOffsets(ROOK);

            for (int i = 0; i < offsets.length; i++) {
                //проверка на наличие короля по горизонтали или вертикали
                if (offsets[i] == 10 || offsets[i] == -10)
                    kingIsRank = isRank(board.getSideToMove() == WHITE ? W_KING : B_KING, rookPos);
                else if (offsets[i] == 1 || offsets[i] == -1)
                    kingIsFile = isFile(board.getSideToMove() == WHITE ? W_KING : B_KING, rookPos);

                for (int newPos = rookPos + offsets[i]; ; newPos += offsets[i]) {

                    // проверка на валидность хода
//                    if (kingIsRank && offsets[i] == 10 || offsets[i] == -10) {
//                        if (leftInCheck(board.getSideToMove() == WHITE ? W_KING : B_KING))
//                            break;
//                    }
//                    if (kingIsFile && offsets[i] == 1 || offsets[i] == -1) {
//                        if (leftInCheck(board.getSideToMove() == WHITE ? W_KING : B_KING))
//                            break;
//                    }

                    Piece piece = board.getPiece(newPos);
                    if (piece.isEmpty()) {
                        moves.add(new Move(new Square(rookPos), new Square(newPos), board.getSideToMove() == WHITE ? W_ROOK : B_ROOK));
                    } else if (piece.isEnemy(board.getSideToMove())) {
                        moves.add(new Move(new Square(rookPos), new Square(newPos), board.getSideToMove() == WHITE ? W_ROOK : B_ROOK, piece));
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

    public List<Move> generateBishopMoves() {
        List<Move> moves = new ArrayList<Move>();
        for (int r = 0; r < board.getBishopsNb(board.getSideToMove()); r++) {
            int bishopPos = board.getBishopPos(board.getSideToMove(), r);
            int[] offsets = board.getOffsets(BISHOP);
            //флаги наличия короля по диагоналям
            boolean kingIsDiag1 = false;
            boolean kingIsDiag2 = false;

            for (int i = 0; i < offsets.length; i++) {

                //проверка на наличие короля по горизонтали или вертикали
                if (offsets[i] == 9 || offsets[i] == -9)
                    kingIsDiag1 = isRank(board.getSideToMove() == WHITE ? W_KING : B_KING, bishopPos);
                else if (offsets[i] == 11 || offsets[i] == -11)
                    kingIsDiag2 = isFile(board.getSideToMove() == WHITE ? W_KING : B_KING, bishopPos);

                for (int newPos = bishopPos + offsets[i]; ; newPos += offsets[i]) {

                    // проверка на валидность хода
//                    if (kingIsDiag1 && offsets[i] == 9 || offsets[i] == -9) {
//                        if (leftInCheck(board.getSideToMove() == WHITE ? W_KING : B_KING))
//                            break;
//                    }
//                    if (kingIsDiag2 && offsets[i] == 11 || offsets[i] == -11) {
//                        if (leftInCheck(board.getSideToMove() == WHITE ? W_KING : B_KING))
//                            break;
//                    }

                    Piece piece = board.getPiece(newPos);
                    if (piece.isEmpty()) {
                        moves.add(new Move(new Square(bishopPos), new Square(newPos), board.getSideToMove() == WHITE ? W_BISHOP : B_BISHOP));
                    } else if (piece.isEnemy(board.getSideToMove())) {
                        moves.add(new Move(new Square(bishopPos), new Square(newPos), board.getSideToMove() == WHITE ? W_BISHOP : B_BISHOP, piece));
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
