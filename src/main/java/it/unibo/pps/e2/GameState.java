package it.unibo.pps.e2;

public interface GameState {
    Pair<Integer,Integer> getKnight();
    Pair<Integer,Integer> getPawn();
    boolean hasKnight(int row, int col);
    boolean hasPawn(int row, int col);
    boolean tryMoveKnightTo(int row, int col);
}
