class Solution {
    public boolean exist(char[][] board, String word) {
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                boolean cur = doDFS(board, word, i, j, 0);
                if(cur) return true;
            }
        }
        return false;
    }
    private boolean doDFS(char[][] board, String word, int row, int col, int depth){
        if(depth == word.length()) return true;

        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length){
            return false;
        }

        if(board[row][col] != word.charAt(depth)) return false;

        char c = board[row][col];
        board[row][col] = '-';
        boolean truth = doDFS(board, word, row + 1, col, depth + 1) ||
        doDFS(board, word, row - 1, col, depth + 1) ||
        doDFS(board, word, row, col + 1, depth + 1) ||
        doDFS(board, word, row, col - 1, depth + 1);

        board[row][col] = c;
        return truth;
    }
}