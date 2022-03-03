import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int step1 = n;
        int step2;
        while(true) {
            if(step1<4) {
                sb.insert(0, step1%3==0 ? 4:step1%3);
                break;   
            }
            step2 = step1%3;
            step1 = step1/3;
            if (step2 == 0) {
                step1--;
                step2 = 4;
            }
            sb.insert(0, step2);
        }
        return sb.toString();
    }
}
