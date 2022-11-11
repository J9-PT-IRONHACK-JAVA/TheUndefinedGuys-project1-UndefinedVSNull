package Characters;

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
        setCharacterType('i');
        setName(super.randomNames());
        setHp(randomParameters(HP_WIZARD_MIN,HP_WIZARD_MAX));
        setMana(randomParameters(MANA_MIN,MANA_MAX));
        setIntelligence(randomParameters(INTELLIGENCE_MIN,INTELLIGENCE_MAX));
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

    public void changeMana(int mana) {
        this.mana+=mana;
    }

    @Override
    public void attack(Character defender) {

        if(mana>=5){
            System.out.println("Fireball Casted!");
            changeMana(-5);
            defender.setHp(defender.getHp()-intelligence);
            System.out.println(defender.getName()+"'s health decreased to "+defender.getHp());
            System.out.println("Wizard "+getName()+" stamina decreased to "+getMana()+" \n");
        }
        else{
            System.out.println("Staff hit!");
            changeMana(+1);
            defender.setHp(defender.getHp()-2);
            System.out.println(defender.getName()+"'s health decreased to "+defender.getHp());
            System.out.println("Wizard "+getName() +" stamina reduced to "+getMana() +" \n");
        }

    }
    @Override
    public String toString() {

        //Defining emoticons
        String gMana="🔋";
        String gIntelligence="📜";
        String gHp="💖";
        String gVoid=" ·";

        //Variables
        String[]arrayGStats={gMana,gIntelligence,gHp}; //graphicBar
        String[] gToString={"","",""}; //Guarda el String 🍗🍗🍗🍗
        int[] arrayCurrentStats= {mana,intelligence,getHp()};
        int[] arrayMaxStats={MANA_MAX,INTELLIGENCE_MAX,HP_WIZARD_MAX};

        int[] arrayPercentages=new int[arrayGStats.length];


        // Creamos un array del número de atributos 3
        // y grabamos el porcentaje en tanto por 10 de cada uno de ellos
        for (int i=0;i<arrayPercentages.length;i++){ //Array de 3 atributos
            arrayPercentages[i]=arrayCurrentStats[i]*10/arrayMaxStats[i];
        }

        //Rellenando cada barra
        for (int i=0;i<arrayGStats.length;i++) {//Itera para cada atributo
            //Rellena la barra con emoticonos
            for(int j=0; j< arrayPercentages[i];j++){
                gToString[i]+=arrayGStats[i];
            }
            //Rellena la barra con "vacío"
            for(int j=arrayPercentages[i]; j< 10;j++){
                gToString[i]+=gVoid;
            }
        }

        return "\n🧪 Wizard  " +

                getId()+ "  "+
                getName() +
                " \nhp= " + getHp() +
                " (" + arrayPercentages[2]*10 + "%) |" +gToString[2]+"|"+

                "\t   mana  "+ mana +
                " (" +arrayPercentages[0]*10 +  "%) |" + gToString[0]+"|"+

                "\t   intelligence=" + intelligence +
                " ("+  arrayPercentages[1]*10 + "%) |"+gToString[1]+"|";

    }

}
