import java.util.Scanner;
import java.util.Random;


public class Battleships{
    private ShipCell model[][];
    private final int xSize;
    private final int ySize;
    private final static String SEPERATOR = "|";
    private int ships;
    private Scanner scanner;
    private int bombsDropped=0;


    public Battleships(int x,int y, int ships){
        this.xSize = x;
        this.ySize = y;
        this.ships = ships;
        model = new ShipCell[x][y];
        scanner = new Scanner(System.in);

        inistialiseModel();
        setShipRoutine(this.ships);
        guessRoutine();

        scanner.close();
    }

    public void printModel(){
        System.out.print("\n"+ SEPERATOR + " " + SEPERATOR);

        for(int y=0; y<this.ySize; y++){
            System.out.print(String.valueOf(y) + SEPERATOR);
        }
        System.out.println();

        for(int x=0; x<this.xSize; x++){
            System.out.print(SEPERATOR + String.valueOf(x));
            for(int y=0; y<this.ySize; y++){
                System.out.print(SEPERATOR);
                State state = model[x][y].getState();
                if(state==State.EMPTY || state==State.OCCUPIED){
                    if (state==State.OCCUPIED){
                        System.out.print(String.valueOf(model[x][y].getObject().getHealth()));
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
                model[x][y] = new ShipCell();
            }
        }
        printModel();
    }

    private void setShipRoutineComputer() {
        int x;
        int y;
        Random rand = new Random();
        x = rand.nextInt(xSize);
        y = rand.nextInt(ySize);

        if(model[x][y].getState()==State.OCCUPIED){
        }
    }


    private void setShipRoutine(int times) {
        int x=xSize;
        int y=ySize;
        for (int i=0;i<times;i++){
            System.out.printf("****** SHIP %s ******\n",String.valueOf(i+1));
            while(x>=xSize || x<0){
                System.out.print("Gib x: ");
                x = scanner.nextInt();
            }
            while(y>=ySize || y<0){
                System.out.print("Gib y: ");
                y = scanner.nextInt();
            }
            if(model[x][y].getState()==State.OCCUPIED){
                System.out.println("Cannot place a ship on another ship! Try again please!");
                i-=1;
            }else{
                Ship ship = new Ship(Orientation.FRIENDLY);
                model[x][y].assignObject(ship);
            }
            x=xSize;
            y=ySize;
        }
        printModel();
    }

    private void guessRoutine(){
        int xi;
        int yi;
        while (this.ships != 0) {
            System.out.print("Gib target x: ");
            xi = scanner.nextInt();
            System.out.print("Gib target y: ");
            yi = scanner.nextInt();
            guess(xi,yi);
            printModel();
        }
        printModel();
    }

    private void guess(int x, int y){
        bombsDropped+=1;
        if(model[x][y].getState()==State.EMPTY){
            model[x][y].miss();
            System.out.println("*** MISS!");
        }else if (model[x][y].getState()==State.OCCUPIED) {
            model[x][y].getObject().decreaseHealth();
            if (model[x][y].getObject().getHealth()==0){
                ships-=1;
                model[x][y].hit();
                model[x][y].resetObject();
            }
            if (this.ships==0){
                System.out.printf("*** HIT! YOU HAVE WON! Bombs used: %s", bombsDropped);
            }else{
                System.out.printf("*** HIT! %s to go!\n",String.valueOf(this.ships));
            }
        }
    }
}
