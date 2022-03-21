import java.math.*;

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i = 1; i < arr.length; i++) {
            answer = lcm(Math.max(answer,arr[i]), Math.min(answer,arr[i]));
        }
        return answer;
    }
    
    public int lcm(int n1, int n2) {
        BigInteger num1 = BigInteger.valueOf(n1);
        BigInteger num2 = BigInteger.valueOf(n2);
        return num1.multiply(num2).divide(num1.gcd(num2)).intValue();
    }
}
