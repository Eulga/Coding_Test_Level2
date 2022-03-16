// 스택 생각을 어떻게 이제서야 하지? 뇌가 퇴화했나 진짜
import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
         
        for(char c : s.toCharArray()) 
          if(!stack.isEmpty() && stack.peek() == c) stack.pop();
          else stack.push(c);
         
        return stack.isEmpty() ? 1 : 0;
    }
}

// 효율성 실패
class Solution
{
    public int solution(String s)
    {
        StringBuilder sb = new StringBuilder();
        char t = ' ';
        int cnt = 1;
        boolean tIsEmpty = true;

        while(cnt > 0) {
            cnt = 0;
            for(int i = 0; i < s.length(); i++) {
                if(tIsEmpty) {
                    t = s.charAt(i);
                    tIsEmpty = false;
                    continue;
                }
                if(t == s.charAt(i)) {
                    cnt++;
                    t = ' ';
                    tIsEmpty = true;
                } else {
                    sb.append(t);
                    t = s.charAt(i);
                }
            }
            tIsEmpty = true;
            if(t != ' ') sb.append(t);
            s = sb.toString();
            sb = new StringBuilder();
        }
        if(s.length() > 0) return 0;
        
        return 1;
    }
}
