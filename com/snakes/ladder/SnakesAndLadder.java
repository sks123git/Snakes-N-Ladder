package com.snakes.ladder;
// JAVA code to implement snake and ladder board game with 2 players.
public class SnakesAndLadder {
public static int[] gameBoard = new int[50];//Declaring game board of 50 houses
public static int pos1=0, pos2=0, end=50; // Positions of player 1 & 2, default game board size is 50
public static int CHANCE=0, rollVal; // By default player 1 chance to roll dice
public static int BITTEN=0, CLIMBED=0; //Declaring bitten times and climbed times as initially 0

//Method for player 1 chance to roll the dice and move forward in array
    public static void playerOne(){
        rollVal = diceRoll();

        
        if(pos1<end) {      // checking if current position of player 1 is less than size of board
            if(pos1==3){
                pos1=gameBoard[3];
                CLIMBED++;
                System.out.println("Player 1 climbed ladder to " + pos1);
            } else if (pos1==22) {
                pos1=gameBoard[22];
                CLIMBED++;
                System.out.println("Player 1 climbed ladder to " + pos1);
            } else if (pos1==33) {
                pos1=gameBoard[33];
                BITTEN++;
                System.out.println("Player 1 bitten by snake and came to " + pos1);
            } else if (pos1==47) {
                pos1=gameBoard[47];
                BITTEN++;
                System.out.println("Player 1 bitten by snake and came to " + pos1);
            } else {

            pos1 += rollVal;
                System.out.println("Player 1 moved to " + pos1);}
        }
        CHANCE=1;  // Now player 2 chance

    }
    //Method for player 2 chance to roll the dice and move forward in array
    public static void playerTwo(){
        rollVal=diceRoll();
        if(pos2<end) {// checking if current position of player 2 is less than size of board
            if (pos2 == 3) {
                pos2 = gameBoard[3];
                CLIMBED++;
                System.out.println("Player 2 climbed ladder to " + pos2);
            } else if (pos2 == 22) {
                pos2 = gameBoard[22];
                CLIMBED++;
                System.out.println("Player 2 climbed ladder to " + pos2);
            } else if (pos2 == 33) {
                pos2 = gameBoard[33];
                BITTEN++;
                System.out.println("Player 2 bitten by snake and came to " + pos2);
            } else if (pos2 == 47) {
                pos2 = gameBoard[47];
                BITTEN++;
                System.out.println("Player 2 bitten by snake and came to " + pos2);
            } else {
                pos2 += rollVal;
                System.out.println("Player 2 moved to " + pos2);
            }
        }        CHANCE=0; // Now player 1 chance

    }
    //Method to roll a dice
    public static int diceRoll(){
        return (int)(Math.random()*6 )+1;
    }

    //Checking win condition
    public static boolean checkWin(int val){
        return val >= end;

    }

    public static void main(String[] args) {
        int j=1;
        boolean isWin;
        for(int i = 0; i < end; i++){
            gameBoard[i] = j;
            j++;
        }
            gameBoard[3] = 20;              //Ladder
            gameBoard[22] = 46;             //Ladder
            gameBoard[33] = 20;             //Snake
            gameBoard[47] = 15;             //Snake

        while(pos1<=end || pos2<=end)
        {
            if(CHANCE==0 ){
                playerOne();
                if (pos1 > end){
                    pos1-=rollVal;
                }
                isWin = checkWin(pos1);
                if(isWin){
                    System.out.println("!!!!!!!!!!!!!!!!!!  Hooray!! Player 1 wins  !!!!!!!!!!!!!!!!!");
                    System.out.println("Player 1 reached at: " + pos1);
                    System.out.println("Player 2 reached at: " + pos2);
                    System.out.println("No of times bitten: " + BITTEN);
                    System.out.println("No of times climbed: " + CLIMBED);
                    return;
                }
                } else {
                playerTwo();
                if (pos2 > end){
                    pos2-=rollVal;
                }
                isWin = checkWin(pos2);
                if(isWin){
                    System.out.println("!!!!!!!!!!!!!!!!   Hooray!!  Player 2 wins   !!!!!!!!!!!!");
                    System.out.println("Player 2 reached at: "+ pos2);
                    System.out.println("Player 1 reached at: "+ pos1);
                    System.out.println("No of times bitten: " + BITTEN);
                    System.out.println("No of times climbed: " + CLIMBED);
                    return;
                }
            }

        }
    }
}
