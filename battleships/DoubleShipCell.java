public class DoubleShipCell {
    private Cell<Ship> enemy = new Cell<Ship>();
    private Cell<Ship> friendly = new Cell<Ship>();

    public Cell<Ship> getEnemy(){
        return enemy;
    }

    public Cell<Ship> getFriendly(){
        return friendly;
    }
}
