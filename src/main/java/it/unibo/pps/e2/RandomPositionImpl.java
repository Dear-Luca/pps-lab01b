package it.unibo.pps.e2;

import java.util.Random;

public class RandomPositionImpl implements RandomPosition {
    private final Random random = new Random();
    private int size;

    public RandomPositionImpl(int size) {
        this.size = size;
    }

    @Override
    public Pair<Integer, Integer> randomEmptyPosition() {
        return new Pair<>(this.random.nextInt(size), this.random.nextInt(size));
    }

    @Override
    public Pair<Integer, Integer> randomEmptyPosition(Pair<Integer, Integer> position) {
        Pair<Integer, Integer> pos = new Pair<>(this.random.nextInt(size), this.random.nextInt(size));
        return position != null && position.equals(pos) ? randomEmptyPosition(position) : pos;
    }
}
