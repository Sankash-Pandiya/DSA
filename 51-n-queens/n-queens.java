class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> board = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            List<String> row = new ArrayList<>();
            for(int j = 0; j < n; j++) row.add(".");
            board.add(row);
        }

        helper(board, 0, n, ans);

        return ans;
    }
    private void helper(List<List<String>> board, int i, int n, List<List<String>> ans) {
        if(i == n) {
            List<String> sol = new ArrayList<>();
            for(List<String> row : board) {
                sol.add(String.join("", row));
            }
            ans.add(sol);
            return;
        }
        for(int j = 0; j < n; j++) {
            if(isSafe(board, i, j, n)) {
                board.get(i).set(j, "Q");
                helper(board, i + 1, n, ans);
                board.get(i).set(j, ".");
            }
        }
    }

    private boolean isSafe(List<List<String>> board, int i, int j, int n) {
        // Check Up
        int row = i - 1;
        while(row >= 0) {
            if(board.get(row).get(j).equals("Q")) return false;
            row--;
        }
        // Check left diagonal
        row = i - 1;
        int col = j - 1;
        while(row >= 0 && col >= 0) {
            if(board.get(row).get(col).equals("Q")) return false;
            row--;
            col--;
        }
        // Check right diagonal
        row = i - 1;
        col = j + 1;
        while(row >= 0 && col < n) {
            if(board.get(row).get(col).equals("Q")) return false;
            row--;
            col++;
        }
        return true;
    }
}