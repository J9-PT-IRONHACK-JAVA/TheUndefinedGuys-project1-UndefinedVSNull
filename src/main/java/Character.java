import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public abstract class Character implements Attacker{
    //Variables
    private static int IdSiguiente=0;
    private int id;
    private String name;
    private int hp;
    private boolean isAlive;
    private char characterType;
    private boolean existsArrayOfNames;
    String[] arrayOfNames=new String[172];


    //CONSTRUCTORS
    //FullCustomized
    public Character(String name, int hp) {
        IdSiguiente++;
        id=IdSiguiente;
        setName(name);
        setHp(hp);
        isAlive = true;
    }

    //FullRandom
    public Character() {
        IdSiguiente++;
        id=IdSiguiente;
        isAlive=true;
    }

    //SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        if (hp<=0) {
            this.hp = 0;
            isAlive = false;
        }else {
            this.hp = hp;
        }
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setCharacterType(char characterType) {
        this.characterType = characterType;
    }

    //GETTERS
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public char getCharacterType() {
        return characterType;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", isAlive=" + isAlive +
                ", characterType=" + characterType +
                ", existsArrayOfNames=" + existsArrayOfNames +
                ", arrayOfNames=" + Arrays.toString(arrayOfNames) +
                '}';
    }

    //OTHER METHODS
    int randomParameters(int valueMin, int valueMax){
        Random value= new Random();
        return value.nextInt(valueMin, valueMax+1);
    }
    String randomNames() throws FileNotFoundException {

        if (!existsArrayOfNames) fillArrayOfNames();    //No funciona porque el array se inicializa en cada nuevo instanciación del Character

        return arrayOfNames[(randomParameters(0, arrayOfNames.length-1))];
    }

    void fillArrayOfNames() throws FileNotFoundException {
        int cont=0;
        String[] captureLine=new String[2];

        existsArrayOfNames=true;

        //Instanciamos File y Scanner
        //source file's names https://codebeautify.org/lord-of-the-rings-name-generator
        File file=new File("lord-of-the-rings-name-generator.txt");
        String line;
        Scanner scRead=new Scanner(file);

        while (scRead.hasNext()){
            line= scRead.nextLine();
            captureLine=line.split(",");

            arrayOfNames[cont]=captureLine[0];
            cont++;
        }
        scRead.close();
    }

}
