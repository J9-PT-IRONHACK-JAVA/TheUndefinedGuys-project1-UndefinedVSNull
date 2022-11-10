package Battle;

import Characters.Character;
import Menu.Lobby;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Battlefield {


    private Lobby lobby;

    //contructor
    public Battlefield(Lobby lobby) {
        this.lobby = lobby;
    }

    public Lobby getLobby() {
        return lobby;
    }

    public void setLobby(Lobby lobby) {
        this.lobby = lobby;
    }

    public void battle(){

        int userChoice;
        Character defender = null;
        Character attacker = null;
        ArrayList<Character> graveyard = new ArrayList<>();

        while(checkTeamOneAlive() == true && checkTeamTwoAlive() == true){  //Duel team1 vs team2

            for(int i= 0 ; i< lobby.getTeamOne().getTeamCharacters().size(); i++){

                if(lobby.getTeamOne().getTeamCharacters().get(i).isAlive()==false){
                    System.out.println("Player number "+(i+1)+" can't play, he's dead! \n");
                    continue;
                }

                System.out.println("It's Team one's turn! Player "+ (i+1)+" "+lobby.getTeamOne().getTeamCharacters().get(i).getName()+" attacking first!");
                System.out.println("Which character is " + lobby.getTeamOne().getTeamCharacters().get(i).getName()+" going to attack? Choose number:");

                for (int j = 0; j < lobby.getTeamTwo().getTeamCharacters().size(); j++) {
                    if(lobby.getTeamTwo().getTeamCharacters().get(j).isAlive()==true){
                        System.out.println((j+1)+" "+ lobby.getTeamTwo().getTeamCharacters().get(j).toString());
                    }
                }
                Scanner sc = new Scanner(System.in);
                userChoice = sc.nextInt();
                try{
                    defender = lobby.getTeamTwo().getTeamCharacters().get(userChoice-1);
                }
                catch (Exception e){
                    System.out.println("Error of choice? there is noone there?");
                }
                    //i=1
                while(lobby.getTeamOne().getTeamCharacters().get(i).isAlive() == true && lobby.getTeamTwo().checkAllDead() == false){ //Duel 1v1

                    System.out.println("Repetimos el while 1v1!");

                    System.out.println("**********************************");
                    System.out.println("It's "+lobby.getTeamOne().getTeamCharacters().get(i).getName()+"'s turn!");
                    System.out.println("********************************** \n");
                    lobby.getTeamOne().getTeamCharacters().get(i).attack(defender);

                    if(lobby.getTeamTwo().getTeamCharacters().get(userChoice-1).isAlive() == false){
                        System.out.println("//////////////////////////////////");
                        System.out.println("Player "+lobby.getTeamOne().getTeamCharacters().get(i).getName()+ " wins the duel!");
                        System.out.println("////////////////////////////////// \n");
                        graveyard.add(getLobby().getTeamTwo().getTeamCharacters().get(userChoice-1));
                        System.out.println("+ + + + Graveyard + + + +\n");
                        System.out.println(graveyard.toString());
                        System.out.println("+ + + + + + + + + + + + +\n");
                        break;
                    }

                    attacker = lobby.getTeamOne().getTeamCharacters().get(i);
                    System.out.println("**********************************");
                    System.out.println(lobby.getTeamTwo().getTeamCharacters().get(userChoice-1).getName() + " is now CounterAttacking! Watch out!");
                    System.out.println("********************************** \n");
                    lobby.getTeamTwo().getTeamCharacters().get(userChoice-1).attack(attacker);

                    if(lobby.getTeamOne().getTeamCharacters().get(i).isAlive() == false){
                        System.out.println("//////////////////////////////////");
                        System.out.println("Player "+lobby.getTeamTwo().getTeamCharacters().get(userChoice-1).getName()+ " wins the duel!");
                        System.out.println("////////////////////////////////// \n");
                        graveyard.add(getLobby().getTeamOne().getTeamCharacters().get(i));
                        System.out.println("+ + + + Graveyard + + + +\n");
                        System.out.println(graveyard.toString());
                        System.out.println("+ + + + + + + + + + + + +\n");
                        break;
                    }
                }
            }
        }

        if(checkTeamOneAlive() == false && checkTeamTwoAlive() == true){
            System.out.println("Team Two wins!!!");
        }

        if(checkTeamOneAlive() == true && checkTeamTwoAlive() == false){
            System.out.println("Team One wins!!!");
        }

        if(checkTeamOneAlive() == false && checkTeamTwoAlive() == false){
            System.out.println("It's a tie!!!");
        }
    }

    private boolean checkTeamOneAlive(){
        if (lobby.getTeamOne().checkAllDead()== true){
            return false;
        }
        return true;
    }

    private boolean checkTeamTwoAlive(){
        if (lobby.getTeamTwo().checkAllDead()== true){
            return false;
        }
        return true;
    }
}


