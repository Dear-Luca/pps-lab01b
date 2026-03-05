package it.unibo.pps.e2;

import java.util.*;

public class LogicsImpl implements Logics {
    private final GameState state;

    public LogicsImpl(int size) {
        RandomPosition randomPosition = new RandomPositionImpl(size);
        Movement movement = new MovementImpl(size);
        Pair<Integer, Integer> pawn = randomPosition.randomEmptyPosition();
        Pair<Integer, Integer> knight = randomPosition.randomEmptyPosition(pawn);
        this.state = new GameStateImpl(knight, pawn, movement);
    }

    public LogicsImpl(int size, Pair<Integer, Integer> knight, Pair<Integer, Integer> pawn) {
        this.state = new GameStateImpl(knight, pawn, new MovementImpl(size));
    }

    @Override
    public boolean hit(int row, int col) {
        return state.tryMoveKnightTo(row, col);
    }

    @Override
    public boolean hasKnight(int row, int col) {
        return state.hasKnight(row, col);
    }

    @Override
    public boolean hasPawn(int row, int col) {
        return state.hasPawn(row, col);
    }
}