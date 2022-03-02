// 9개 였던 실패를 1개(13번)로 줄였다.
// 정답을 봤지만 전혀 다른 형태여서 난항이다..
// 개선안을 생각해서 구현해봤는데도 한 개를 틀렸는데 대체 왜일까.. 13번 케이스는 대체 뭘까...

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
        int cnt = 0;
        for(int i = maxNumInInfo+1; i >= 0; i --) {
            arrow = n;
            apeachST = apeachScore;
            lionScore = 0;
            cnt = 0;
            int[] lionInfo = new int[info.length];

            for(int k = 0; k < info.length; k++) {
                if (info[k] == 0) cnt++;
                if (info[k] < i && arrow > info[k] && info[k] > 0) {
                    lionScore += score[k];
                    arrow -= info[k]+1;
                    lionInfo[k] = info[k]+1;
                    if(info[k] > 0) apeachST -= score[k];
                }
                if (arrow == 0 || arrow <= cnt) {
                    break;
                }
            }
            if(arrow > 0) {
                for(int k = 0; k < info.length; k++) {
                    if(info[k] == 0) {
                        arrow--;
                        lionInfo[k] = 1;
                        lionScore += score[k];
                    }
                    if(arrow==0) break;
                }
                if(arrow > 0) lionInfo[info.length-1] += arrow;
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
