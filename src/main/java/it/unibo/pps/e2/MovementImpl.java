package it.unibo.pps.e2;

import java.util.Optional;

public class MovementImpl implements Movement{
    public static final int CORRECT_KNIGHT_MOVEMENT = 2;
    private final int size;

    public MovementImpl(int size) {
        this.size = size;
    }

    public Optional<Pair<Integer, Integer>> move(int currentRow, int currentCol, int newRow, int newCol) {
        if (newRow < 0 || newCol < 0 || newRow >= this.size || newCol >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        int x = newRow - currentRow;
        int y = newCol - currentCol;
        if (Math.abs(x) * Math.abs(y) == CORRECT_KNIGHT_MOVEMENT){
            return Optional.of(new Pair<>(newRow, newCol));
        }
        return Optional.empty();
    }
}
