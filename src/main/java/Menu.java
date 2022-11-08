import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {
    Lobby lobby = new Lobby();
    //Battlefield battlefield = new Battlefield();
    public void main() throws InterruptedException, FileNotFoundException {

        Scanner input = new Scanner(System.in);

        System.out.print(TerminalTools.CLEAR_SCREEN);

        System.out.println(TerminalTools.ANSI_RED + printTitle());
        System.out.println(TerminalTools.ANSI_RESET + linesSeparationMessage());
        makeItSlow(menuMessage(), 5);
        //System.out.print(TerminalTools.CURSOR_MIDDLE);
        String gameModeInput = input.nextLine();
        gameMode(Integer.parseInt(gameModeInput));
        System.out.print(TerminalTools.CLEAR_SCREEN);
        System.out.println(TerminalTools.ANSI_RED + printTitle() + TerminalTools.ANSI_RESET);
        makeItSlow(teamCreationModeMessage(), 5);
        String creationModeInput = input.nextLine();
        lobby.createLobby(Integer.parseInt(creationModeInput), input);

        //listar los integrantes del equipo
        //lobby.teamCapacity(Integer.parseInt(creationModeInput), input);
        //battlefield.createBattle(lobby);
        input.close();
    }

    private void  gameMode(int n) {
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
    private String printTitle() {
        return """
                  ________            __  __          __     _____                __   ______               ______                  \s
                 /_  __/ /_  ___     / / / /___  ____/ /__  / __(_)___  ___  ____/ /  / ____/_  ____  __   / ____/___ _____ ___  ___\s
                  / / / __ \\/ _ \\   / / / / __ \\/ __  / _ \\/ /_/ / __ \\/ _ \\/ __  /  / / __/ / / / / / /  / / __/ __ `/ __ `__ \\/ _ \\
                 / / / / / /  __/  / /_/ / / / / /_/ /  __/ __/ / / / /  __/ /_/ /  / /_/ / /_/ / /_/ /  / /_/ / /_/ / / / / / /  __/
                /_/ /_/ /_/\\___/   \\____/_/ /_/\\__,_/\\___/_/ /_/_/ /_/\\___/\\__,_/   \\____/\\__,_/\\__, /   \\____/\\__,_/_/ /_/ /_/\\___/\s
                                                                                               /____/                               \s
                """;
    }
    private String linesSeparationMessage() {
        return """
                ======================================================================================================================
                """;
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
