public class Cell<T> {

    private State state;
    private T object;

    public Cell() {
        state = State.EMPTY;
    }

    public void hit(){
        state=State.HIT;
    }

    public void miss(){
        state=State.MISS;
    }

    public void assignObject(T object){
        this.object = object;
        state=State.OCCUPIED;
    }

    public State getState(){
        return state;
    }
    public T getObject(){
        return object;
    }
    public void setState(State state){
        this.state = state;
    }
    public void resetCell() {
        state=State.EMPTY;
        object=null;
    }
    public void resetObject(){
        object=null;
    }

    @Override
    public String toString(){
        String string = this.state.toString();
        if(object!= null ){
            string+=" | " + object;
        }
        return string;
    }
}
