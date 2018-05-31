
import java.util.Scanner;


public class Battleships{
    private int model[][];
    private final int xSize;
    private final int ySize;
    private final static String SEPERATOR = "|";

    public Battleships(int x,int y, int ships){
        this.xSize = x;
        this.ySize = y;
        model = new int[x][y];
        inistialiseModel();
        setShipRoutine(ships);
        printModel();
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
        for(int x=0; x<this.xSize; x++){
            for(int y=0; y<this.ySize; y++){
                System.out.print(SEPERATOR);
                int value = model[x][y];
                if(value==0 || value==1){//emtpy or ship
                    if (value==1){
                        System.out.print("S");

                    }else {
                        System.out.print(" ");
                    }
                // }else if (value==1) {
                //     System.out.print(model[x][y]);
                // }else if (value==-1) {
                //     System.out.print(model[x][y]);
                }else if (value==2) {//hit
                    System.out.print("H");
                }
            }
            System.out.println(SEPERATOR);
        }
    }

    public void setShipRoutine(int times) {
        Scanner scan = new Scanner(System.in);
        int x=xSize;
        int y=ySize;
        for (int i=0;i<times;i++){
            System.out.println(i);
            while(x>=xSize){
                System.out.print("Gib x: ");
                x = scan.nextInt();
            }
            while(y>=ySize){
                System.out.print("Gib y: ");
                y = scan.nextInt();
            }
            model[x][y]=1;
            x=xSize;
            y=ySize;
        }
        scan.close();
    }

    // public void hit(int x, int y) {
    //     if (model[x][y]==1) { //if ship present, hit
    //         model[x][y]=2;
    //     }
    // }
    // private void hitAction(){}

}
