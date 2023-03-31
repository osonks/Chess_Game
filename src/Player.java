public class Player {
    private String name;
    private final boolean white;

    public Player(String name, boolean white){
        this.name=name;
        this.white= white;
    }

    public String getName(){return name;}
    public void setName(String name) {
        this.name = name;
    }

    public boolean isWhite() {
        return white;
    }
}
