package Menu;

import Battle.Battlefield;
import Tools.DrawingASCII;
import Tools.TerminalTools;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public void main() throws InterruptedException, IOException {
        Scanner input = new Scanner(System.in);

        String menuOneInput = menuOne(input);   //input del user en menu_one

        String menuTwoInput = menuTwo(menuOneInput, input);    //input del user en menu_two
        Lobby lobby = new Lobby();
        lobby.menu_two_choice(Integer.parseInt(menuTwoInput), input, menuOneInput);

        battlefieldTitle();
        Battlefield battlefield = new Battlefield(lobby);         //battle
        battlefield.battle(menuOneInput, input);

        input.close();
    }

    private String menuOne(Scanner input) throws InterruptedException {
        System.out.print(TerminalTools.CLEAR_SCREEN);
        System.out.println(TerminalTools.ANSI_RED + DrawingASCII.printTitle() + TerminalTools.ANSI_RESET);
        System.out.println(TerminalTools.ANSI_RESET + DrawingASCII.linesSeparationMessage());

        makeItSlow(menuOnePrint(), 20);
        String menuOneInput = input.nextLine();
        menuOneChoice(Integer.parseInt(menuOneInput));
        System.out.print(TerminalTools.CLEAR_SCREEN);

       return menuOneInput;
    }

    private String menuTwo(String menuOneInput, Scanner input) throws InterruptedException {
        System.out.println(TerminalTools.ANSI_RED + DrawingASCII.printTitle() + TerminalTools.ANSI_RESET);
        if (menuOneInput.equals("3"))
            makeItSlow(menuTwoPrintNoPlayers(), 20);
        else
            makeItSlow(menuTwoPrintPlayers(), 20);
        return input.nextLine();
    }

    private void battlefieldTitle() throws InterruptedException {
        makeItSlow(TerminalTools.ANSI_BLUE + DrawingASCII.printBattlefieldTitle() + TerminalTools.ANSI_RESET, 5);
    }

    private void menuOneChoice(int n) {
        /* Que pasa si es de algun tipo de modo de juego? */
        switch (n) {
            case 1 -> System.out.println("PLAYER VS IA");
            case 2 -> System.out.println("PLAYER VS PLAYER");
            case 3 -> System.out.println("IA VS IA");
        }

    }

    private String menuOnePrint() {
        return """
                \t\t\t\t\t\tHOW WOULD YOU LIKE TO PLAY?
                \t\t\t\t\t\t\t[1] - 1 PLAYER
                \t\t\t\t\t\t\t[2] - 2 PLAYERS
                \t\t\t\t\t\t\t[3] - NO PLAYER

                """;
    }
    private String menuTwoPrintPlayers() {
        return """
                \t\t\t\t\t\tHOW WOULD YOU LIKE TO CREATE YOUR TEAM?
                \t\t\t\t\t\t\t[1] - Full customized
                \t\t\t\t\t\t\t[2] - Full random
                \t\t\t\t\t\t\t[3] - Import from CSV

                """;
    }
    private String menuTwoPrintNoPlayers() {
        return """
                \t\t\t\t\t\tHOW WOULD YOU LIKE TO CREATE YOUR TEAM?
                \t\t\t\t\t\t\t[1] - Full random
                \t\t\t\t\t\t\t[2] - Import from CSV

                """;
    }
    public static void makeItSlow(String arcade, int time) throws InterruptedException {
        for (int i = 0; i < arcade.length(); i++) {
            if (arcade.charAt(i) != '\t') {
                Thread.sleep(time); //better to have in 210 for the final project
                System.out.print(arcade.charAt(i));
            } else
                System.out.print(arcade.charAt(i));
        }
    }

}
