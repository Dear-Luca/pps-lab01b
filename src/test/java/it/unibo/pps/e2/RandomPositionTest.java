package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomPositionTest {

    public static final int SIZE = 5;
    private RandomPosition randomPosition;

    @BeforeEach
    void beforeEach(){
        this.randomPosition = new RandomPositionImpl(SIZE);
    }

    private boolean isInBound(int coordinate){
        return coordinate >= 0 && coordinate < SIZE;
    }

    @Test
    void testRandomGeneration(){
        Pair<Integer, Integer> position = randomPosition.randomEmptyPosition();
        assertTrue(isInBound(position.getX()) && isInBound(position.getY()));
    }

    @Test
    void testMultipleRandomGeneration(){
        Pair<Integer, Integer> position = randomPosition.randomEmptyPosition();
        Pair<Integer, Integer> newPosition = randomPosition.randomEmptyPosition(position);
        assertNotEquals(position, newPosition);
    }
}
