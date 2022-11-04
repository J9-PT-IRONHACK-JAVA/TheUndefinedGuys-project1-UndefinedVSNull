import java.io.FileNotFoundException;

public class Warrior extends Character{

    final int STAMINA_MIN=10;
    final int STAMINA_MAX=50;
    final int STRENGTH_MIN =1;
    final int STRENGTH_MAX =10;
    final int HP_WARRIOR_MIN=100;
    final int HP_WARRIOR_MAX=200;
    private int stamina;
    private int strength;


    //CONSTRUCTORS
    //Full Customized
    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        if (hp>HP_WARRIOR_MAX) setHp(HP_WARRIOR_MAX);
        else if (hp<HP_WARRIOR_MIN) {
            setHp(HP_WARRIOR_MIN);
        }
        setStamina(stamina);
        setStrength(strength);
        setCharacterType('a');
    }

    public Warrior() throws FileNotFoundException {
        super();
        setName(super.randomNames());
        setHp(randomParameters(HP_WARRIOR_MIN,HP_WARRIOR_MAX));
        stamina=super.randomParameters(STAMINA_MIN,STAMINA_MAX);
        strength =super.randomParameters(STRENGTH_MIN,STRENGTH_MAX);
        setCharacterType('w');
    }

    public void setStamina(int stamina) {
        if (stamina>STAMINA_MAX){
            setStamina(STAMINA_MAX);
        } else if (stamina<STAMINA_MIN) {
            setStamina(STAMINA_MAX);
        }else {
            this.stamina = stamina;
        }
    }

    public void setStrength(int strength) {
        if (strength > STRENGTH_MAX){
            setStrength(STRENGTH_MAX);
        } else if (strength < STRENGTH_MIN) {
            setStrength(STRENGTH_MIN);
        }else {
            this.strength = strength;
        }
    }

    @Override
    public String toString() {
        return "\nWarrior " +
                getId()+ "  "+
                getName() +
                " \nhp=" + getHp() +
                "\nstamina=" + stamina +
                "\nstrength=" + strength +
                "\nType=" + getCharacterType() +
                "\n*************************\n";
    }
}
