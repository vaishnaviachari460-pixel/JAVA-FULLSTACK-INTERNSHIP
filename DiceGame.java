package com.mycompany.dicegame;
//
//import java.util.*;
//
//public class DiceGame {
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        Random random = new Random();
//
//        System.out.println("Press Enter to roll dice...");
//        sc.nextLine();
//
//        int userDice = random.nextInt(6) + 1;
//        int computerDice = random.nextInt(6) + 1;
//
//        System.out.println("You rolled: " + userDice);
//        System.out.println("Computer rolled: " + computerDice);
//
//        if (userDice > computerDice)
//            System.out.println("🎉 You Win!");
//        else if (userDice < computerDice)
//            System.out.println("😢 You Lose!");
//        else
//            System.out.println("It's a Draw!");
//
//        sc.close();
//    }
//}








//import java.util.*;
//
//public class DiceGame {
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        Random random = new Random();
//
//        String[] choices = {"Rock", "Paper", "Scissors"};
//
//        System.out.print("Enter Rock, Paper, or Scissors: ");
//        String user = sc.nextLine();
//
//        String computer = choices[random.nextInt(3)];
//        System.out.println("Computer chose: " + computer);
//
//        if (user.equalsIgnoreCase(computer)) {
//            System.out.println("It's a Draw!");
//        }
//        else if ((user.equalsIgnoreCase("Rock") && computer.equals("Scissors")) ||
//                 (user.equalsIgnoreCase("Paper") && computer.equals("Rock")) ||
//                 (user.equalsIgnoreCase("Scissors") && computer.equals("Paper"))) {
//            System.out.println("🎉 You Win!");
//        }
//        else {
//            System.out.println("😢 You Lose!");
//        }
//
//        sc.close();
//    }
//}




//TIC TAC TOE
import java.util.*;

public class DiceGame {
    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    static void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("--+---+--");
        }
    }

    static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player))
                return true;
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char player = 'X';

        for (int turn = 0; turn < 9; turn++) {
            printBoard();
            System.out.println("Player " + player + " enter row and column (0-2): ");
            int r = sc.nextInt();
            int c = sc.nextInt();

            if (board[r][c] == ' ') {
                board[r][c] = player;
                if (checkWin(player)) {
                    printBoard();
                    System.out.println("🎉 Player " + player + " Wins!");
                    return;
                }
                player = (player == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid Move!");
                turn--;
            }
        }

        System.out.println("Game Draw!");
        sc.close();
    }
}