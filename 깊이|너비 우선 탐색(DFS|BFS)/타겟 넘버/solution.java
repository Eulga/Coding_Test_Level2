class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int current = numbers[0];
        
        answer += dfs(current, 1, numbers, target);
        answer += dfs(-current, 1, numbers, target);
        return answer;
    }
    
    public int dfs(int prev, int index, int[] numbers, int target) {
        if(index >= numbers.length) {
            if(prev == target) {
                return 1;
            }
            return 0;
        }
        
        int cur1 = prev + numbers[index];
        int cur2 = prev - numbers[index];
        
        int ans = 0;
        ans += dfs(cur1, index+1, numbers, target);
        ans += dfs(cur2, index+1, numbers, target);
        
        return ans;
    }
}
