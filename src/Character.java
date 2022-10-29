import java.util.Random;

public abstract class Character {

    private int id;             //Autoincrement?
    private String name;
    private int hp;             //health points
    private boolean isAlive;
    // private Team team;          //for tracking characters at the graveyard


    //CONSTRUCTOR
    public Character(String name, int hp) {
        setName(name);
        setHp(hp);

    }

    //SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

//    public void setTeam(Team team) {
//        this.team = team;
//    }

    //GETTERS

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

//    public Team getTeam() {
//        return team;
//    }

    //MORE METHODS

    int ramdomParameters(int valueMin, int valueMax){
        Random value= new Random();
        return value.nextInt(valueMin, valueMax+1);
    }
}
