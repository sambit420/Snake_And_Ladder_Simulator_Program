package useCases;

import java.util.Random;

public class RepeatTillThePlayerReachesTheExactWinningPosition {
    RepeatTillThePlayerReachesTheExactWinningPosition()
    {
        System.out.println("Welcome to Snake and Ladder Simulation \n");
    }

    public static void main(String[] args) {
        RepeatTillThePlayerReachesTheExactWinningPosition a = new RepeatTillThePlayerReachesTheExactWinningPosition();
        int startingPosition = 0;
        int playerPosition = 0;
        int winningPosition = 100;
        Random random = new Random();
        System.out.println("Starting Position of the Single Player is : "+startingPosition+"\n");

        //Rolling the die unless the Player reaches the winning position.
        do  {
            int dieRolls1 = (random.nextInt(6) + 1);
            System.out.println("The Player rolls the die and gets a number : " + dieRolls1 + "\n");

            //Checking for option.
            int b = random.nextInt(3);
            playerPosition = playerPosition + dieRolls1;
            if (b == 0) {
                System.out.println("No play - Player stays in the same position \n");
                System.out.println("Player current position is : " + playerPosition + "\n");
            } else if (b == 1) {
                playerPosition = playerPosition + dieRolls1;
                System.out.println("Player gets Ladder & Player moves ahead by number of position : " + dieRolls1 + "\n");
                System.out.println("Player current position is : " + playerPosition + "\n");
            } else if (b == 2) {
                playerPosition = playerPosition - dieRolls1;
                if (playerPosition <= 0) {
                    playerPosition = 0;
                    System.out.println("Oops Snake bytes!! & Player is Starting from zero");
                    System.out.println("Player current position is : " + playerPosition + "\n");
                } else {
                    System.out.println("Oops Snake bytes!! & Player moves behind by number of position : " + dieRolls1 + "\n");
                    System.out.println("Player current position is : " + playerPosition + "\n");
                }
            }
            if (playerPosition > winningPosition)
            {
                playerPosition -= dieRolls1;
                System.out.println("Position goes beyond 100.\nSo no play - Player stays in the same position \n");
                System.out.println("Player current position is : " + playerPosition + "\n");
                System.out.println("The number required by the player is : "+(winningPosition-playerPosition)+"\n");
            }
        }
        while(playerPosition != winningPosition);
        System.out.println("Player reaches the exact winning position");
    }
}
