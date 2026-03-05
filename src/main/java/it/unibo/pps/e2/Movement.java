package it.unibo.pps.e2;

import java.util.Optional;

public interface Movement {
    Optional<Pair<Integer, Integer>> move(int currentRow, int currentCol, int newRow, int newCol, int size);

    boolean hit();
}
