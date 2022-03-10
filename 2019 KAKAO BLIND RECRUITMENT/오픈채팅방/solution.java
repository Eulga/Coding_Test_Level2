import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> userNameMap = new HashMap<>();
        
        int count = 0;
        for(String r : record) {
            String[] ra = r.split(" ");
            if(ra[0].charAt(0) == 'L') continue;
            else if(ra[0].charAt(0) == 'C') count++;
            userNameMap.put(ra[1], ra[2]);
        }
        
        String[] answer = new String[record.length - count];
        int index = 0;
        for(int i = 0; i < record.length; i++) {
            if(record[i].charAt(0) == 'E') {
                answer[index++] = userNameMap.get(record[i].split(" ")[1]) + "님이 들어왔습니다.";
            } else if(record[i].charAt(0) == 'L') {
                answer[index++] = userNameMap.get(record[i].split(" ")[1]) + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}
