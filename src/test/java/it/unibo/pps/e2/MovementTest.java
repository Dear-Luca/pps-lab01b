package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovementTest {
    public static final int SIZE = 5;
    private Movement movement;

    @BeforeEach
    void beforeEach(){
        this.movement = new MovementImpl(SIZE);
    }

    @Test
    void testKnightCanMove(){
        Pair<Integer, Integer> initPosition = new Pair<>(0, 0);
        Pair<Integer, Integer> finalPosition = new Pair<>(2, 1);

        Optional<Pair<Integer, Integer>> newPosition = this.movement.move(
                initPosition.getX(),
                initPosition.getY(),
                finalPosition.getX(),
                finalPosition.getY()
        );
        if (newPosition.isPresent()){
            initPosition = newPosition.get();
        }
        assertTrue(initPosition.getX() == 2 && initPosition.getY() == 1);
    }

}


