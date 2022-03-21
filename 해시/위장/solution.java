import java.util.*;

// 수학공식 정도는 적어주지... 수학공식 찾는 문제냐고...
class Solution {
    Map<String, Integer> cMap;
    
    public int solution(String[][] clothes) {
    
        cMap = new HashMap<>();
        for(String[] clothesInfo : clothes) {
            cMap.put(clothesInfo[1], cMap.getOrDefault(clothesInfo[1], 0) + 1);
        }
        
        int answer = 1;
        for(String key : cMap.keySet()) {
            answer *= cMap.get(key) + 1;
        }
        
        return answer-1;
    }
}
