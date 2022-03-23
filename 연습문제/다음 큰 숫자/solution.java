class Solution {
    //맨 마지막 숫자가 1일 때 가장 낮은 자리의 0을 찾고 그 다음 1을 0자리에 옮긴후 true 리턴
    // 11001101 -> 11001110
    //0이 없을 경우 맨앞에 1을 붙이고 맨앞이었던 1을 0으로 변경
    // 1111 - > 10111
    public boolean oneInLast(char[] arr) {
        for(int i = arr.length-1; i >= 0; i--) {
            if(arr[i] == '0') {
                arr[i] = '1';
                arr[i+1] = '0';
                return true;
            }
        }

        arr[0] = '0';
        return false;
    }
    
    //맨 마지막 숫자가 0일 때 가장 낮은 자리의 0을 찾고 그 다음 1을 0자리에 옮긴 후 그 뒤의 1들을 오른쪽 끝으로 밀어내고 true 리턴
    // 1001110 -> 1010011
    // 0이 없을 경우 맨앞에 1을 붙이고 1의 개수 -1 개를 맨오른쪽부터 입력
    // 11110 -> 100111 
    public boolean zeroInLast(char[] arr) {
        int i;
        int cnt = 0;
        boolean check = true;
        for(i = arr.length-2; i >= 0; i--) {
            if(arr[i] == '1') {
                cnt++;
                arr[i] = '0';
            } else if(arr[i] == '0' && cnt > 0) {
                arr[i] = '1';
                check = false;
                break;
            }
        }


        for(int k = arr.length-1; cnt > 1; k--) {
            cnt--;
            arr[k] = '1';
        }

        if(check) {
            arr[0] = '0';
            return false;
        }
        return true;
    }
    
    public int solution(int n) {
        char[] binaryArr = Integer.toBinaryString(n).toCharArray();
        boolean check = true;
        if(binaryArr[binaryArr.length-1] == '0') {
            check = zeroInLast(binaryArr);
        } else {
            check = oneInLast(binaryArr);
        }

        int answer = 0;
        if(check) {
            answer = Integer.parseInt(new String(binaryArr), 2);
        } else {
            answer = Integer.parseInt("1" + new String(binaryArr), 2);
        }

        return answer;
    }
}
