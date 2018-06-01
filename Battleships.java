
import java.util.Scanner;

/*
 * Table
 * 0 Empty
 * 1 Ship present
 * 2 bomb dopped on empty cell
 * 3 bomb dropped on ship
 */

public class Battleships{
    private int model[][];
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
        model = new int[x][y];
        scanner = new Scanner(System.in);

        inistialiseModel();
        setShipRoutine(this.ships);
        guessRoutine();

        scanner.close();
    }

    private void inistialiseModel(){
        for(int x=0; x<this.xSize; x++){
            for(int y=0; y<this.ySize; y++){
                model[x][y] = 0;
            }
        }
        printModel();
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
                int value = model[x][y];
                if(value==0 || value==1){//emtpy or ship
                    if (value==1){
                        System.out.print("S");
                    }else {
                        System.out.print(" ");
                    }
                }else if (value==2) {//misplaced bomb
                    System.out.print("-");
                }else if (value==3) {//hit
                    System.out.print("H");
                }
            }
            System.out.println(SEPERATOR);
        }
        System.out.println();
    }

    public void setShipRoutine(int times) {
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
            if(model[x][y]==1){
                System.out.println("Cannot place a ship on another ship! Try again please!");
                i-=1;
            }else{
                model[x][y]=1;
            }
            x=xSize;
            y=ySize;
        }
        printModel();
    }



    public void guessRoutine(){
        int xi;
        int yi;
        while (this.ships != 0) {
            System.out.print("Gib target x: ");
            xi = scanner.nextInt();
            System.out.print("Gib target y: ");
            yi = scanner.nextInt();
            guess(xi,yi);
        }
        printModel();
    }

    private void guess(int x, int y){
        bombsDropped+=1;
        if(model[x][y]==0){
            model[x][y] = 2;
            System.out.println("*** MISS!");
        }else if (model[x][y]==1) {
            model[x][y] = 3;
            ships-=1;
            if (this.ships==0){
                System.out.printf("*** HIT! YOU HAVE WON! Bombs used: %s", bombsDropped);
            }else{
                System.out.printf("*** HIT! %s to go!\n",String.valueOf(this.ships));
            }
        }
    }

}
