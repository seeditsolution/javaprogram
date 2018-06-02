public class Ship {
    private int health;
    private static final int HEALTH_DEFAULT = 4;
    public Ship(){
        health = HEALTH_DEFAULT;
    }
    public Ship(int health){
        this.health = health;
    }
    public void decreaseHealth() {
        health-=1;
    }
    public int getHealth() {
        return health;
    }
    @Override
    public String toString(){
        return String.format("Ship: %s",String.valueOf(health));
    }
}
