public enum State {
    EMPTY("Empty"),
    OCCUPIED("Ship"),
    MISS("Miss"),
    HIT("Hit");

    private String string_rep;
    State(String string_rep){
        this.string_rep = string_rep;
    }

    @Override
    public String toString(){
        return string_rep;
    }
}
