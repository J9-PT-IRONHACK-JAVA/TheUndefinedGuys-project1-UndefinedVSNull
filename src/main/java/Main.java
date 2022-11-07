import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Alfred Testing
        Menu menu = new Menu();
        menu.main();




        ArrayList<Character> team1 = new ArrayList<Character>(List.of(new Warrior(),
                new Warrior(),

                new Warrior(),
                new Wizard()));
        ArrayList<Character> team2 = new ArrayList<Character>(List.of(new Warrior(),
                new Warrior(),
                new Warrior(),
                new Wizard()));


        System.out.println("*****Team1 attacks*****");
        System.out.println("Stats Team1 Character\t\t" );
        System.out.println(team1.get(0));

        System.out.println("*****Team2 defends*****");
        System.out.println("Before the battle");
        System.out.println(team2.get(0));


        //Attack
        team1.get(0).attack(team2.get(0));


        System.out.println("*****Team2 defends*****");
        System.out.println("After the attack");

        System.out.println(team2.get(0));


//        System.out.println(team1.get(0).getHp());

        characterArrayList.get(0).setName("Federico");
        System.out.println(characterArrayList);
        */

    }
}
