import java.io.FileNotFoundException;

public class Wizard extends Character{

    final int MANA_MIN=10;
    final int MANA_MAX=50;
    final int INTELLIGENCE_MIN=1;
    final int INTELLIGENCE_MAX=50;
    final int HP_WIZARD_MIN=50;
    final int HP_WIZARD_MAX=100;
    private int mana;
    private int intelligence;

    //CONSTRUCTORS


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
        if(mana>MANA_MAX){
            setMana(MANA_MAX);
        } else if (mana<MANA_MIN) {
            setMana(MANA_MIN);
        }else
            this.mana=mana;
    }

    public void setIntelligence(int intelligence) {
        if (intelligence>INTELLIGENCE_MAX){
            setIntelligence(INTELLIGENCE_MAX);
        } else if (intelligence<INTELLIGENCE_MIN) {
            setIntelligence(INTELLIGENCE_MIN);
        }else{
            this.intelligence = intelligence;
        }
    }

    public int getMana() {
        return mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    @Override
    public String toString() {
        return "\nWizard " +
                getId() + " "+
                getName()+
                "\nhp=" + getHp()+
                "\nmana=" + mana +
                "\nintelligence=" + intelligence +
                "\nType= "+getCharacterType()+
                "\n*************************\n";
    }
}
