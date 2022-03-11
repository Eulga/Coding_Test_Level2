import java.util.*;

class Solution {
    public String solution(String abc) {
        int[] sStream = Arrays.stream(abc.split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = new StringBuilder();
      
        sb.append(Arrays.stream(sStream).min().getAsInt());
        sb.append(" ");
        sb.append(Arrays.stream(sStream).max().getAsInt());
        return sb.toString();
    }
}
