class Solution {
    int[][] arr;
    
    public void initArr(int rows, int columns) {
        int num = 1;
        
        for(int i = 0; i < rows; i++) {
            for(int k = 0; k < columns; k++) {
                arr[i][k] = num++;
            }
        }
    }
    
    public int cycle(int[] queries) {
        int x1 = queries[0] - 1;
        int y1 = queries[1] - 1;
        int x2 = queries[2] - 1;
        int y2 = queries[3] - 1;
        
        int key = 1;
        boolean vertical = true;
        int temp = arr[x1][y1];
        int min = temp;
        int now1 = x1;
        int now2 = y1;
        
        while(true) {
            if(vertical) {
                arr[now1][now2] = arr[now1+key][now2];
                now1 = now1+key;
                if(now1 == x2 || now1 == x1) {
                    vertical = false;
                }
            } else {
                arr[now1][now2] = arr[now1][now2+key];
                now2 = now2+key;
                if(now2 == y2) {
                    vertical = true;
                    key = -1;   
                }
            }
            
            min = Math.min(min, arr[now1][now2]);

            if(now1 == x1 && now2 == y1+1) {
                arr[now1][now2] = temp; 
                break;
            }
        }
        return min;
    }
    
    public int[] solution(int rows, int columns, int[][] queries) {
        arr = new int[rows][columns];
        initArr(rows, columns);
        
        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            answer[i] = cycle(queries[i]);
        }
        
        return answer;
    }
    
}
