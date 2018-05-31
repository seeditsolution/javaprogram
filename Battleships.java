// package battleships;


public class Battleships{
    private int model[][];
    private int x;
    private int y;

    public Battleships(int x,int y, int ships){
        this.x = x;
        this.y = y;
        model = new int[x][y];
        inistialiseModel();
    }

    private void inistialiseModel(){
        for(int i=0; i<x; i++){
            for(int j=0; j<y; i++){
                model[i][j] = 0;
            }
        }
        System.out.println(model);
    }

}
