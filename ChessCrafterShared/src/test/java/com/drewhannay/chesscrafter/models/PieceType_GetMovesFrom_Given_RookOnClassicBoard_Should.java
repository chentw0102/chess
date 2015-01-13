package com.drewhannay.chesscrafter.models;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PieceType_GetMovesFrom_Given_RookOnClassicBoard_Should {

    PieceType mTarget;
    BoardSize mBoardSize;
    List<ChessCoordinate> mMovesFrom1_1;

    @Before
    public void setup() {
        mTarget = PieceType.getRookPieceType();
        mBoardSize = BoardSize.withDimensions(8, 8);
        mMovesFrom1_1 = mTarget.getMovesFrom(ChessCoordinate.at(1, 1), mBoardSize);
    }

    @Test
    public void return7VerticalMovesWithBoardSize8() {
        int count = 0;
        for (ChessCoordinate move : mMovesFrom1_1) {
            if (move.x == 1) {
                count++;
            }
        }
        assertEquals(7, count);
    }

    @Test
    public void return7HorizontalMovesWithBoardSize8() {
        int count = 0;
        for (ChessCoordinate move : mMovesFrom1_1) {
            if (move.y == 1) {
                count++;
            }
        }
        assertEquals(7, count);
    }

    @Test
    public void returnNoMovesThatContainAZero() {
        int count = 0;
        for (ChessCoordinate move : mMovesFrom1_1) {
            if (move.x == 0 || move.y == 0) {
                count++;
            }
        }
        assertEquals(0, count);
    }

    @Test
    public void return7_4From7_1() {
        List<ChessCoordinate> moves = mTarget.getMovesFrom(ChessCoordinate.at(7, 1), mBoardSize);

        assertTrue(moves.contains(ChessCoordinate.at(7, 4)));
    }

    @Test
    public void notReturn2_2From1_1() {
        assertFalse(mMovesFrom1_1.contains(ChessCoordinate.at(2, 2)));
    }
}