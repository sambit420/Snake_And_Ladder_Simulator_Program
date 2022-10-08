package usecases;

import java.util.Random;

public class GameOf2Players {
    GameOf2Players()
    {
        System.out.println("Welcome to Snake and Ladder Simulation \n");
    }

    public static void main(String[] args) {
        GameOf2Players a = new GameOf2Players();
        String p1 = "Player1";
        String p2 = "Player2";
        int startingPosition = 0;
        int player1Position = 0;
        int player2Position = 0;
        int winningPosition = 100;
        System.out.println("Starting Position of Both of the Player is : "+startingPosition+"\n");
        int count1 = getCount(p1,player1Position,winningPosition);
        int count2 = getCount(p2,player2Position,winningPosition);

        //Comparing and finding the winner.
        if (count1 > count2)
            System.out.println(p2+" is the winner");
        else if (count2 > count1)
            System.out.println(p1+" is the winner");
        else if (count1 == count1)
            System.out.println("Match Draw");

    }

    public static int getCount(String name, int playerPosition, int winPosition) {
        Random random = new Random();
        int c = 0;

        //Rolling the die unless the Player reaches the winning position.
        do {
            int dieRolls = (random.nextInt(6) + 1);
            c++;
            System.out.printf("The %s rolls the die and gets a number : %d %n%n", name, dieRolls);

            //Checking for option.
            int b = random.nextInt(3);
            playerPosition = playerPosition + dieRolls;
            if (b == 0) {
                System.out.printf("No play - %s stays in the same position %n%n", name);
                System.out.printf("%s current position is : %d %n%n", name, playerPosition);
            } else if (b == 1) {
                playerPosition = playerPosition + dieRolls;
                System.out.printf("%s gets Ladder & Player moves ahead by number of position : %d %n%n", name, dieRolls);
                System.out.printf("%s current position is : %d %n%n", name, playerPosition);
            } else if (b == 2) {
                playerPosition = playerPosition - dieRolls;
                if (playerPosition <= 0) {
                    playerPosition = 0;
                    System.out.printf("Oops Snake bytes!! & %s is Starting from zero %n%n", name);
                    System.out.printf("%s current position is : %d %n%n", name, playerPosition);
                } else {
                    System.out.printf("Oops Snake bytes!! & %s moves behind by number of position : %d %n%n", name, dieRolls);
                    System.out.printf("%s current position is : %d %n%n", name, playerPosition);
                }
            }
            if (playerPosition > winPosition) {
                playerPosition -= dieRolls;
                System.out.printf("Position goes beyond 100.So no play - %s stays in the same position %n%n", name);
                System.out.printf("%s current position is : %d %n%n", name, playerPosition);
                System.out.printf("The number required by the %s is : %d %n%n", name, (winPosition - playerPosition));
            }
        }
        while (playerPosition != winPosition);
        System.out.printf("%s reaches the exact winning position %n%n", name);
        System.out.println("The number of times the dice was rolled is : " + c);
        return c;

    }
}
