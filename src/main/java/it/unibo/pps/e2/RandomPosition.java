package it.unibo.pps.e2;

public interface RandomPosition {
    Pair<Integer, Integer> randomEmptyPosition();

    Pair<Integer, Integer> randomEmptyPosition(Pair<Integer, Integer> excluded);
}
