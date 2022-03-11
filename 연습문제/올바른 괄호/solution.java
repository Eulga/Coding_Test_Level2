class Solution {
    boolean solution(String s) {
        int count = 0;
        for(char c : s.toCharArray()) {
            count += c=='(' ? 1:-1;
            if(count < 0) return false;
        }
        if(count > 0) return false;
        return true;
    }
}
