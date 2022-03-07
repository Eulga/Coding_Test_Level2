import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue();

        for (int s : scoville) {
            heap.offer(s);
        }
        
        int a;
        int b;
        int result;
        while (heap.peek() <= K) {
            if (heap.size() == 1) {
                return -1;
            }
            a = heap.poll();
            b = heap.poll();


            result = a + (b * 2);

            heap.offer(result);
            answer ++;
        }
        return answer;
    }
}
