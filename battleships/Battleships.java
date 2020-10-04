import java.util.Scanner;
import java.util.Random;


public class Battleships{
    private DoubleShipCell model[][];
    private final int xSize;
    private final int ySize;
    private final static String SEPERATOR = "|";
    private final static String PADDING = "********";
    private int enemyShips;
    private int friendlyShips;
    private int enemyBombsDropped=0;
    private int friendlyBombsDropped=0;

    private Scanner scanner;


    public Battleships(int x,int y, int ships){
        this.xSize = x;
        this.ySize = y;
        this.friendlyShips = ships;
        this.enemyShips = ships;
        this.model = new DoubleShipCell[x][y];
        this.scanner = new Scanner(System.in);

        inistialiseModel();
        setShipRoutine();
        setShipRoutineComputer();
        guessRoutine();

        scanner.close();
    }

    public void printModel(Orientation oriented){
        System.out.printf("\n%s %s %s\n",PADDING,oriented,PADDING);
        System.out.print("\n"+ SEPERATOR + " " + SEPERATOR);

        for(int y=0; y<this.ySize; y++){
            System.out.print(String.valueOf(y) + SEPERATOR);
        }
        System.out.println();

        for(int y=0; y<this.ySize; y++){
            System.out.print(SEPERATOR + String.valueOf(y));
            for(int x=0; x<this.xSize; x++){
                System.out.print(SEPERATOR);
                Cell<Ship> shipCell;
                if (oriented==Orientation.FRIENDLY){
                    shipCell = model[y][x].getFriendly();
                }else { //enemy
                    shipCell = model[y][x].getEnemy();
                }

                State state = shipCell.getState();
                if(state==State.EMPTY || state==State.OCCUPIED){
                    if (state==State.OCCUPIED &&
                        (oriented==Orientation.FRIENDLY || shipCell.getObject().beenHit() ) ){
                        System.out.print(String.valueOf(shipCell.getObject().getHealth()));
                    }else {
                        System.out.print(" ");
                    }
                }else if (state==State.MISS) {
                    System.out.print("-");
                }else if (state==State.HIT) {
                    System.out.print("H");
                }
            }
            System.out.println(SEPERATOR);
        }
        System.out.println();
    }


    private void inistialiseModel(){
        for(int y=0; y<this.ySize; y++){
            for(int x=0; x<this.xSize; x++){
                model[y][x] = new DoubleShipCell();
            }
        }
        printModel(Orientation.FRIENDLY);
    }

    private void setShipRoutineComputer() {
        int x;
        int y;
        Random rand = new Random();

        for (int i=0;i<this.enemyShips;i++){
            x = rand.nextInt(xSize);
            y = rand.nextInt(ySize);
            if(model[y][x].getEnemy().getState()==State.EMPTY){

                Ship ship = new Ship(Orientation.ENEMY);
                model[y][x].getEnemy().assignObject(ship);

            }
        }
        printModel(Orientation.ENEMY);
    }


    private void setShipRoutine() {
        int x=xSize;
        int y=ySize;

        for (int i=0;i<this.friendlyShips;i++){
            System.out.printf("\n%s SHIP %s %s\n",PADDING,String.valueOf(i+1),PADDING);
            while(x>=xSize || x<0){
                System.out.print("Gib x: ");
                x = scanner.nextInt();
            }
            while(y>=ySize || y<0){
                System.out.print("Gib y: ");
                y = scanner.nextInt();
            }
            if(model[y][x].getFriendly().getState()==State.OCCUPIED){
                System.out.println("Cannot place a ship on another ship! Try again please!");
                i-=1;
            }else{
                Ship ship = new Ship(Orientation.FRIENDLY);
                model[y][x].getFriendly().assignObject(ship);
            }
            x=xSize;
            y=ySize;
        }
        printModel(Orientation.FRIENDLY);
    }

    private void guessRoutine(){
        int x = xSize;
        int y = ySize;
        while (this.enemyShips != 0 && this.friendlyShips !=0) {
            while(x>=xSize || x<0){
                System.out.print("Gib target x: ");
                x = scanner.nextInt();
            }
            while(y>=ySize || y<0){
                System.out.print("Gib target y: ");
                y = scanner.nextInt();
            }
            guess(Orientation.FRIENDLY,x,y); //my orientation is friendly
            check(this.enemyShips,Orientation.FRIENDLY);
            x = xSize;
            y = ySize;

            computerGuess();
            check(this.friendlyShips,Orientation.ENEMY);

            printModels();
        }
    }

    private void printModels() {
        printModel(Orientation.FRIENDLY);
        printModel(Orientation.ENEMY);
    }

    private void computerGuess(){
        Random rand = new Random();

        int x = rand.nextInt(xSize);
        int y = rand.nextInt(ySize);
        State state = model[y][x].getFriendly().getState();
        while (state==State.MISS || state == State.HIT) {
            x = rand.nextInt(xSize);
            y = rand.nextInt(ySize);
            state = model[y][x].getFriendly().getState();
        }

        guess(Orientation.ENEMY,x,y);
    }

    private void guess(Orientation oriented, int x, int y){

        Cell<Ship> shipCell;

        if (oriented == Orientation.ENEMY) { //tries to kill friendlis. computer
            shipCell = model[y][x].getFriendly();
            enemyBombsDropped+=1;

        }else { //tries to kill enemries. player
            shipCell = model[y][x].getEnemy();
            friendlyBombsDropped+=1;
        }

        Ship shipObject = shipCell.getObject();
        if(shipCell.getState()==State.EMPTY || shipCell.getState()==State.MISS ){
            System.out.printf("\n%s MISS",PADDING);
            if (shipCell.getState()==State.MISS ) {
                System.out.printf(" AGAIN");
            }
            shipCell.miss();
            System.out.printf("! ");

        }else if (shipCell.getState()==State.OCCUPIED) {
            shipObject.decreaseHealth();
            if (shipObject.getHealth()==0){
                if (oriented == Orientation.ENEMY) {
                    friendlyShips-=1;
                }else{
                    enemyShips-=1;
                }
                shipCell.hit();
                // shipCell.resetObject();
            }
            System.out.printf("\n%s %s HIT! ",PADDING,shipObject.getOrientation());

        }else if (shipCell.getState()==State.HIT) {
            System.out.printf("\n%s ALREADY HIT! ",PADDING);

        }
    }

    private void check(int count, Orientation oriented){
        int bombsDropped;
        if (oriented == Orientation.ENEMY) {
            bombsDropped = friendlyBombsDropped;
        }else{
            bombsDropped = enemyBombsDropped;
        }
        if (count==0){
            System.out.printf("%s HAS WON!\n%s%s bombs used: %s", oriented,PADDING, oriented, bombsDropped);
            printModels();
            System.exit(1);
        }else{
            System.out.printf("%s to go!\n",String.valueOf(count));
        }
    }
}
