import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<Integer>();
        int popNum = 0;
        int stack = 0;
        while(popNum < progresses.length) {
            for(int i = popNum; i < progresses.length; i ++) {
                if(progresses[i] < 100) progresses[i] += speeds[i];
            }
            while(progresses[popNum] >= 100) {
                popNum++;
                stack++;
                if(popNum >= progresses.length) break;
            }
            if(stack>0) answerList.add(stack);
            stack = 0;
        }
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
