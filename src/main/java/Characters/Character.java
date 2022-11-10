package Characters;

import net.datafaker.Faker;
import java.util.Arrays;
import java.util.Random;


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
        return "characters.Character{" +
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

    String randomNames() {

        Faker faker = new Faker();

        switch (characterType) {
            case 'a':
                return faker.gameOfThrones().character();
            case 'i':
                return faker.harryPotter().character();
        }
        return "";
    }

}


