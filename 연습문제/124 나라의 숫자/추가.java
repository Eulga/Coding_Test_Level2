//다른 사람의 답변인데 굉장히 경이롭다
class Solution {
  public String solution(int n) {
      String[] num = {"4","1","2"};
      String answer = "";

      while(n > 0){
          answer = num[n % 3] + answer;
          n = (n - 1) / 3;
      }
      return answer;
  }
}

// 이걸 int[]과 StringBuilder로 수정했더니 1.12ms가 0.04ms로 줄어들었다 내가 낸 답보다 두배 빠르다
class Solution {
    public String solution(int n) {
        int[] num = {4, 1, 2};
        StringBuilder answer = new StringBuilder();

        while(n > 0){
            answer.insert(0, num[n % 3]);
            n = (n - 1) / 3;
        }
        return answer.toString();
    }
}
