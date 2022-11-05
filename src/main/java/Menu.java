import java.util.Scanner;

public class Menu {
    Lobby lobby = new Lobby();
    //Battlefield battlefield = new Battlefield();
    public void main() throws InterruptedException {
        Scanner input = new Scanner(System.in);

        System.out.println(printTitle());
        System.out.println(menuMessage());
        String gameModeInput = input.nextLine();
        gameMode(Integer.parseInt(gameModeInput));

        System.out.println(teamCreationModeMessage());
        String creationModeInput = input.nextLine();
        lobby.createLobby(Integer.parseInt(creationModeInput), input);
        //lobby.teamCapacity(Integer.parseInt(creationModeInput), input);
        //battlefield.createBattle(lobby);
        input.close();
    }

    private void  gameMode(int n) {
        // Que pasa si es de algun tipo de modo de juego?
        switch (n) {
            case 1:
                System.out.println("PLAYER VS IA");
            case 2:
                System.out.println("PLAYER VS PLAYER");
            case 3:
                System.out.println("IA VS IA");
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
    private String menuMessage() {
        return """
                ----------------
                How would you like to play?
                [1] - Player vs IA
                [2] - Player vs Player
                [3] - IA vs IA
                """;
    }
    private String teamCreationModeMessage() {
        return """
                ----------------
                How would you like to create your team?
                [1] - Full customized
                [2] - Full random
                [3] - Import from CSV
                """;
    }
    public static void makeItSlow(String arcade) throws InterruptedException {
        for (int i = 0; i < arcade.length(); i++) {
            Thread.sleep(50); //better to have in 210 for the final project
            System.out.print(arcade.charAt(i));
        }
    }

}
