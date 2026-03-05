package it.unibo.pps.e2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

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
        assertTrue(this.logics.hasKnight(knight.getX(), knight.getY()));
    }

    @Test
    public void testHasPawn() {
        assertTrue(this.logics.hasPawn(pawn.getX(), pawn.getY()));
    }

    @Test
    public void testBoardRandomSetUp() {
        this.logics = new LogicsImpl(SIZE);
        boolean hasKnight = false;
        boolean hasPawn = false;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (this.logics.hasKnight(i, j)) {
                    hasKnight = true;
                }
                if (this.logics.hasPawn(i, j)) {
                    hasPawn = true;
                }
            }
        }
        assertTrue(hasKnight && hasPawn);
    }

    @Test
    public void testInvalidMoveKnight(){
        final Pair<Integer, Integer> nextPosition = new Pair<>(1, 1);
        assertFalse(this.logics.hit(nextPosition.getX(), nextPosition.getY()));
    }

    @Test
    public void testMoveOutOfBound(){
        final Pair<Integer, Integer> nextPosition = new Pair<>(5, 5);
        assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(nextPosition.getX(), nextPosition.getY()));

    }

    @Test
    public void testValidMoveKnight(){
        final Pair<Integer, Integer> nextPosition = new Pair<>(2, 1);
        this.logics.hit(nextPosition.getX(), nextPosition.getY());
        assertTrue(this.logics.hasKnight(nextPosition.getX(), nextPosition.getY()));
    }

    @Test
    public void testKnightHitPawn(){
        final Pair<Integer, Integer> pawn = new Pair<>(2, 1);
        this.logics = new LogicsImpl(SIZE, knight, pawn);
        assertTrue(this.logics.hit(pawn.getX(), pawn.getY()));
    }
}
