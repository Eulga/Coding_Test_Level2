import java.util.*;
import java.util.concurrent.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < priorities.length; i++) {
            map.put(i, priorities[i]);
        }

        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        for(int m : map.keySet()){
            queue.add(m);
        }
        
        int now = 0;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            boolean check = false;
            for(int q : queue) {
                if(map.get(q) > map.get(cur)) {
                    check = true;
                    break;
                }
            }
            if(check) {
                queue.add(cur);
            } else {
                now++;
                if(cur == location) {
                    answer = now;
                    break;
                }
            }
        }
        return answer;
    }
}
