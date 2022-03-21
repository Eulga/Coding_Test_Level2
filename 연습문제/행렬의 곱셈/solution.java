class Solution {
    int[][] copyArr2;
    
    public int[][] solution(int[][] arr1, int[][] arr2) {
        copyArr2 = arr2;
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int i = 0; i < arr1.length; i++) {
            multiplyAndPlus(arr1[i], answer[i]);
        }
        
        return answer;
    }
    
    public void multiplyAndPlus(int[] arr1, int[] answer) {
        for(int i = 0; i < answer.length; i++) {
            for(int k = 0; k < copyArr2.length; k++) {
                answer[i] += arr1[k] * copyArr2[k][i];
            }
        }
    }
}
