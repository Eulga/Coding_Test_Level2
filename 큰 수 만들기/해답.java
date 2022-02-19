package com.example;

import java.util.*;

public class App {
    
    /**
     * 아무리 고쳐도 10번 테스트가 통과가 안돼서
     * 질문하기 에서 정답 가져왔음
     */

    public static void main(String[] args) {
        String number = "4";
        int k = 1;
        
        char[] res = new char[number.length()-k];
        Stack<Character> st = new Stack<>();

        for(int i=0; i<number.length(); i++){
            char c = number.charAt(i);
            while(!st.isEmpty() && st.peek() < c && k-- > 0) { // 이 알고리즘을 생각해보자 k-- > 0 이걸 생각할 줄 알아야한다.
                st.pop();
            }
            st.push(c);
        }
        for(int i=0; i<res.length; i++){
            res[i] = st.get(i);
        }
    }
}
