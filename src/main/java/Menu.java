import java.util.Scanner;

public class Menu {
    Lobby lobby;

    public void main() {
        String title = """
                  ________            __  __          __     _____                __   ______               ______                  \s
                 /_  __/ /_  ___     / / / /___  ____/ /__  / __(_)___  ___  ____/ /  / ____/_  ____  __   / ____/___ _____ ___  ___\s
                  / / / __ \\/ _ \\   / / / / __ \\/ __  / _ \\/ /_/ / __ \\/ _ \\/ __  /  / / __/ / / / / / /  / / __/ __ `/ __ `__ \\/ _ \\
                 / / / / / /  __/  / /_/ / / / / /_/ /  __/ __/ / / / /  __/ /_/ /  / /_/ / /_/ / /_/ /  / /_/ / /_/ / / / / / /  __/
                /_/ /_/ /_/\\___/   \\____/_/ /_/\\__,_/\\___/_/ /_/_/ /_/\\___/\\__,_/   \\____/\\__,_/\\__, /   \\____/\\__,_/_/ /_/ /_/\\___/\s
                                                                                               /____/                               \s
                """;
        Scanner input = new Scanner(System.in);
        String menuMessage = """
                ----------------
                How would you like to play?
                [1] - Player vs IA
                [2] - Player vs Player
                [3] - IA vs IA
                """;

                //--------------formatted-------------();
        // Segun lo que ponga --> 1

        String teamCreationMode = """
                ----------------
                How would you like to create your team?
                [1] - Full customized
                [2] - Full random
                [3] - Import from CSV
                """;
    }

    public static void makeItSlow(String arcade) throws InterruptedException {
        for (int i = 0; i < arcade.length(); i++) {
            Thread.sleep(250);
            System.out.print(arcade.charAt(i));
        }
    }

}
