package it.unibo.pps.e2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogicTest {
    private Logics logics;
    private static final int SIZE = 5;

    @BeforeEach
    public void beforEach(){
        this.logics = new LogicsImpl(SIZE);
    }

    @Test
    public void test() {
        assert (true);
        // TODO: Add your test logic here
        // You can generate random inputs and assert the expected output
        // For example:
        // int result = Logic.someMethod(5, 10);
        // assertEquals(expectedResult, result);
    }

    @Test
    public void testInitialBoardIsCorrect() {
        boolean hasKnight = false;
        boolean hasPawn = false;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++){
                if (logics.hasKnight(i, j)){
                    hasKnight = true;
                }
                if (logics.hasPawn(i, j)){
                    hasPawn = true;
                }
            }
        }
        assertTrue(hasKnight && hasPawn);
    }

}
