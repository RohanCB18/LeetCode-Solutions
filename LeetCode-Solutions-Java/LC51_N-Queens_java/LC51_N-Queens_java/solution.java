import java.util.*;

class Solution {
    // Solves the N-Queens problem and returns all possible board configurations
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Initialize board with '.' to represent empty spaces
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        // Start backtracking from column 0
        helper(board, allBoards, 0);
        return allBoards;
    }
    
    // Recursive helper function to place queens column by column
    private void helper(char[][] board, List<List<String>> allBoards, int col) {
        // Base case: If all columns are filled, save the board configuration
        if (col == board.length) {
            saveBoard(board, allBoards);
            return;
        }
        
        // Try placing a queen in each row of the current column
        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                helper(board, allBoards, col + 1);
                board[row][col] = '.'; // Backtrack and remove queen
            }
        }
    }
    
    // Function to check if placing a queen at (row, col) is safe
    private boolean isSafe(int row, int col, char[][] board) {
        // Check row for existing queens
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == 'Q') return false;
        }
        
        // Check column for existing queens
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') return false;
        }
        
        // Check upper-left diagonal
        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') return false;
        }
        
        // Check upper-right diagonal
        for (int r = row, c = col; r >= 0 && c < board.length; r--, c++) {
            if (board[r][c] == 'Q') return false;
        }
        
        // Check lower-left diagonal
        for (int r = row, c = col; r < board.length && c >= 0; r++, c--) {
            if (board[r][c] == 'Q') return false;
        }
        
        // Check lower-right diagonal
        for (int r = row, c = col; r < board.length && c < board.length; r++, c++) {
            if (board[r][c] == 'Q') return false;
        }
        
        return true; // Safe to place queen
    }
    
    // Function to convert board configuration into a list of strings and store it
    private void saveBoard(char[][] board, List<List<String>> allBoards) {
        List<String> newBoard = new ArrayList<>();
        for (char[] row : board) {
            newBoard.add(new String(row));
        }
        allBoards.add(newBoard);
    }
}
