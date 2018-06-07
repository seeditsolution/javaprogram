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
    private Scanner scanner;
    private int bombsDropped=0;


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

        for(int x=0; x<this.xSize; x++){
            System.out.print(SEPERATOR + String.valueOf(x));
            for(int y=0; y<this.ySize; y++){
                System.out.print(SEPERATOR);
                Cell<Ship> shipCell;
                if (oriented==Orientation.FRIENDLY){
                    shipCell = model[x][y].getFriendly();
                }else { //enemy
                    shipCell = model[x][y].getEnemy();
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
        for(int x=0; x<this.xSize; x++){
            for(int y=0; y<this.ySize; y++){
                model[x][y] = new DoubleShipCell();
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
            if(model[x][y].getEnemy().getState()==State.EMPTY){

                Ship ship = new Ship(Orientation.ENEMY);
                model[x][y].getEnemy().assignObject(ship);

            }
        }
        printModel(Orientation.ENEMY);
    }


    private void setShipRoutine() {
        int x=xSize;
        int y=ySize;
        warning();

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
            if(model[x][y].getFriendly().getState()==State.OCCUPIED){
                System.out.println("Cannot place a ship on another ship! Try again please!");
                i-=1;
            }else{
                Ship ship = new Ship(Orientation.FRIENDLY);
                model[x][y].getFriendly().assignObject(ship);
            }
            x=xSize;
            y=ySize;
        }
        printModel(Orientation.FRIENDLY);
    }

    private void warning() {
        System.out.printf("%s x - Vertical numbers seen on the left %s\n",PADDING,PADDING);
        System.out.printf("%s y - Horizontal numbers seen on the top %s\n",PADDING,PADDING);
    }

    private void guessRoutine(){
        int x = xSize;
        int y = ySize;
        Random rand = new Random();
        warning();
        while (this.enemyShips != 0) {
            while(x>=xSize || x<0){
                System.out.print("Gib target x: ");
                x = scanner.nextInt();
            }
            while(y>=ySize || y<0){
                System.out.print("Gib target y: ");
                y = scanner.nextInt();
            }
            guess(Orientation.FRIENDLY,x,y); //my orientation is friendly
            x = xSize;
            y = ySize;

            guess(Orientation.ENEMY,rand.nextInt(xSize),rand.nextInt(ySize));

            printModel(Orientation.FRIENDLY);

            printModel(Orientation.ENEMY);
        }
    }

    private void guess(Orientation oriented, int x, int y){

        Cell<Ship> shipCell;

        if (oriented == Orientation.ENEMY) { //tries to kill friendlis. computer
            shipCell = model[x][y].getFriendly();
        }else { //tries to kill enemries. player
            shipCell = model[x][y].getEnemy();
        }

        bombsDropped+=1;
        if(shipCell.getState()==State.EMPTY){
            shipCell.miss();
            System.out.printf("\n%s MISS!\n",PADDING);
        }else if (shipCell.getState()==State.OCCUPIED) {
            shipCell.getObject().decreaseHealth();
            if (shipCell.getObject().getHealth()==0){
                enemyShips-=1;
                shipCell.hit();
                shipCell.resetObject();
            }
            System.out.printf("\n%s HIT! ",PADDING);
            if (this.enemyShips==0){
                System.out.printf("YOU HAVE WON! Bombs used: %s", bombsDropped);
            }else{
                System.out.printf("%s to go!\n",String.valueOf(this.enemyShips));
            }
        }
    }
}
