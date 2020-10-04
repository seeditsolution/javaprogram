public enum Orientation {
    ENEMY("Enemy"),
    FRIENDLY("Friendly");

    private String string_rep;
    Orientation(String string_rep){
        this.string_rep = string_rep;
    }

    @Override
    public String toString(){
        return string_rep;
    }
}
