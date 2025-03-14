class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') { // Empty cell found
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c; // Place number

                            if (solve(board)) return true; // Recursively solve next cells
                            board[i][j] = '.'; // Backtrack if solution is invalid
                        }
                    }
                    return false; // No valid number found, backtrack
                }
            }
        }
        return true; // Solution found
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false; // Check column
            if (board[row][i] == c) return false; // Check row
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; // Check 3x3 box
        }
        return true; // Valid placement
    }
}
