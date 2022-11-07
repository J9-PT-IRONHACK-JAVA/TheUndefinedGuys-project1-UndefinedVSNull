import java.io.FileNotFoundException;

public class Warrior extends Character implements Attacker{
    //Constants
    final int STAMINA_MIN=10;
    final int STAMINA_MAX=50;
    final int STRENGTH_MIN =1;
    final int STRENGTH_MAX =10;
    final int HP_WARRIOR_MIN=100;
    final int HP_WARRIOR_MAX=200;

    //Variables
    private int stamina;
    private int strength;


    //CONSTRUCTORS
    //Full Customized
    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);

        //Controlling hp introduced is the parameters range
        if (hp>HP_WARRIOR_MAX) setHp(HP_WARRIOR_MAX);
        else if (hp<HP_WARRIOR_MIN) {
            setHp(HP_WARRIOR_MIN);
        }
        setStamina(stamina);
        setStrength(strength);
        setCharacterType('a');
    }
    //Full Random
    public Warrior() throws FileNotFoundException {
        super();
        setCharacterType('a');
        setName(super.randomNames());
        setHp(randomParameters(HP_WARRIOR_MIN,HP_WARRIOR_MAX));
        stamina=super.randomParameters(STAMINA_MIN,STAMINA_MAX);
        strength =super.randomParameters(STRENGTH_MIN,STRENGTH_MAX);
    }

    //Setters
    public void setStamina(int stamina) {
        if (stamina>STAMINA_MAX){
            this.stamina = STAMINA_MAX;
        } else if (stamina<STAMINA_MIN) {
            this.stamina = STAMINA_MIN;
        }else {
            this.stamina = stamina;
        }
    }

    public void setStrength(int strength) {
        if (strength > STRENGTH_MAX){
            this.strength = STRENGTH_MAX;
        } else if (strength < STRENGTH_MIN) {
            this.strength = STRENGTH_MIN;
        }else {
            this.strength = strength;
        }
    }

    //Getters

    public int getStamina() {
        return stamina;
    }
    public int getStrength() {
        return strength;
    }

    //Other methods
    @Override
    public void attack(Character defender) {
        int attackEnergy = 0;

        if(stamina>=5){
            System.out.println("Heavy attack!");
            attackEnergy=1;
            //Actualiza stamina
            setStamina(stamina-=5);
            //setting Damage
            defender.setHp(defender.getHp()-strength);
            System.out.println("Defender hp reduced to "+defender.getHp());
            System.out.println("Defender Stamina reduced to "+getStamina());
        }
        else{
            System.out.println("Weak attack!");
            attackEnergy=0;
            //Actualiza stamina
            setStamina(stamina+=1);
            //setting Damage
            defender.setHp(defender.getHp()- (int) (strength/2));
            System.out.println("Defender hp reduced to "+defender.getHp());
            System.out.println("Defender Stamina reduced to "+getStamina());
        }
    }

    @Override
    public String toString() {
        return "\nWarrior " +
                getId()+ "  "+
                getName() +
                " \thp=" + getHp() +
                "\tstamina=" + stamina +
                "\tstrength=" + strength +
                "\tType=" + getCharacterType() +
                "\n*************************\n";
    }
}
