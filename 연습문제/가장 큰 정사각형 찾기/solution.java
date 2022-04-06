class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        
        int sizeX = board.length;
        int sizeY = board[0].length;
        
        int[][] DP = new int[2][board[0].length];
        
        for (int i = 0; i < sizeY; i++) {
            DP[0][i] = board[0][i];
            if(DP[0][i] > answer)
                answer = DP[0][i];
        }
        
        for (int i = 1; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if(board[i][j] == 0) DP[1][j] = 0;
                else {
                    if(j == 0) DP[1][j] = 1;
                    else {
                        DP[1][j] = 1;
                        if(DP[1][j-1] == 0 || DP[0][j] == 0 || DP[0][j-1] == 0)
                            DP[1][j] = 1;
                        else if(DP[1][j-1] == DP[0][j] && DP[0][j] == DP[0][j-1])
                            DP[1][j] = DP[0][j] + 1;
                        else {
                            if(DP[1][j-1] <= DP[0][j-1] && DP[1][j-1] <= DP[0][j])
                                DP[1][j] = DP[1][j-1] + 1;
                            else if(DP[0][j-1] <= DP[1][j-1] && DP[0][j-1] <= DP[0][j])
                                DP[1][j] = DP[0][j-1] + 1;
                            else if(DP[0][j] <= DP[0][j-1] && DP[0][j] <= DP[1][j-1])
                                DP[1][j] = DP[0][j] + 1;
                        }
                    }
                }
                
                if(DP[1][j] > answer)
                    answer = DP[1][j];
            }
            
            for (int j = 0; j < sizeY; j++) {
                DP[0][j] = DP[1][j];
            }
            
        }
        
        return answer*answer;

    }
}
