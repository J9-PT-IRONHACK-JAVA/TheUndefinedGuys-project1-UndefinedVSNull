package Menu;

import Characters.CharacterType;
import Tools.DrawingASCII;
import Tools.TerminalTools;
import Battle.Team;

<<<<<<< HEAD
=======
import java.io.File;
>>>>>>> a8a7b1cad3d24cf15d72ea9775187e9112fb97d9
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

<<<<<<< HEAD
    public void createLobby(int creationMode, Scanner input) throws InterruptedException, FileNotFoundException {
        int capacity = teamCapacity(input);
        switch (creationMode) {
            case 1:
                customizedInput(capacity, input);
                break;
            case 2:
                randomInput(capacity);
                break;
            case 3:
                creatingFomCSV();
                break;
=======
    public void menu_two_choice(int creationMode, Scanner input, String menuOneInput) throws InterruptedException, IOException {

        int capacity = 0;
        if (menuOneInput.equals("3"))
            creationMode += 1;
        if (creationMode != 3)
            capacity = teamCapacity(input);
        switch (creationMode) {
            case 1 -> customizedInput(menuOneInput, capacity, input);
            case 2 -> randomizedInput(capacity, input);
            case 3 -> creatingFomCSV();

>>>>>>> a8a7b1cad3d24cf15d72ea9775187e9112fb97d9
        }
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
    //TODO
    // mirar HOW WOULD YOU LIKE TO CREATE 2 SCREEN

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
<<<<<<< HEAD
            Thread.sleep(3000);
            System.out.print(TerminalTools.CLEAR_SCREEN);
=======
            enterToContinue(input);
>>>>>>> a8a7b1cad3d24cf15d72ea9775187e9112fb97d9
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
<<<<<<< HEAD

    public void randomInput(int capacity) throws InterruptedException, FileNotFoundException {
        for (int i = 0; i < teams.length; i++) {
            System.out.print(TerminalTools.CLEAR_SCREEN);
            DrawingASCII.presentationMessage(i + 1); //make it as title
            teams[i].addCharactersRandom(capacity);
            //teams[i].showStats();
=======
    public static void enterToContinue(Scanner input) {
        System.out.println("\n\n\t\t\t\t\tEnter to continue...");
        input.nextLine();
        System.out.print(TerminalTools.CLEAR_SCREEN);
    }

    private void customizedInput(String menuOneInput, int capacity, Scanner input) throws InterruptedException, FileNotFoundException {
        int players = Integer.parseInt(menuOneInput);

        for (int i = 0; i < players; i++) {
            System.out.print(TerminalTools.CLEAR_SCREEN);
            DrawingASCII.presentationMessage(i + 1); //make it as title
            creatingCustomized(teams[i], capacity, input);
        }
        if (players == 1)
            teamTwo.addCharactersRandom(capacity);
    }
    public void randomizedInput(int capacity, Scanner input) throws InterruptedException, IOException {
        for (int i = 0; i < teams.length; i++) {
            System.out.print(TerminalTools.CLEAR_SCREEN);
            DrawingASCII.presentationMessage(i + 1);
            teams[i].addCharactersRandom(capacity);
            showStats(teams[i]);
            //System.out.println(teams[i].getTeamCharacters());
            enterToContinue(input);
>>>>>>> a8a7b1cad3d24cf15d72ea9775187e9112fb97d9
        }
    }

<<<<<<< HEAD
    public void creatingFomCSV() {
        //TODO
=======
    public static void showStats(Team team) {
        int sizeTeam = team.getTeamCharacters().size();
        for (int i = 0; i < sizeTeam; i++) {
            System.out.printf("\n%s\n", team.getTeamCharacters().get(i));
        }
    }

    private void exportToCSV(Team[] teams) throws IOException {
        FileWriter writer = new FileWriter("./database.csv");
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

    public void creatingFomCSV() throws FileNotFoundException {
        File targetFile = new File("./database.csv");
        Scanner details = new Scanner(targetFile);

        String detailsTeam;
        String[] charStats;
        while (details.hasNext()) {
            detailsTeam = details.nextLine();

            String[] charStatsCSV = detailsTeam.split(",");
            charStats =  new String[] {
                    determineChar(charStatsCSV[1]), charStatsCSV[2], charStatsCSV[3], charStatsCSV[4], charStatsCSV[5]};
            if (charStatsCSV[0].equals("0")) {
                teamOne.addCharactersCustom(charStats);
            }
            else if (charStatsCSV[0].equals("1")) {
                teamTwo.addCharactersCustom(charStats);
            }
            System.out.print(TerminalTools.CLEAR_SCREEN);
        }
        details.close();
>>>>>>> a8a7b1cad3d24cf15d72ea9775187e9112fb97d9
    }
    private String determineChar(String s) {
        String characterType = "";
        if (s.equals("a"))
            characterType = "1";
        else if (s.equals("i"))
            characterType = "2";
        return characterType;
    }

}