package it.unibo.pps.e2;

public class GameStateImpl implements GameState{
    private Pair<Integer,Integer> knight;
    private final Pair<Integer,Integer> pawn;
    private final Movement movement;

    public GameStateImpl(Pair<Integer,Integer> knight, Pair<Integer,Integer> pawn, Movement movement) {
        this.knight = knight;
        this.pawn = pawn;
        this.movement = movement;
    }

    @Override
    public boolean hasKnight(int row, int col) {
        return this.knight.equals(new Pair<>(row, col));
    }

    @Override
    public boolean hasPawn(int row, int col) {
        return this.pawn.equals(new Pair<>(row, col));
    }

    @Override
    public boolean tryMoveKnightTo(int row, int col) {
        var next = this.movement.move(knight.getX(), knight.getY(), row, col);
        next.ifPresent(pos -> this.knight = pos);
        return this.hasKnight(row, col) && this.hasPawn(row, col);
    }
}
