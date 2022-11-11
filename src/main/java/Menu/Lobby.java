package Menu;

import Characters.Character;
import Characters.CharacterType;
import Characters.Warrior;
import Characters.Wizard;
import Tools.DrawingASCII;
import Tools.TerminalTools;
import Battle.Team;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

    public void createLobby(int creationMode, Scanner input) throws InterruptedException, IOException {
        int capacity = teamCapacity(input);
        switch (creationMode) {
            case 1:
                customizedInput(capacity, input);
                break;
            case 2:
                randomInput(capacity, input);
                break;
            case 3:
                //creatingFomCSV();
                break;
        }
    }

    //TODO
    // Code duplicated in switches, needed to be simplified
    private void customizedInput(int capacity, Scanner input) throws InterruptedException, IOException {
        for (int i = 0; i < teams.length; i++) {
            System.out.print(TerminalTools.CLEAR_SCREEN);
            DrawingASCII.presentationMessage(i + 1); //make it as title
            creatingCustomized(teams[i], capacity, input);
        }
        exportToCSV(teams);
    }

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

            enterToContinue(input);
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
    private void enterToContinue(Scanner input) {
        System.out.println("\n\n\t\t\t\t\tEnter to continue...");
        input.nextLine();
        System.out.print(TerminalTools.CLEAR_SCREEN);
    }

    public void randomInput(int capacity, Scanner input) throws InterruptedException, IOException {
        for (int i = 0; i < teams.length; i++) {
            System.out.print(TerminalTools.CLEAR_SCREEN);
            DrawingASCII.presentationMessage(i + 1);
            teams[i].addCharactersRandom(capacity);
            //TODO
            // MAKE IT PRETTIER
            System.out.println(teams[i].getTeamCharacters());
            enterToContinue(input);
        }
        exportToCSV(teams);
    }

    private void exportToCSV(Team[] teams) throws IOException {
        FileWriter writer = new FileWriter("./tesExporting.csv");
        writer.write("Team, Type, Name, Health, Energy, Power\n");
        for (int iterTeam = 0; iterTeam < teams.length; iterTeam++) {
            for (int iterChar = 0; iterChar < teams[iterTeam].getTeamCharacters().size(); iterChar++) {
                writingToCSV(teams, writer, iterTeam, iterChar);
            }
        }
        writer.close();
    }

    private static void writingToCSV(Team[] teams, FileWriter writer, int team, int character) throws IOException {
        Character ch = teams[team].getTeamCharacters().get(character);
        writer.write(team + "," +
                ch.getCharacterType() + "," +
                ch.getName() + "," +
                ch.getHp() + ",");
        switch (ch.getCharacterType()) {
            case 'a':
                writer.write(((Warrior)ch).getStamina() + ","
                        + ((Warrior)ch).getStrength() + "\n");
                break;
            case 'i':
                writer.write(((Wizard)ch).getMana() + ","
                        + ((Wizard)ch).getIntelligence() + "\n");
                break;
        }
    }

    public void creatingFomCSV(Team[] team) {
        /*
        //var gson = new GsonBuilder().setPrettyPrinting().create();
        for (Team team : teams) {
            //String teamToJson = gson.toJson(team);
            //writer.write(teamToJson);
            writer.close();
        }
         */
        //TODO
    }
}