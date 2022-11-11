package Menu;

import Battle.Battlefield;
import Tools.DrawingASCII;
import Tools.TerminalTools;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public void main() throws InterruptedException, IOException {
        Scanner input = new Scanner(System.in);

        String menu_one_input = menu_one(input);   //input del user en menu_one
        //System.out.print(Tools.TerminalTools.CURSOR_MIDDLE);
        String menu_two_input = menu_two(input);    //input del user en menu_two
        Lobby lobby = new Lobby();
        lobby.menu_two_choice(Integer.parseInt(menu_two_input), input, menu_one_input);

        battlefieldTitle();
        Battlefield battlefield = new Battlefield(lobby);         //battle
        battlefield.battle(menu_one_input);

        input.close();
    }

    private String menu_one(Scanner input) throws InterruptedException {
        System.out.print(TerminalTools.CLEAR_SCREEN);
        System.out.println(TerminalTools.ANSI_RED + DrawingASCII.printTitle() + TerminalTools.ANSI_RESET);
        System.out.println(TerminalTools.ANSI_RESET + DrawingASCII.linesSeparationMessage());

        makeItSlow(menu_one_print(), 5);
        String menu_one_input = input.nextLine();
        menu_one_choice(Integer.parseInt(menu_one_input));
        System.out.print(TerminalTools.CLEAR_SCREEN);

       return menu_one_input;
    }

    private String menu_two(Scanner input) throws InterruptedException {
        System.out.println(TerminalTools.ANSI_RED + DrawingASCII.printTitle() + TerminalTools.ANSI_RESET);
        makeItSlow(menu_two_print(), 5);
        return input.nextLine();
    }

    private void battlefieldTitle() {
        System.out.println(TerminalTools.ANSI_BLUE + DrawingASCII.printBattlefieldTitle() + TerminalTools.ANSI_RESET);
    }

    private void menu_one_choice(int n) {
        /* Que pasa si es de algun tipo de modo de juego? */
        switch (n) {
            case 1 -> System.out.println("PLAYER VS IA");
            case 2 -> System.out.println("PLAYER VS PLAYER");
            case 3 -> System.out.println("IA VS IA");
        }

    }

    private String menu_one_print() {
        return """
                \t\t\t\t\t\tHOW WOULD YOU LIKE TO PLAY?
                \t\t\t\t\t\t\t[1] - 1 PLAYER
                \t\t\t\t\t\t\t[2] - 2 PLAYERS
                \t\t\t\t\t\t\t[3] - NO PLAYER

                """;
    }
    private String menu_two_print() {
        return """
                \t\t\t\t\t\tHOW WOULD YOU LIKE TO CREATE YOUR TEAM?
                \t\t\t\t\t\t\t[1] - Full customized
                \t\t\t\t\t\t\t[2] - Full random
                \t\t\t\t\t\t\t[3] - Import from CSV

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
