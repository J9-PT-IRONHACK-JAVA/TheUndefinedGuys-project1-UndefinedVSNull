import java.util.ArrayList;
import java.util.Scanner;

public class Lobby {
    private Team teamOne;
    private Team teamTwo;

    Lobby() {}

    public void teamCapacity(int creationMode, Scanner input) {
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
    public void creatingCostumized(int size, Scanner input) {
        String type, name, hp, energy, power;

        String[] charStats = new String[5];
        boolean comparision;
        for (int i = 0; i < size; i++) {
            do {
                String creationChar = """
                        What do you want to create?
                        ================
                        [1] - WIZARD
                        [2] - WARRIOR
                        """.formatted();
                type = input.nextLine();
                comparision = Integer.parseInt(type) < 0 || Integer.parseInt(type) > 2;
                if (comparision)
                    System.out.println("You entered a invalid number. Try again");
            } while (comparision);
            System.out.println("Enter the name:");
            teamOne.add(charStats);
        }

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
