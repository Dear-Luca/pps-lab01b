package it.unibo.pps.e2;

import java.util.*;

public class LogicsImpl implements Logics {

    private final Pair<Integer, Integer> pawn;
    private Pair<Integer, Integer> knight;
    private final int size;
    private RandomPosition randomPosition;

    public LogicsImpl(int size) {
        this.size = size;
        this.randomPosition = new RandomPositionImpl(size);
        this.pawn = this.randomPosition.randomEmptyPosition();
        this.knight = this.randomPosition.randomEmptyPosition(this.pawn);
    }

    public LogicsImpl(int size, Pair<Integer, Integer> knight, Pair<Integer, Integer> pawn){
        this.size = size;
        this.knight = knight;
        this.pawn = pawn;
    }

    @Override
    public boolean hit(int row, int col) {
        if (row < 0 || col < 0 || row >= this.size || col >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        // Below a compact way to express allowed moves for the knight
        int x = row - this.knight.getX();
        int y = col - this.knight.getY();
        if (Math.abs(x) * Math.abs(y) == 2) {
            this.knight = new Pair<>(row, col);
            return this.pawn.equals(this.knight);
        }
        return false;
    }

    @Override
    public boolean hasKnight(int row, int col) {
        return this.knight.equals(new Pair<>(row, col));
    }

    @Override
    public boolean hasPawn(int row, int col) {
        return this.pawn.equals(new Pair<>(row, col));
    }
}
