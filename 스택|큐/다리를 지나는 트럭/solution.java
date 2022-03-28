import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        
        for(int t : truck_weights) {
			
			while(true) {
				if(queue.isEmpty()) {
					queue.offer(t);
					sum += t;
					answer++;
					break;
				} else if(queue.size() == bridge_length) {
					sum -= queue.poll();
				}
                
				else {
					if(sum + t > weight) {
						queue.offer(0);
						answer++;
					} else {
						queue.offer(t);
						sum += t;
						answer++;
						break;
					}
				}
			}
		}
		
		return answer + bridge_length;
    }
}
