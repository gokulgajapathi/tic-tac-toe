import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
        char player = 'X';
        boolean gameOver = false;

        Scanner sc = new Scanner(System.in);

        while(!gameOver){
            printBoard(board);
            System.out.print("Player "+ player +" enter [row][col]: ");
            int input = sc.nextInt();
            int row = input/10;
            int col = input%10;

            if (3>row && -1<row && -1<col && 3>col){
                if(board[row][col]==' ' ){
                    board[row][col] = player;//place element
                    gameOver = haveWon(board,player);
                    if(gameOver){
                        System.out.println("Player "+ player+" has won! ");
                    } else {
                        player = player == 'X' ? 'O':'X';
                    }
                } else{
                    System.out.println("Invalid move. Try again!");
                }
            }else {
                System.out.println("Invalid input. Try again!");
            }
        }
        printBoard(board);
    }

    private static boolean haveWon(char[][] board, char player) {
        //check row
        for (int row = 0; row < board.length; row++) {
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }

        //check col
        for (int col = 0; col < board.length; col++) {
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }

        //check diagonal
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        return board[0][2] == player && board[1][1] == player && board[2][0] == player;
    }

    private static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}