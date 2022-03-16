import java.math.*;

class Solution {
  public long solution(int w, int h) {
    long answer = 1;
    long W = (long)w;
    long H = (long)h;
    if(w==h) return W * H - W; // 얘 까진 당연한거니까 했지만

    //BigInteger의 기능도 몰랐고 이런 식 자체를 생각도 못했음
    long gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();
    return W * H - (W / gcd + H / gcd - 1) * gcd;
  }
}
