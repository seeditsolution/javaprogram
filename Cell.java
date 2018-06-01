
public class Cell {

    private State state;
    private Ship ship;

    public Cell() {
        state = State.EMPTY;
    }

    public void hit(){
        state=State.HIT;
    }

    public void miss(){
        state=State.MISS;
    }

    public void assignShip(){
        ship = new Ship();
        state=State.SHIP;
    }

    public void assignShip(int health){
        ship = new Ship(health);
        state=State.SHIP;
    }
    public State getState(){
        return state;
    }
    public Ship getShip(){
        return ship;
    }
}
