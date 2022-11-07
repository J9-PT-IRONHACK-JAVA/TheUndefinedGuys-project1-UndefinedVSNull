import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Team {

    String charType;
    ArrayList<Character> teamCharacters = new ArrayList<>();

    //Constructor
    public Team() {}

    public void addCharactersCustom(String[] charStats){
        if(charStats[0].equals("1")){
            Warrior a = new Warrior(charStats[0], Integer.parseInt(charStats[2]), Integer.parseInt(charStats[3]), Integer.parseInt(charStats[4]));
            teamCharacters.add(a);
        }
        else if(charStats[0].equals("2")){
            Wizard i = new Wizard(charStats[0], Integer.parseInt(charStats[2]), Integer.parseInt(charStats[3]), Integer.parseInt(charStats[4]));
            teamCharacters.add(i);
        }
    }

    //Add Characters - Random Mode
    private void addCharactersRandom(String charType) throws FileNotFoundException {

        if(charType.equals("Warrior")){
            Warrior war = new Warrior();
            teamCharacters.add(war);
        }
        else if(charType.equals("Wizard")){
            Wizard wiz = new Wizard();
            this.teamCharacters.add(wiz);
        }
    }
}
