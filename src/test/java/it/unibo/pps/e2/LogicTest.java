package it.unibo.pps.e2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogicTest {
    private Logics logics;
    private static final int SIZE = 5;
    private static final Pair<Integer, Integer> knight = new Pair<>(0, 0);
    private static final Pair<Integer, Integer> pawn = new Pair<>(4, 4);

    @BeforeEach
    public void beforeEach() {
        this.logics = new LogicsImpl(SIZE, knight, pawn);
    }

    @Test
    public void testHasKnight() {
        assertTrue(logics.hasKnight(knight.getX(), knight.getY()));
    }

    @Test
    public void testHasPawn() {
        assertTrue(logics.hasPawn(pawn.getX(), pawn.getY()));
    }

    @Test
    public void testBoardSetUp() {
        boolean hasKnight = false;
        boolean hasPawn = false;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (logics.hasKnight(i, j)) {
                    hasKnight = true;
                }
                if (logics.hasPawn(i, j)) {
                    hasPawn = true;
                }
            }
        }
        assertTrue(hasKnight && hasPawn);
    }


}
