package useCases;

import java.util.Random;

public class RollingTheDieToGetANumber {
    RollingTheDieToGetANumber()
    {
        System.out.println("Welcome to Snake and Ladder Simulation \n");
    }

    public static void main(String[] args) {
        RollingTheDieToGetANumber a = new RollingTheDieToGetANumber();
        Random random = new Random();
        int startingPosition = 0;
        System.out.println("Starting Position of the Single Player is : "+startingPosition+"\n");

        //Rolling the die.
        int dieRolls = (random.nextInt(6)+1);
        System.out.println("The Player rolls the die and gets a number : "+dieRolls);
    }
}
