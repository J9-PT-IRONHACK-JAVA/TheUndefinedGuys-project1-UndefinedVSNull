import java.util.Scanner;

public class Lobby {

    private final Team teamOne = new Team();
    private final Team teamTwo = new Team();

    public Team getTeamOne() {
        return teamOne;
    }


    Lobby() {}

    public void createLobby(int creationMode, Scanner input) throws InterruptedException{
        int capacity = teamCapacity(input);
        switch (creationMode) {
            case 1:
                System.out.print(TerminalTools.CLEAR_SCREEN);
                presentationMessage("TEAMONE"); //make it as title
                creatingCustomized(teamOne, capacity, input);
                System.out.print(TerminalTools.CLEAR_SCREEN);
                presentationMessage("TEAMTWO"); // make it as title
                creatingCustomized(teamTwo, capacity, input);
                break;
            case 2:
                creatingRandom();
                break;
            case 3:
                creatingFomCSV();
                break;
        }
    }
    public int teamCapacity(Scanner input) {
        String size;
        System.out.println("\t\t\t\t\t\tHow many characters would you like on your team?");
        size = input.nextLine();
        return (Integer.parseInt(size));
    }
    public void creatingCustomized(Team team, int size, Scanner input) throws InterruptedException {
        //String type, name, hp, energy, power;
        String[] charStats = new String[5];
        for (int i = 0; i < size; i++) {
            charStats[0] = assignTypeOfCharacter(input);
            System.out.println("Enter the name:");
            charStats[1] = input.nextLine();
            charStats[2] = AssignValueAndShowDialogueWithIntegers("Enter the health", input);
            charStats[3] = AssignValueAndShowDialogueWithIntegers("Enter the energy", input);
            charStats[4] = AssignValueAndShowDialogueWithIntegers("Enter the power", input);
            team.addCharactersCustom(charStats);
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
                System.out.println("You entered an invalid number. Try again");
        } while (comparision);
        return type;
    }
    private void showCharacters() throws InterruptedException {
        // Show it like is charging, like old...
        String character = "";
        int i = 1;
        // Make in the same line
        for (CharacterType charType: CharacterType.values()) {
            character += "\t\t\t[%d] - ".formatted(i);
            //System.out.printf("[%d] - ", i);
            character += "%s\t\t\t\t".formatted(charType);
            //Menu.makeItSlow(character);
            i++;
        }
        Menu.makeItSlow(character, 50);
    }
    private String AssignValueAndShowDialogueWithIntegers(String dialogue, Scanner input) {
        boolean comparision;
        String value;
        do {
            System.out.println(dialogue);
            value = input.nextLine();
            comparision = isNumber(value);
            if (!comparision)
                System.out.println("You have entered an invalid number. Try again");
        } while (!comparision);
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

    public void creatingRandom() {
        //TODO
    }
    public void creatingFomCSV() {
        //TODO
    }
    public void presentationMessage(String str) throws InterruptedException {
        String teamOne = ("""
                 _       __     __                             _______________    __  _______  _   ________   _________
                | |     / /__  / /________  ____ ___  ___     /_  __/ ____/   |  /  |/  / __ \\/ | / / ____/  /_  __<  /
                | | /| / / _ \\/ / ___/ __ \\/ __ `__ \\/ _ \\     / / / __/ / /| | / /|_/ / / / /  |/ / __/      / /  / /\s
                | |/ |/ /  __/ / /__/ /_/ / / / / / /  __/    / / / /___/ ___ |/ /  / / /_/ / /|  / /___     / /  / / \s
                |__/|__/\\___/_/\\___/\\____/_/ /_/ /_/\\___/    /_/ /_____/_/  |_/_/  /_/\\____/_/ |_/_____/    /_/  /_/  \s
                                                                                                                      \s
                """);
        String TeamTwo = ("""
                 _       __     __                             _______________    __  __________       ______     _________\s
                | |     / /__  / /________  ____ ___  ___     /_  __/ ____/   |  /  |/  /_  __/ |     / / __ \\   /_  __/__ \\
                | | /| / / _ \\/ / ___/ __ \\/ __ `__ \\/ _ \\     / / / __/ / /| | / /|_/ / / /  | | /| / / / / /    / /  __/ /
                | |/ |/ /  __/ / /__/ /_/ / / / / / /  __/    / / / /___/ ___ |/ /  / / / /   | |/ |/ / /_/ /    / /  / __/\s
                |__/|__/\\___/_/\\___/\\____/_/ /_/ /_/\\___/    /_/ /_____/_/  |_/_/  /_/ /_/    |__/|__/\\____/    /_/  /____/\s
                                                                                                                           \s
                """);

        Menu.makeItSlow(teamOne, 5);
    }
    @Override
    public String toString() {
        return null;
    }
}
