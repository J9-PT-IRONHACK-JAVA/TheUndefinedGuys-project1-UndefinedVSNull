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

        while(checkAllAlive()){
            for(int i= 0 ; i< lobby.getTeamOne().getTeamCharacters().size(); i++){

                System.out.println("Team 1 attacks! Now attacking player number "+ (i+1));
                System.out.println("Which character are you attacking? Choose number");
                Scanner sc = new Scanner(System.in);
                userChoice = sc.nextInt();
                try{
                    defender = lobby.getTeamTwo().getTeamCharacters().get(userChoice-1);
                }
                catch (Exception e){
                    System.out.println();
                }
                System.out.println("Attacking now player number "+userChoice);
                lobby.getTeamOne().getTeamCharacters().get(userChoice).attack(defender);
            }
        }
    }

    private boolean checkAllAlive(){
        return !getLobby().getTeamOne().checkAllDead() || !getLobby().getTeamTwo().checkAllDead();
    }
}




