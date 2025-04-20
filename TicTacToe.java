import java.util.Scanner;
public class TicTacToe {
    public static void main(String[] args) {
        Scanner programScanner = new Scanner(System.in);

        String[][] board = {{".",".","."}, 
                            {".",".","."}, 
                            {".",".","."}};

        boolean isGoingOn = true;
        int turnCounter = 0;

        while (isGoingOn) {
            System.out.println("\n");
            for (int i = 0; i < board.length; i++) {
                String currentLine = "";
                for (int j = 0; j < board[0].length; j++) {
                    currentLine = currentLine + board[i][j];
                }
                System.out.println(currentLine);
            }

            int dotCounter = 0;
            for (String[] row:board) {
                for (String item:row) {
                    if (item == ".") {
                        dotCounter = dotCounter + 1;
                    }
                }

            }

            if (dotCounter == 0) {
                System.out.println("\nNo one has won.");
                isGoingOn = false;
                return;
            }


            int player_number = turnCounter % 2 + 1;

            System.out.println("\nPlayer " + player_number + ", enter your intended row (1-3): ");
            int rowNum = programScanner.nextInt();

            System.out.println("\nPlayer " + player_number + ", enter your intended column (1-3): ");
            int columnNum = programScanner.nextInt();

            if (rowNum < 1 || rowNum > 3 || columnNum < 1 || columnNum > 3) {
                System.out.println("\nInvalid row number or column number.");
                continue;
            } else if (board[rowNum - 1][columnNum - 1] != ".") {
                System.out.println("\nThat spot is taken.");
                continue;
            } else {
                if (turnCounter % 2 == 0) {
                    board[rowNum-1][columnNum-1] = "O";
                } else if (turnCounter % 2 == 1) {
                    board[rowNum-1][columnNum-1] = "X";
                }

                // Check horizontal lines
                for (String[] row:board) {
                    if (row[0] == row[1] && row[1] == row[2] && row[0] != "." && row[1] != "." && row[2] != ".") {
                        System.out.println("\nPlayer " + player_number + " has won!");
                        isGoingOn = false;
                        return;
                    }
                }

                // Check vertical lines
                for (int k = 0; k < 3; k++) {
                    if (board[0][k] == board[1][k] && board[1][k] == board[2][k] && board[0][k] != "." && board[1][k] != "." && board[2][k] != ".") {
                        System.out.println("\nPlayer " + player_number + " has won!");
                        isGoingOn = false;
                        return;
                    }
                }

                // Check diagonals
                if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != "." && board[1][1] != "." && board[2][2] != ".") {
                    System.out.println("\nPlayer " + player_number + " has won!");
                    isGoingOn = false;
                    return;
                }

                if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != "." && board[1][1] != "." && board[0][2] != ".") {
                    System.out.println("\nPlayer " + player_number + " has won!");
                    isGoingOn = false;
                    return;
                }


                turnCounter = turnCounter + 1;
            }
        }
    }
    
}
