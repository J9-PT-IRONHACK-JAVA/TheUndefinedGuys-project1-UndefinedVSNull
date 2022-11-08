import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lobby {

    private final Team teamOne = new Team();
    private final Team teamTwo = new Team();

    private final Team[] teams = {teamOne, teamTwo};
    Lobby() {}

    public void createLobby(int creationMode, Scanner input) throws InterruptedException, FileNotFoundException {
        int capacity = teamCapacity(input);
        switch (creationMode) {
            case 1:
                customizedInput(capacity, input);
                break;
            case 2:
                randomInput(capacity);
                break;
            case 3:
                creatingFomCSV();
                break;
        }
    }

    //TODO
    // Code duplicated in switches, needed to be simplified
    private void customizedInput(int capacity, Scanner input) throws InterruptedException {
        for (int i = 0; i < teams.length; i++) {
            System.out.print(TerminalTools.CLEAR_SCREEN);
            presentationMessage(i + 1); //make it as title
            creatingCustomized(teams[i], capacity, input);
        }
    }

    public int teamCapacity(Scanner input) {
        String size;
        System.out.println("\t\t\t\t\tHow many characters would you like on your team?");
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
        System.out.print(TerminalTools.CLEAR_SCREEN);
        switch (type) {
            case "1" -> drawSoldier();
            case "2" -> drawWizard();
        }
        return type;
    }
    private void showCharacters() throws InterruptedException {
        String character = "";
        int i = 1;
        for (CharacterType charType: CharacterType.values()) {
            character += "\t\t\t[%d] - ".formatted(i);
            character += "%s\t\t\t\t".formatted(charType);
            i++;
        }
        Menu.makeItSlow(character + "\n", 50);
        drawCharacters();
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

    public void randomInput(int capacity) throws InterruptedException, FileNotFoundException {
        for (int i = 0; i < teams.length; i++) {
            System.out.print(TerminalTools.CLEAR_SCREEN);
            presentationMessage(i + 1); //make it as title
            teams[i].addCharactersRandom(capacity);
            //teams[i].showStats();
        }
    }
    public void creatingFomCSV() {
        //TODO
    }
    public void presentationMessage(int team) throws InterruptedException {
        // The character has 21 characters
        String teamOne = ("""
                 _       __________    __________  __  _________     _______________    __  ___   ____  _   ________     _________
                | |     / / ____/ /   / ____/ __ \\/  |/  / ____/    /_  __/ ____/   |  /  |/  /  / __ \\/ | / / ____/    /_  __<  /
                | | /| / / __/ / /   / /   / / / / /|_/ / __/        / / / __/ / /| | / /|_/ /  / / / /  |/ / __/        / /  / /\s
                | |/ |/ / /___/ /___/ /___/ /_/ / /  / / /___       / / / /___/ ___ |/ /  / /  / /_/ / /|  / /___       / /  / / \s
                |__/|__/_____/_____/\\____/\\____/_/  /_/_____/      /_/ /_____/_/  |_/_/  /_/   \\____/_/ |_/_____/      /_/  /_/  \s
                                                                                                                                 \s
                """);
        String teamTwo = ("""
                 _       __________    __________  __  _________     _______________    __  ___   _______       ______       _________\s
                | |     / / ____/ /   / ____/ __ \\/  |/  / ____/    /_  __/ ____/   |  /  |/  /  /_  __/ |     / / __ \\     /_  __/__ \\
                | | /| / / __/ / /   / /   / / / / /|_/ / __/        / / / __/ / /| | / /|_/ /    / /  | | /| / / / / /      / /  __/ /
                | |/ |/ / /___/ /___/ /___/ /_/ / /  / / /___       / / / /___/ ___ |/ /  / /    / /   | |/ |/ / /_/ /      / /  / __/\s
                |__/|__/_____/_____/\\____/\\____/_/  /_/_____/      /_/ /_____/_/  |_/_/  /_/    /_/    |__/|__/\\____/      /_/  /____/\s
                                                                                                                                      \s
                """);
        switch (team) {
            case 1 -> Menu.makeItSlow(teamOne, 1);
            case 2 -> Menu.makeItSlow(teamTwo, 1);
        }
    }

    private void drawCharacters() {
        String characters = """
                \t\t\t                              \t\t\t                       ,---.
                \t\t\t                              \t\t\t                       /    |
                \t\t\t      _,.                     \t\t\t                      /     |
                \t\t\t    ,` -.)                    \t\t\t                     /      |
                \t\t\t   ( _/-\\\\-._               \t\t\t                    /       |
                \t\t\t  /,|`--._,-^|            ,   \t\t\t               ___,'        |
                \t\t\t  \\_| |`-._/||          ,'|  \t\t\t             <  -'          :
                \t\t\t    |  `-, / |         /  /   \t\t\t              `-.__..--'``-,_\\_
                \t\t\t    |     || |        /  /    \t\t\t                 |o/ ` :,.)_`>
                \t\t\t     `r-._||/   __   /  /     \t\t\t                 :/ `     ||/)
                \t\t\t __,-<_     )`-/  `./  /      \t\t\t                 (_.).__,-` |\\
                \t\t\t'  \\   `---'   \\   /  /     \t\t\t                 /( `.``   `| :
                \t\t\t    |           |./  /        \t\t\t                 \\'`-.)  `  ; ;
                \t\t\t    /           //  /         \t\t\t                 | `       /-<
                \t\t\t\\_/' \\         |/  /        \t\t\t                 |     `  /   `.
                \t\t\t |    |   _,^-'/  /           \t\t\t ,-_-..____     /|  `    :__..-'\\
                \t\t\t |    , ``  (\\/  /_          \t\t\t/,'-.__\\\\  ``-./ :`      ;       \\
                \t\t\t  \\,.->._    \\X-=/^         \t\t\t`\\ `\\  `\\\\  \\ :  (   `  /  ,   `. \\
                \t\t\t  (  /   `-._//^`             \t\t\t  \\` \\   \\\\   |  | `   :  :     .\\ \\
                \t\t\t   `Y-.____(__}               \t\t\t   \\ `\\_  ))  :  ;     |  |      ): :        
                \t\t\t    |     {__)                \t\t\t  (`-.-'\\ ||  |\\ \\   ` ;  ;       | |
                \t\t\t          ()                  \t\t\t   \\-_   `;;._   ( `  /  /_       | |
                \t\t\t                              \t\t\t    `-.-.// ,'`-._\\__/_,'         ; |
                \t\t\t                              \t\t\t       \\:: :     /     `     ,   /  |
                """;
        System.out.println(characters);
    }
    private void drawSoldier() {
        System.out.println("""
                \t\t\t\t _       _____    ____  ____  ________  ____\s
                \t\t\t\t| |     / /   |  / __ \\/ __ \\/  _/ __ \\/ __ \\
                \t\t\t\t| | /| / / /| | / /_/ / /_/ // // / / / /_/ /
                \t\t\t\t| |/ |/ / ___ |/ _, _/ _, _// // /_/ / _, _/\s
                \t\t\t\t|__/|__/_/  |_/_/ |_/_/ |_/___/\\____/_/ |_| \s
                                                            \s
                \t\t\t\t\t\t  / \\
                \t\t\t\t\t\t  | |
                \t\t\t\t\t\t  |.|
                \t\t\t\t\t\t  |.|
                \t\t\t\t\t\t   |:|      __
                \t\t\t\t\t\t,_|:|_,   /  )
                \t\t\t\t\t\t   (Oo    / _I_
                \t\t\t\t\t\t   +\\ \\  || __|
                \t\t\t\t\t\t      \\ \\||___|
                \t\t\t\t\t\t        \\ /.:.\\-\\
                \t\t\t\t\t\t         |.:. /-----\\
                \t\t\t\t\t\t         |___|::oOo::|
                \t\t\t\t\t\t         /   |:<_T_>:|
                \t\t\t\t\t\t        |_____\\ ::: /
                \t\t\t\t\t\t         | |  \\ \\:/
                \t\t\t\t\t\t         | |   | |
                \t\t\t\t\t\t         \\ /   | \\___
                \t\t\t\t\t\t         / |   \\_____\\
                \t\t\t\t\t\t        `-'
                """);
    }

    private void drawWizard() {
        System.out.println("""
                \t\t\t\t _       ___________   ___    ____  ____\s
                \t\t\t\t| |     / /  _/__  /  /   |  / __ \\/ __ \\
                \t\t\t\t| | /| / // /   / /  / /| | / /_/ / / / /
                \t\t\t\t| |/ |/ // /   / /__/ ___ |/ _, _/ /_/ /\s
                \t\t\t\t|__/|__/___/  /____/_/  |_/_/ |_/_____/ \s
                \t\t\t\t                                        \s
                \t\t\t\t\t                  .
                \t\t\t\t\t                
                \t\t\t\t\t                   .
                \t\t\t\t\t         /^\\     .
                \t\t\t\t\t    /\\   "V"
                \t\t\t\t\t   /__\\   I      O  o
                \t\t\t\t\t  //..\\\\  I     .
                \t\t\t\t\t  \\].`[/  I
                \t\t\t\t\t  /l\\/j\\  (]    .  O
                \t\t\t\t\t /. ~~ ,\\/I          .
                \t\t\t\t\t \\\\L__j^\\/I       o
                \t\t\t\t\t  \\/--v}  I     o   .
                \t\t\t\t\t  |    |  I   _________
                \t\t\t\t\t  |    |  I c(`       ')o
                \t\t\t\t\t  |    l  I   \\.     ,/
                \t\t\t\t\t_/j  L l\\_!  _//^---^\\\\_    -Row
                """);
    }
}
