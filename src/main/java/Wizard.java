import java.io.FileNotFoundException;

public class Wizard extends Character implements Attacker{

    final int MANA_MIN=10;
    final int MANA_MAX=50;
    final int INTELLIGENCE_MIN=1;
    final int INTELLIGENCE_MAX=50;
    final int HP_WIZARD_MIN=50;
    final int HP_WIZARD_MAX=100;
    private int mana;
    private int intelligence;

    //CONSTRUCTORS
    //Customized
    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        if (hp>HP_WIZARD_MAX) setHp(HP_WIZARD_MAX);
        else if (hp<HP_WIZARD_MIN) {
            setHp(HP_WIZARD_MIN);
        }
        setMana(mana);
        setIntelligence(intelligence);
        setCharacterType('i');
    }
    //Full random
    public Wizard() throws FileNotFoundException {
        super();
        setName(super.randomNames());
        setHp(randomParameters(HP_WIZARD_MIN,HP_WIZARD_MAX));
        setMana(randomParameters(MANA_MIN,MANA_MAX));
        setIntelligence(randomParameters(INTELLIGENCE_MIN,INTELLIGENCE_MAX));
        setCharacterType('i');
    }

    //SETTERS
    public void setMana(int mana) {
        if(mana > MANA_MAX){
            this.mana = MANA_MAX;
        } else if (mana < MANA_MIN) {
            this.mana = MANA_MIN;
        }else
            this.mana = mana;
    }

    public void setIntelligence(int intelligence) {
        if (intelligence > INTELLIGENCE_MAX){
            this.intelligence = INTELLIGENCE_MAX;
        } else if (intelligence < INTELLIGENCE_MIN) {
            this.intelligence = INTELLIGENCE_MIN;
        }else{
            this.intelligence = intelligence;
        }
    }

    //Getters
    public int getMana() {
        return mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    //Other methods

    @Override
    public void attack(Character defender) {

        if(mana>=5){
            System.out.println("Fireball Casted!");
            setMana(mana-=5);
            defender.setHp(defender.getHp()-intelligence);
            System.out.println(defender.getName()+"'s health decreased to "+defender.getHp());
            System.out.println("Wizard "+getName()+" stamina decreased to "+getMana()+" \n");
        }
        else{
            System.out.println("Staff hit!");
            setMana(mana+=1);
            defender.setHp(defender.getHp()-2);
            System.out.println(defender.getName()+"'s health decreased to "+defender.getHp());
            System.out.println("Wizard "+getName() +" stamina reduced to "+getMana() +" \n");
        }

    }
    @Override
    public String toString() {
        return "\nWizard " +
                getId() + " "+
                getName()+
                "\thp=" + getHp()+
                "\tmana=" + mana +
                "\tintelligence=" + intelligence +
                "\tType= "+getCharacterType()+
                "\n*************************\n";
    }

}
