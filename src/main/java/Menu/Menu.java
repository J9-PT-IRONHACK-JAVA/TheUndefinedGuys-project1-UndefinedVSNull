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
        beginningGameScreen(input);
        System.out.print(Tools.TerminalTools.CURSOR_MIDDLE);

        String creationModeInput = teamCreationScreen(input);


        Lobby lobby = new Lobby();
        lobby.createLobby(Integer.parseInt(creationModeInput), input);

        battlefieldGameScreen();
        Battlefield battlefield = new Battlefield(lobby);
        battlefield.battle();

        input.close();
    }


    private void beginningGameScreen(Scanner input) throws InterruptedException {
        System.out.print(TerminalTools.CLEAR_SCREEN);
        System.out.println(TerminalTools.ANSI_RED + DrawingASCII.printTitle() + TerminalTools.ANSI_RESET);
        System.out.println(DrawingASCII.linesSeparationMessage());
        makeItSlow(menuMessage(), 5);
        String gameModeInput = input.nextLine();
        gameMode(Integer.parseInt(gameModeInput));
        System.out.print(TerminalTools.CLEAR_SCREEN);
    }
    private String teamCreationScreen(Scanner input) throws InterruptedException {
        System.out.println(TerminalTools.ANSI_RED + DrawingASCII.printTitle() + TerminalTools.ANSI_RESET);
        makeItSlow(teamCreationModeMessage(), 5);
        return input.nextLine();
    }

    private void battlefieldGameScreen() {
        System.out.println(TerminalTools.ANSI_BLUE + DrawingASCII.printBattlefieldTitle() + TerminalTools.ANSI_RESET);
    }
    private void gameMode(int n) {
        // Que pasa si es de algun tipo de modo de juego?
        switch (n) {
            case 1:
                System.out.println("PLAYER VS IA");
                break;
            case 2:
                System.out.println("PLAYER VS PLAYER");
                break;
            case 3:
                System.out.println("IA VS IA");
                break;
        }

    }
    private String menuMessage() {
        return """
                \t\t\t\t\t\tHOW WOULD YOU LIKE TO PLAY?
                \t\t\t\t\t\t\t[1] - 1 PLAYER
                \t\t\t\t\t\t\t[2] - 2 PLAYERS
                \t\t\t\t\t\t\t[3] - NO PLAYER

                """;
    }
    private String teamCreationModeMessage() {
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
