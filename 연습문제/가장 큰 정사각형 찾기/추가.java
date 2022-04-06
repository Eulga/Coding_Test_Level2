class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if(board[i][j] == 0) continue;
                board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
                answer = Math.max(answer, board[i][j]);
            }
        }
        
        if(answer == 0) return checkBoardAllZero(board);
        
        return answer * answer;
    }
    
    public int checkBoardAllZero(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int k = 0; k < board.length; k++) {
                if(board[i][k] == 1) return 1;
            }   
        }
        return 0;
    }
}
