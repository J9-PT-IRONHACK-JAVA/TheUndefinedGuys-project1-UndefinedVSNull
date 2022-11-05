import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Team {

    String charType;
    ArrayList<Character> teamCharacters;

    //Constructor
    public Team() {}
    public Team(ArrayList teamCharacters) {
        this.teamCharacters = teamCharacters;
    }

    //Getters
    public ArrayList getTeamCharacters() {
        return teamCharacters;
    }

    //Add Characters - Custom Mode
    public void addCharactersCustom(String[] charStats){
        if(charStats[1].equals("Warrior")){
            Warrior a = new Warrior(charStats[0], Integer.parseInt(charStats[2]), Integer.parseInt(charStats[3]), Integer.parseInt(charStats[4]));
            teamCharacters.add(a);
        }
        else if(charStats[1].equals("Wizard")){
            Wizard i = new Wizard(charStats[0], Integer.parseInt(charStats[2]), Integer.parseInt(charStats[3]), Integer.parseInt(charStats[4]));
            this.teamCharacters.add(i);
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
