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
    }

    private void inistialiseModel(){
        for(int i=0; i<this.xSize; i++){
            for(int j=0; j<this.ySize; j++){
                model[i][j] = 0;
            }
        }
        printModel();
    }

    public void printModel(){
        for(int i=0; i<this.xSize; i++){
            for(int j=0; j<this.ySize; j++){
                System.out.print(SEPERATOR);
                System.out.print(model[i][j]);
            }
            System.out.println(SEPERATOR);
        }
    }

}
