// 2 3 4 10 12 13 15 16 21 실패
// 제대로된 알고리즘이 아닌 것은 알지만 개선안을 생각할 수 없었음

import java.util.*;

class Solution {
    public int[] solution(int n, int[] info) {
        int maxNumInInfo = 0;
        int[] score = {10,9,8,7,6,5,4,3,2,1,0};

        int apeachScore = 0;

        for(int i = 0; i < info.length; i++) {
            apeachScore += info[i] > 0 ? score[i]:0;
            maxNumInInfo = info[i] > maxNumInInfo ? info[i]:maxNumInInfo;
        }

        HashMap<Integer, int[]> rank = new HashMap<>();

        int lionScore = 0;
        int apeachST = 0;
        int arrow = 0;
        for(int i = maxNumInInfo+1; i > 0; i --) {
            arrow = n;
            apeachST = apeachScore;
            lionScore = 0;
            int[] lionInfo = new int[info.length];

            for(int k = 0; k < info.length; k++) {
                if (info[k] < i && arrow > info[k]) {
                    lionScore += score[k];
                    arrow -= info[k]+1;
                    lionInfo[k] = info[k]+1;
                    if(info[k] > 0) apeachST -= score[k];
                }
                if (arrow == 0) {
                    break;
                }
            }
            if(arrow > 0) {
                lionInfo[lionInfo.length-1] = arrow;
            }
            if(lionScore > apeachST){
                rank.put(lionScore - apeachST, lionInfo);
            }
        }
        
        if(rank.isEmpty()) return new int[] {-1};
        
        int max = 0;
        for(int r : rank.keySet()) {
            max = r>max ? r:max;
        }
        return rank.get(max);
    }
}
