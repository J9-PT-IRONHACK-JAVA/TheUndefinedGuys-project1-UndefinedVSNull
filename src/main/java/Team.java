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
    public void addCharactersRandom(int capacity) throws FileNotFoundException {
        int[] team = new int[capacity];
        //team = determineCharType(capacity);
        for (int i = 0; i < team.length; i++) {
            if(team[i] == 1){
                Warrior war = new Warrior();
                teamCharacters.add(war);
            }
            else if(team[i] == 2){
                Wizard wiz = new Wizard();
                this.teamCharacters.add(wiz);
            }
        }
    }

}
