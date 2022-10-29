public class Wizard extends Character{

    //CONSTANTS
    final int MANA_MAX=10;
    final int MANA_MIN=50;
    final int INTELLIGENCE_MIN=1;
    final int INTELLIGENCE_MAX=50;

    //variables
    private int mana;
    private int intelligence;

    public Wizard(String name, int hp, int hp_warrior_min, int hp_warrior_max) {
        super(name, hp);
        mana=super.ramdomParameters(MANA_MIN,MANA_MAX);
        intelligence=super.ramdomParameters(INTELLIGENCE_MIN, INTELLIGENCE_MAX);
    }
    //SETTERS

}
