import java.util.ArrayList;
import java.util.Scanner;

public class Lobby {

    public final Team teamOne = new Team();
    public final Team teamTwo = new Team();


    public Team getTeamOne() {
        return teamOne;
    }

    public Team getTeamTwo() {
        return teamTwo;
    }


    public void createLobby(int creationMode, Scanner input) throws InterruptedException{

        switch (creationMode) {
            case 1:
                System.out.println("How many characters would you like on your team?");
                int capacity = teamCapacity(input);
                presentationMessage("TO YOUR TEAM CUSTOMIZATION");
                creatingCustomized(teamOne, capacity, input);
                System.out.println("Your team has been created! " + teamOne.getTeamCharacters());
                System.out.println("How many characters would you like on the enemy's team?");
                capacity = teamCapacity(input);
                presentationMessage("TO ENEMY TEAM CUSTOMIZATION");
                creatingCustomized(teamTwo, capacity, input);
                System.out.println("Enemy team created! "+teamTwo.getTeamCharacters());
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
                    What do you want to create?
                    ================
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
        String character;
        int i = 1;
        for (CharacterType charType: CharacterType.values()) {
            System.out.printf("[%d] - ", i);
            character = "%s\n".formatted(charType);
            Menu.makeItSlow(character);
            i++;
        }
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
        String msg = ("""
                WELCOME %s
                """.formatted(str));
        Menu.makeItSlow(msg);
    }
    @Override
    public String toString() {
        return null;
    }
}
