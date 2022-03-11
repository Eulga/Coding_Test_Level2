class Solution {
    public int solution(int n) {
        int answer = 1;
        int i = 1;
        while(i < Math.round(n/2)+1) {
            int sum = 0;
            for(int k = i; k <= Math.round(n/2)+1; k++){
                sum += k;
                if(sum >= n) {
                    break;
                }
            }
            if(sum == n) answer++;
            i++;
        }
        return answer;
    }
}
