package Characters;

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
    //new method
    public void changeStamina(int stamina) {
        this.stamina+=stamina;
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

        if(stamina>=5){
            System.out.println("Warrior "+getName() +" did a heavy attack!");
            changeStamina(-5);                        //call to a new method
            defender.setHp(defender.getHp()-strength);
            System.out.println(defender.getName()+"'s health decreased to "+defender.getHp());
            System.out.println("characters.Warrior "+getName() +" stamina reduced to "+getStamina()+" \n");
        }
        else{
            System.out.println("Warrior "+getName() +" did a weak attack!");
            changeStamina(+1);
            defender.setHp(defender.getHp()- (strength/2));
            System.out.println(defender.getName()+"'s health decreased to "+defender.getHp());
            System.out.println("characters.Warrior "+getName() +" stamina reduced to "+getStamina() +" \n");
        }
    }

    @Override
    public String toString() {
        //Defining emoticons
        String gStamina="🍗";
        String gStrength="💪";
        String gHp="💖";
        String gVoid=" ·";

        //Variables
        String[]arrayGStats={gStamina,gStrength,gHp}; //graphicBar
        String[] gToString={"","",""}; //Guarda el String 🍗🍗🍗🍗
        int[] arrayCurrentStats= {stamina,strength,getHp()};
        int[] arrayMaxStats={STAMINA_MAX,STRENGTH_MAX,HP_WARRIOR_MAX};

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

        return "\n🔪 Warrior " +
                getId()+ "  "+
                getName() +
                " \nhp= " + getHp() +
                " (" + arrayPercentages[2]*10 + "%) |" +gToString[2]+"|"+

                "\t   stamina  "+ stamina +
                " (" +arrayPercentages[0]*10 +  "%) |" + gToString[0]+"|"+

                "\t   strength=" + strength +
                " ("+  arrayPercentages[1]*10 + "%) |"+gToString[1]+"|";



    }
}
