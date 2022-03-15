import java.util.*;

class Solution {
    Map<Character, Integer> numMap;
    String[] copyData;
    int[] sbs;
    boolean[] check;
    int answer;
    
    public int solution(int n, String[] data) {
        copyData = data;
        sbs = new int[8];
        answer = 0;
        check = new boolean[8];
        numMap = new HashMap<>();
    
        numMap.put('A',0);
        numMap.put('C',1);
        numMap.put('F',2);
        numMap.put('J',3);
        numMap.put('M',4);
        numMap.put('N',5);
        numMap.put('R',6);
        numMap.put('T',7);
        
        dfs(0);
        
        return answer;
    }
    
    public boolean getResult() {
        for(String d : copyData) {
            int t1 = sbs[numMap.get(d.charAt(0))];
            int t2 = sbs[numMap.get(d.charAt(2))];
            char op = d.charAt(3);
            int compNum = d.charAt(4) - '0' + 1;
            
            if(op == '=') {
                if(Math.abs(t1-t2) != compNum) return false;
            } else if (op == '>') {
                if(Math.abs(t1-t2) <= compNum) return false;
            } else {
                if(Math.abs(t1-t2) >= compNum) return false;
            }
        }
        return true;
    }
    
    public void dfs(int idx) {
        if(idx == 8) {
            if(getResult()) answer++;
            return;
        }
        
        for(int i = 0; i < 8; i++) {
            if(!check[i]) {
                check[i] = true;
                sbs[idx] = i;
                dfs(idx + 1);
                check[i] = false;
            }
        }
    }
    
}
