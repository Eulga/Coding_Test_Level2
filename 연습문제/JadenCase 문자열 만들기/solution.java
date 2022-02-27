class Solution {
    public String solution(String s) {
        String answer = "";
        int upper = 0;
        boolean first = true;
        for(char c : s.toLowerCase().toCharArray()) {
            if (c == ' '){
                upper = 0;
                first = true;
            } else if (first && c > '9') {
                upper = 32;
                first = false;
            } else if (first) {
                upper = 0;
                first = false;
            } else {
                upper = 0;
            }
            answer += (char)(c-upper);
        }
        return answer;
    }
}
