import java.util.*;

class Solution {
    boolean[][] v;
    int[][] copyPicture;
    int cnt;
    int[] dy;
    int[] dx;
        
    public int[] solution(int m, int n, int[][] picture) {
        v = new boolean[m][n];
        copyPicture = picture;
        dy = new int[] {-1, 1, 0, 0};
        dx = new int[] {0, 0, -1, 1};

        Set<Integer> ps = new TreeSet<>();
        for(int[] pic : picture) {
            for(int p : pic) {
                ps.add(p);
            }
        }

        Iterator<Integer> pi = ps.iterator();
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        while(pi.hasNext()){
            int p = pi.next();
            for(int i = 0; i < m; i++) {
                for(int k = 0; k < n; k++) {
                    if(v[i][k] || picture[i][k] != p || picture[i][k] == 0) continue;
                    dfs(i, k, n, m, p);
                    maxSizeOfOneArea = cnt > maxSizeOfOneArea ? cnt:maxSizeOfOneArea;
                    numberOfArea++;
                    cnt = 0;
                }
            }
            v = new boolean[m][n];
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public void dfs(int i, int k, int n, int m, int p) {
        v[i][k] = true;
        if(copyPicture[i][k] == p){
            cnt++;
        }
        for(int l = 0; l < 4; l++) {
            int ny = i + dy[l];
            int nx = k + dx[l];
            
            if(ny < 0 || ny >= m || nx < 0 || nx >= n || v[ny][nx] || copyPicture[i][k] != p) continue;
            
            dfs(ny, nx, n, m, p);
        }
    }
}
