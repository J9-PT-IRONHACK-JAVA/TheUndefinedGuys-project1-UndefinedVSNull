package Battle;

import Characters.Character;
import Characters.Warrior;
import Characters.Wizard;
import Tools.TerminalTools;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
            checkAvailabilityName(war);
            teamCharacters.add(war);
            System.out.println(TerminalTools.ANSI_GREEN + "\t\t\t\t\tWARRIOR ADDED!" + TerminalTools.ANSI_RESET);
        } else if (charStats[0].equals("2")) {
            Wizard wiz = new Wizard(charStats[1], Integer.parseInt(charStats[2]), Integer.parseInt(charStats[3]), Integer.parseInt(charStats[4]));
            checkAvailabilityName(wiz);
            this.teamCharacters.add(wiz);
            System.out.println(TerminalTools.ANSI_GREEN + "\t\t\t\tWIZARD ADDED!" + TerminalTools.ANSI_RESET);
        }
    }



        public void checkAvailabilityName(Character someOne ){
            for (Character character: teamCharacters) {
                if(character.getName().equals(someOne.getName()))
                    character.setName(character.getName()+" Jr");
            }   
    }
        

        //Add Characters - Random Mode
        public void addCharactersRandom(int capacity) throws FileNotFoundException {
           
            Random value = new Random();
            int numberOfTypes=2;            //for easy scaling
            int randomCharacter;            //type of characters.Character

            for (int i = 0; i < capacity; i++) {
                randomCharacter=value.nextInt(0, numberOfTypes);    //random from 0 to 1
                switch (randomCharacter){
                    case 0: {
                        Warrior war = new Warrior();
                        checkAvailabilityName(war);
                        teamCharacters.add(war);
                        }
                    case 1: {
                        Wizard wiz = new Wizard();
                        checkAvailabilityName(wiz);
                        teamCharacters.add(wiz);
                    }
                }
            }
        }
 
//        int[] team = new int[capacity];
//        //team = determineCharType(capacity);
//        for (int i = 0; i < team.length; i++) {
//            if(team[i] == 1){
//                characters.Warrior war = new characters.Warrior();
//                teamCharacters.add(war);
//            }
//            else if(team[i] == 2){
//                characters.Wizard wiz = new characters.Wizard();
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

