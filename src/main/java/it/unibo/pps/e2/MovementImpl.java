package it.unibo.pps.e2;

import java.util.Optional;

public class MovementImpl implements Movement{

    @Override
    public Optional<Pair<Integer, Integer>> move(int currentRow, int currentCol, int newRow, int newCol, int size) {
        if (newRow < 0 || newCol < 0 || newRow >= size || newCol >= size) {
            throw new IndexOutOfBoundsException();
        }
        int x = newRow - currentRow;
        int y = newCol - currentCol;
        if (Math.abs(x) * Math.abs(y) == 2){
            return Optional.of(new Pair<>(newRow, newCol));
        }
        return Optional.empty();
    }

    @Override
    public boolean hit() {
        return false;
    }
}
