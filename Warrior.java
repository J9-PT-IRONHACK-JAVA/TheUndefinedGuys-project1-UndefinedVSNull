public class Warrior extends Character{

    final int STAMINA_MIN=10;
    final int STAMINA_MAX=50;
    final int STRENGTH_MIN=1;
    final int STRENGTH_MAX=10;

    private int stamina;
    private int strengt;

    //CONSTRUCTOR
    public Warrior(String name, int hp) {
        super(name, hp);
        stamina=super.ramdomParameters(STAMINA_MIN,STAMINA_MAX);
        strengt=super.ramdomParameters(STRENGTH_MIN,STRENGTH_MAX);

    }

    //SETTERS
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setStrengt(int strengt) {
        this.strengt = strengt;
    }

    //GETTERS

    public int getStamina() {
        return stamina;
    }

    public int getStrengt() {
        return strengt;
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "stamina=" + stamina +
                ", strengt=" + strengt +
                '}';
    }
}
