package Menu;

import Characters.CharacterType;
import Tools.DrawingASCII;
import Tools.TerminalTools;
import Battle.Team;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lobby {

    private final Team teamOne = new Team();
    private final Team teamTwo = new Team();

    private final Team[] teams = {teamOne, teamTwo};
    public Team getTeamOne() {
        return teamOne;
    }

    public Team getTeamTwo() {
        return teamTwo;
    }
    Lobby() {}

    public void menu_two_choice(int creationMode, Scanner input, String menu_one_input) throws InterruptedException, FileNotFoundException {
        int capacity = teamCapacity(input);
        if(menu_one_input.equals("1")){
            switch (creationMode) {
                case 1 -> customizedInput(capacity, input);   //Custom stats
                case 2 -> randomizedInput(capacity);          //Random stats
                case 3 -> creatingFomCSV();               //CSV stats
            }
        }
    }


    //TODO
    // mirar HOW WOULD YOU LIKE TO CREATE 2 SCREEN
    //System.out.println("\t\t\t\t\tHow many characters would you like on your team?");
    public int teamCapacity(Scanner input) {
        String size;
        System.out.println("\t\t\t\t\t    How many characters would you like for both teams?");
        size = input.nextLine();
        return (Integer.parseInt(size));
    }

    public void creatingCustomized(Team team, int size, Scanner input) throws InterruptedException {
        //String type, name, hp, energy, power;
        String[] charStats = new String[5];
        for (int i = 0; i < size; i++) {
            charStats[0] = assignTypeOfCharacter(input);

            System.out.println("\t\t\t\t\tEnter the name:");
            charStats[1] = input.nextLine();
            charStats[2] = AssignValueAndShowDialogueWithIntegers("Enter the health:", input);
            charStats[3] = AssignValueAndShowDialogueWithIntegers("Enter the energy:", input);
            charStats[4] = AssignValueAndShowDialogueWithIntegers("Enter the power:", input);
            team.addCharactersCustom(charStats);
            Thread.sleep(3000);
            System.out.print(TerminalTools.CLEAR_SCREEN);
        }
    }

    private String assignTypeOfCharacter(Scanner input) throws InterruptedException {
        String type;
        boolean comparision;
        do {
            System.out.println("""
                    \t\t\t\t\t\tWhat do you want to create?
                    """);
            showCharacters();
            type = input.nextLine();
            comparision = Integer.parseInt(type) < 0 || Integer.parseInt(type) > 2;
            if (comparision)
                System.out.println(TerminalTools.ANSI_RED + "\t\t\t\t\tYou entered an invalid number. Try again" + TerminalTools.ANSI_RESET);
        } while (comparision);
        System.out.print(TerminalTools.CLEAR_SCREEN);
        switch (type) {
            case "1" -> DrawingASCII.drawSoldier();
            case "2" -> DrawingASCII.drawWizard();
        }
        return type;
    }

    private void showCharacters() throws InterruptedException {
        String character = "";
        int i = 1;
        for (CharacterType charType : CharacterType.values()) {
            character += "\t\t\t[%d] - ".formatted(i);
            character += "%s\t\t\t\t".formatted(charType);
            i++;
        }
        Menu.makeItSlow(character + "\n", 50);
        DrawingASCII.drawCharacters();
    }

    private String AssignValueAndShowDialogueWithIntegers(String dialogue, Scanner input) {
        boolean comparison;
        String value;
        do {
            System.out.println("\t\t\t\t\t" + dialogue);
            value = input.nextLine();
            comparison = isNumber(value);
            if (!comparison)
                System.out.println(TerminalTools.ANSI_RED + "\t\t\t\tYou entered an invalid number. Try again" + TerminalTools.ANSI_RESET);
        } while (!comparison);
        return value;
    }

    private boolean isNumber(String value) {
        boolean isNum = true;
        int index = 0;
        while (index < value.length() && isNum) {
            if (!(java.lang.Character.isDigit(value.charAt(index))))
                isNum = false;
            index++;
        }
        return isNum;
    }

    //TODO
    // Code duplicated in switches, needed to be simplified

    private void customizedInput(int capacity, Scanner input) throws InterruptedException {
        for (int i = 0; i < teams.length; i++) {
            System.out.print(TerminalTools.CLEAR_SCREEN);
            DrawingASCII.presentationMessage(i + 1); //make it as title
            creatingCustomized(teams[i], capacity, input);
        }
    }
    public void randomizedInput(int capacity) throws InterruptedException, FileNotFoundException {
        for (int i = 0; i < teams.length; i++) {
            System.out.print(TerminalTools.CLEAR_SCREEN);
            DrawingASCII.presentationMessage(i + 1); //make it as title
            teams[i].addCharactersRandom(capacity);
            //teams[i].showStats();
        }
    }

    public void creatingFomCSV() {
        //TODO
    }
}