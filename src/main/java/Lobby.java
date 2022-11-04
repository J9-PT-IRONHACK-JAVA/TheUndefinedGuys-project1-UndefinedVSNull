import java.util.ArrayList;
import java.util.Scanner;

public class Lobby {
    private Team teamOne;
    private Team teamTwo;

    Lobby() {}

    public void teamCapacity(int creationMode, Scanner input) throws InterruptedException {
        int size;
        System.out.println("How many characters would you like on your team?");
        size = input.nextInt();
        switch (creationMode) {
            case 1:
                creatingCostumized(size, input);
            case 2:
                creatingRandom();
            case 3:
                creatingFomCSV();
        }
    }
    private void showCharacters() throws InterruptedException {
        // Show it like is charging, like old...
        int types = CharacterType.values().length;
        String character;
        int i = 1;
        for (CharacterType charType: CharacterType.values()) {
            System.out.printf("[%d] - ", i);
            character = "%s\n".formatted(charType);
            makeItSlow(character);
            i++;
        }
    }
    private void makeItSlow(String arcade) throws InterruptedException {
        for (int i = 0; i < arcade.length(); i++) {
            Thread.sleep(220);
            System.out.print(arcade.charAt(i));
        }
    }
    public void creatingCostumized(int size, Scanner input) throws InterruptedException {
        String type, name, hp, energy, power;
        String[] charStats = new String[5];
        boolean comparision;
        for (int i = 0; i < size; i++) {
            charStats[0] = assignTypeOfCharacter(input);
            System.out.println("Enter the name:");
            charStats[1] = input.nextLine();
            charStats[2] = AssignValueAndShowDialogueWithIntegers("Enter the health", input);
            charStats[3] = AssignValueAndShowDialogueWithIntegers("Enter the energy", input);
            charStats[4] = AssignValueAndShowDialogueWithIntegers("Enter the power", input);
            
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
    @Override
    public String toString() {
        return null;
    }
}
