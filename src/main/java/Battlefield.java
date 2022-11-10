import Characters.Character;

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

        while(checkAllAlive()){


            for(int i= 0 ; i< lobby.getTeamOne().getTeamCharacters().size(); i++){
                System.out.println("It's Team one's turn! Player "+ (i+1)+" "+lobby.getTeamOne().getTeamCharacters().get(i).getName()+" attacking first!");
                System.out.println("Which character is "+lobby.getTeamOne().getTeamCharacters().get(i).getName()+" going to attack? Choose number:");
                for (int j = 0; j < lobby.getTeamOne().getTeamCharacters().size(); j++) {
                    System.out.println(lobby.getTeamOne().getTeamCharacters().get(j).toString());
                }
                Scanner sc = new Scanner(System.in);
                userChoice = sc.nextInt();
                try{
                    defender = lobby.getTeamTwo().getTeamCharacters().get(userChoice-1);
                }
                catch (Exception e){
                    System.out.println("Error of choice? there is noone there?");
                }

                while(lobby.getTeamOne().getTeamCharacters().get(i).isAlive() == true && lobby.getTeamTwo().getTeamCharacters().get(i).isAlive() == true){

                    System.out.println("**********************************");
                    System.out.println("It's "+lobby.getTeamOne().getTeamCharacters().get(i).getName()+"'s turn!");
                    System.out.println("********************************** \n");
                    lobby.getTeamOne().getTeamCharacters().get(i).attack(defender);

                    if(lobby.getTeamTwo().getTeamCharacters().get(userChoice-1).isAlive() == false){
                        System.out.println("//////////////////////////////////");
                        System.out.println("Player "+lobby.getTeamOne().getTeamCharacters().get(i).getName()+ " wins the duel!");
                        System.out.println("////////////////////////////////// \n");
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
                        break;
                    }
                }
            }
        }
    }

    private boolean checkAllAlive(){
        return !getLobby().getTeamOne().checkAllDead() || !getLobby().getTeamTwo().checkAllDead();
    }
}


