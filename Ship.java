public class Ship {
    private int health;
    private static final int HEALTH_DEFAULT = 2;
    private Orientation orientation;
    public Ship(Orientation orientation){
        health = HEALTH_DEFAULT;
        this.orientation = orientation;
    }
    public Ship(Orientation orientation, int health){
        this.health = health;
        this.orientation = orientation;
    }
    public void decreaseHealth() {
        health-=1;
    }
    public int getHealth() {
        return health;
    }
    public Orientation getOrientation() {
        return orientation;
    }
    @Override
    public String toString(){
        return String.format("Ship: %s",String.valueOf(health));
    }
}
