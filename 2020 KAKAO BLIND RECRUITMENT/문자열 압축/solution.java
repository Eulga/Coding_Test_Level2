class Solution {
    public int solution(String s) {
        String temp = "";

        int numLan = 0;
        int cutCnt = 1; // 중복 발생 시 1 증가
        int cutLan = 0; // 중복 발생 시 컷길이 만큼 증가
        
        int answer = s.length();

        for(int i = 1; i <= s.length()/2; i++) {
            int si = 0;
            int ei = i;
            while(ei <= s.length()) {
                if(temp.equals(s.substring(si, ei))) {
                    cutCnt++;
                    cutLan+=i;
                } else {
                    if(cutCnt > 1) numLan += (int) (Math.log10(cutCnt)+1);
                    cutCnt = 1;
                    temp = s.substring(si, ei);
                }
                si = ei;
                ei += i;
            }
            if(cutCnt > 1) numLan += (int) (Math.log10(cutCnt)+1);
            answer = answer < s.length()+numLan-cutLan ? answer:s.length()+numLan-cutLan;
            cutCnt = 1;
            numLan = 0;
            cutLan = 0;
        }
        return answer;
    }
}
