import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] sNumbers = new String[numbers.length];
      
        for(int i = 0; i < numbers.length; i++) {
            sNumbers[i] = String.valueOf(numbers[i]);
        }
      
        Arrays.sort(sNumbers, (o1, o2) -> (o2+o1).compareTo(o1+o2));
      
        if(sNumbers[0].equals("0")) return "0";
      
        return String.join("", sNumbers);    
    }
}
