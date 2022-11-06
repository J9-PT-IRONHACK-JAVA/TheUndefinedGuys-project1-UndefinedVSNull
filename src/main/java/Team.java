import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Team {

    String charType;
    ArrayList<String> teamCharacters;

    //Constructor
    public Team() {}
    public Team(ArrayList teamCharacters) {
        this.teamCharacters = teamCharacters;
    }

    public Team() {
    }

    //Getters
    public ArrayList getTeamCharacters() {
        return teamCharacters;
    }

    //Add Characters - Custom Mode

    private void addCharactersCustom(String[] charStats){

        if(charStats[0].equals("Warrior")){
            Warrrior wa = new Warrior(charStats[0], Integer.parseInt(charStats[2]), Integer.parseInt(charStats[3]), Integer.parseInt(charStats[4]));

   
            this.teamCharacters.add(wa.toString());
        }
        else if(charStats[1].equals("Wizard")){
            Wizard wi = new Wizard(charStats[0], Integer.parseInt(charStats[2]), Integer.parseInt(charStats[3]), Integer.parseInt(charStats[4]));
            this.teamCharacters.add(wi.toString());
        }
    }

    //Add Characters - Random Mode
    private void addCharactersRandom(String charType) throws FileNotFoundException {

        if(charType.equals("Warrior")){
            Warrior wa = new Warrior();
            this.teamCharacters.add(wa.toString());
        }
        else if(charType.equals("Wizard")){
            Wizard wi = new Wizard();
            this.teamCharacters.add(wi.toString());
        }
    }
}
