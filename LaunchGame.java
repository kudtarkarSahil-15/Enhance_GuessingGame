package Ass2;

/**
 * ---- Feature what I add to enhance this game ... ----
 * To generate a Random Number I used a Random Class in java (java.util package)
 * Validating an integer value -> (if user enter other than int value return a fn back)
 * Recognize a Players with their respective number
 * Allocated a points to players -> won: 4-pts & tied: 2-pts & loss: 0-pts
 * Ask the user to take a control of quiting a game or not...(by saying true or false)
 * Getting a ScoreCard of a players after each Round
 * knowing a leading position of a players
 * Getting a winner after the game ends
 *
 */

import java.util.Random;
import java.util.Scanner;

class RandomNumber
{
    int randNum;
    public int generateRandNum() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a Range to Generate a Random Number: 0 to ");
        boolean isIntValue = in.hasNextInt();
        if(!isIntValue) {
            System.out.println("--> Enter Integer Value Only ...!!");
            return generateRandNum();
        }
        int n = in.nextInt();
//    generate a random number
        Random random = new Random();
        randNum = random.nextInt(n +1);
        return randNum;
    }
}

class Players
{
    int playerGuessNum;
    public int getPlayerGuessNum(int plyrNum) {
        Scanner in = new Scanner(System.in);
        System.out.println("Player-" +plyrNum + " Guess a Number: ");

        boolean isIntValue = in.hasNextInt();
        if (!isIntValue) {
            System.out.println("Player-" +plyrNum + " --> Enter Integer Value Only ...!!");
            return getPlayerGuessNum(plyrNum);
        }
        playerGuessNum = in.nextInt();
        return playerGuessNum;
    }
}

class Umpire
{
//    fields
    int numFromRandGenerator, numFromPlayer1, numFromPlayer2, numFromPlayer3, numFromPlayer4;

//    player Scores
    int p1Score, p2Score, p3Score, p4Score;

//score points allocated...
    int wonScore = 4, tiedScore = 2;

//    getting a random number generated a value
    public void getNumFromRandGenerator() {
        RandomNumber randNumber = new RandomNumber();
        numFromRandGenerator = randNumber.generateRandNum();
    }

    public void compareData(int round) {

        int i=1;

            Players plyr1 = new Players();
            Players plyr2 = new Players();
            Players plyr3 = new Players();
            Players plyr4 = new Players();

            numFromPlayer1 = plyr1.getPlayerGuessNum(i++);
            numFromPlayer2 = plyr2.getPlayerGuessNum(i++);
            numFromPlayer3 = plyr3.getPlayerGuessNum(i++);
            numFromPlayer4 = plyr4.getPlayerGuessNum(i);

        System.out.println("Generated --> Random Number is  " +numFromRandGenerator);
//            comparing a data
            if(numFromRandGenerator == numFromPlayer1) {
                if(numFromPlayer1 == numFromPlayer2 && numFromPlayer1 == numFromPlayer3 && numFromPlayer1 == numFromPlayer4) {
                    p1Score += tiedScore;
                    p2Score += tiedScore;
                    p3Score += tiedScore;
                    p4Score += tiedScore;
                    System.out.println("Game Tied");
                } else if (numFromPlayer1 == numFromPlayer2 && numFromPlayer1 == numFromPlayer3){
                    p1Score += tiedScore;
                    p2Score += tiedScore;
                    p3Score += tiedScore;
                    System.out.println("Player1, Player2 and Player3 - guess correctly..");
                } else if (numFromPlayer1 == numFromPlayer3 && numFromPlayer1 == numFromPlayer4) {
                    p1Score += tiedScore;
                    p3Score += tiedScore;
                    p4Score += tiedScore;
                    System.out.println("Player1, Player3 and Player4 - guess correctly..");
                } else if (numFromPlayer1 == numFromPlayer2 && numFromPlayer1 == numFromPlayer4) {
                    p1Score += tiedScore;
                    p2Score += tiedScore;
                    p4Score += tiedScore;
                    System.out.println("Player1 and Player3 - guess correctly..");
                } else if (numFromPlayer1 == numFromPlayer2) {
                    p1Score += tiedScore;
                    p2Score += tiedScore;
                    System.out.println("Player1 and Player2 - guess correctly..");
                } else if (numFromPlayer1 == numFromPlayer3) {
                    p1Score += tiedScore;
                    p3Score += tiedScore;
                    System.out.println("Player1 and Player3 - guess correctly..");
                } else if (numFromPlayer1 == numFromPlayer4) {
                    p1Score += tiedScore;
                    p4Score += tiedScore;
                    System.out.println("Player1 and Player4 - guess correctly..");
                } else {
                    p1Score += wonScore;
                    System.out.println("Player1 - guess correctly..");
                }
            }
            else if(numFromRandGenerator == numFromPlayer2) {
                if (numFromPlayer2 == numFromPlayer3 && numFromPlayer2 == numFromPlayer4) {
                    p2Score += tiedScore;
                    p3Score += tiedScore;
                    p4Score += tiedScore;
                    System.out.println("Game Tied Between Player2, Player3 and Player4..");
                } else if (numFromPlayer2 == numFromPlayer3) {
                    p2Score += tiedScore;
                    p3Score += tiedScore;
                    System.out.println("Player2 and Player3 - guess correctly..");
                } else if (numFromPlayer2 == numFromPlayer4) {
                    p2Score += tiedScore;
                    p4Score += tiedScore;
                    System.out.println("Player2 and Player4 - guess correctly..");
                } else {
                    p2Score += wonScore;
                    System.out.println("Player2 - guess correctly..");
                }
            }
            else if(numFromRandGenerator == numFromPlayer3) {
                if(numFromPlayer3 == numFromPlayer4) {
                    p3Score += tiedScore;
                    p4Score += tiedScore;
                    System.out.println("Player3 and Player4 - guess correctly..");
                } else {
                    p3Score += wonScore;
                    System.out.println("Player3 - guess correctly..");
                }
            }
            else if(numFromRandGenerator == numFromPlayer4) {
                p4Score += wonScore;
                System.out.println("Player4 - guess correctly..");
            }
            else {
                System.out.println("None of Player guess correctly..");
            }

        System.out.println("\n====================== Score Card Display : After Round " +round + " " +
                "============================");
//            Scorecard of a players
        ScoreCard scoreCard = new ScoreCard();
        scoreCard.getScoreCard(p1Score, p2Score, p3Score, p4Score);
    }

}

class ScoreCard
{
    public void getScoreCard(int p1Score, int p2Score, int p3Score, int p4Score) {
        System.out.println("Player1 : " +p1Score);
        System.out.println("Player2 : " +p2Score);
        System.out.println("Player3 : " +p3Score);
        System.out.println("Player4 : " +p4Score);
        System.out.println("========================================================================================");
    }
}

class MaxPlayerScore
{
    public String getMaxPlayerScore(int maxPlyr1Scr, int maxPlyr2Scr, int maxPlyr3Scr, int maxPlyr4Scr) {
        if (maxPlyr1Scr == maxPlyr2Scr && maxPlyr3Scr == maxPlyr4Scr) {
            return "Game Tied";
        } else if ((maxPlyr1Scr >= maxPlyr4Scr) && (maxPlyr1Scr == maxPlyr2Scr && maxPlyr1Scr == maxPlyr3Scr)) {
            return "Game Tied Between --> Player-1, Player2 and Player-3";
        } else if ((maxPlyr1Scr >= maxPlyr3Scr) && (maxPlyr1Scr == maxPlyr2Scr && maxPlyr1Scr == maxPlyr4Scr)) {
            return "Game Tied Between --> Player-1, Player2 and Player-4";
        } else if ((maxPlyr1Scr >= maxPlyr2Scr) && (maxPlyr1Scr == maxPlyr3Scr && maxPlyr1Scr == maxPlyr4Scr)) {
            return "Game Tied Between --> Player-1, Player3 and Player-4";
        } else if ((maxPlyr2Scr >= maxPlyr1Scr) && (maxPlyr2Scr == maxPlyr3Scr && maxPlyr2Scr == maxPlyr4Scr)) {
            return "Game Tied Between --> Player-2, Player3 and Player-4";
        } else if ((maxPlyr1Scr >= maxPlyr3Scr && maxPlyr1Scr >= maxPlyr4Scr) && (maxPlyr1Scr == maxPlyr2Scr)) {
            return "Player-1 and Player-2";
        } else if ((maxPlyr1Scr >= maxPlyr2Scr && maxPlyr1Scr >= maxPlyr4Scr) && (maxPlyr1Scr == maxPlyr3Scr)) {
            return "Player-1 and Player-3";
        } else if ((maxPlyr1Scr >= maxPlyr2Scr && maxPlyr1Scr >= maxPlyr3Scr) && (maxPlyr1Scr == maxPlyr4Scr)) {
            return "Player-1 and Player-4";
        } else if (maxPlyr2Scr >= maxPlyr1Scr && maxPlyr2Scr >= maxPlyr4Scr && maxPlyr2Scr == maxPlyr3Scr) {
            return "Player-2 and Player-3";
        } else if (maxPlyr2Scr >= maxPlyr1Scr && maxPlyr2Scr >= maxPlyr3Scr && maxPlyr2Scr == maxPlyr4Scr) {
            return "Player-2 and Player-4";
        } else if (maxPlyr3Scr >= maxPlyr1Scr && maxPlyr3Scr >= maxPlyr2Scr && maxPlyr3Scr == maxPlyr4Scr) {
            return "Player-3 and Player-4";
        } else {
            if (maxPlyr1Scr>=maxPlyr2Scr && maxPlyr1Scr>maxPlyr3Scr && maxPlyr1Scr>maxPlyr4Scr) {
                return "Player-1";
            } else if (maxPlyr2Scr>=maxPlyr1Scr && maxPlyr2Scr>=maxPlyr3Scr && maxPlyr2Scr>=maxPlyr4Scr) {
                return "Player-2";
            } else if (maxPlyr3Scr>=maxPlyr1Scr && maxPlyr3Scr>=maxPlyr2Scr && maxPlyr3Scr>=maxPlyr4Scr) {
                return "Player-3";
            } else {
                return "Player-4";
            }
        }


    }
}


public class LaunchGame {
    public static void main(String[] args) {
        System.out.println("************************** G-U-E-S-S -A- N-U-M-B-E-R ************************************");
        System.out.println("\n -> This Game Plays Between Four Players \n" +
                           " -> Enter A Max Range To Generate A Random Number \n" +
                           " -> Each Player Need To Guess A Number When Turns Come \n" +
                           " -> Points Assigned : Won: 4pts, Tied: 2pts, Loss: 0pts \n" +
                           " -> After Each Round ScoreCard Will Be Generated \n" +
                           " -> After Quiting Game : Winner Will Be Declared \n" +
                           " -> To Quit A Game (typed --> false) \n");
//         System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("\n=========================================================================================");
        Scanner in = new Scanner(System.in);
        Umpire umpire = new Umpire();
        boolean toContinue= true;
        int i=0;
        while(toContinue)
        {
            i++;
            umpire.getNumFromRandGenerator();
            umpire.compareData(i);
            System.out.println("Continue to play the game? - give Answer in true OR false");
            toContinue = in.nextBoolean();
        }

        System.out.println("\n================================ Final ScoreCard  " +
                "=======================================");
        ScoreCard finalScoreCard = new ScoreCard();
        finalScoreCard.getScoreCard(umpire.p1Score, umpire.p2Score, umpire.p3Score, umpire.p4Score);

//        getting the winner through maxScore
        String maxScorePlayer;
        MaxPlayerScore winner = new MaxPlayerScore();
        maxScorePlayer  = winner.getMaxPlayerScore(umpire.p1Score, umpire.p2Score, umpire.p3Score, umpire.p4Score);
        System.out.println("\t\t\t\t\t\t\t\t WINNER OF THE GAME " + "\n" +
                "==========================================================================================\n" +
                "Winner of the Guessing Game : " +maxScorePlayer + "\n" +
                "==========================================================================================\n");
    }
}
