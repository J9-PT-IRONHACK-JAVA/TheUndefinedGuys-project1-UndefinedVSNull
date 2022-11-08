import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Team {

    private List<Character> teamCharacters;

    //Constructor
    public Team() {
        teamCharacters = new ArrayList<>();
    }

    public void setTeamCharacters(List<Character> teamCharacters) {
        this.teamCharacters = teamCharacters;
    }

    //Getters
    public List<Character> getTeamCharacters() {
        return teamCharacters;
    }

    //Add Characters - Custom Mode

    public void addCharactersCustom(String[] charStats) {
        //checkAvailability(charStats[1]);

        if (charStats[0].equals("1")) {
            Warrior war = new Warrior(charStats[1], Integer.parseInt(charStats[2]), Integer.parseInt(charStats[3]), Integer.parseInt(charStats[4]));
            teamCharacters.add(war);
            System.out.println("New Warrior added!");
        } else if (charStats[0].equals("2")) {
            Wizard wiz = new Wizard(charStats[1], Integer.parseInt(charStats[2]), Integer.parseInt(charStats[3]), Integer.parseInt(charStats[4]));
            this.teamCharacters.add(wiz);
            System.out.println("New Wizard added!");
        }
    }

    //public void checkAvailability(String a){
//}

    //Add Characters - Random Mode
//    public void addCharactersRandom(int capacity) throws FileNotFoundException {
//        int[] team = new int[capacity];
//        //team = determineCharType(capacity);
//        for (int i = 0; i < team.length; i++) {
//            if(team[i] == 1){
//                Warrior war = new Warrior();
//                teamCharacters.add(war);
//            }
//            else if(team[i] == 2){
//                Wizard wiz = new Wizard();
//                this.teamCharacters.add(wiz);
//            }
//        }
//    }



    public boolean checkAllDead(){


        boolean allDead = true;

        for(Character c: getTeamCharacters()){
            if(c.isAlive()){
                allDead=false;
                break;
            }
        }

        return allDead;
    }
}

