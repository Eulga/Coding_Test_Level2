package com.example;

public class App {

    
    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;
        
        int nl = number.length();
        if(nl == 1) {
            return; // 리턴 number
        }

        String temp = "";
        String topNumber = "";
        String answer = "";

        int s = nl-k;

        for (int i=1; i<=s; i++) {
            temp = number.substring(0, nl-(s-i));
            topNumber = pickTopNumber(temp);
            answer += topNumber;
            number = number.substring(number.indexOf(topNumber)+1);
            nl = number.length();
            if(nl == s-i) {
                answer += number;
                System.out.println("정답 " + answer);
                return;
            }
            
        }
        System.out.println(answer);
    }

    public static String pickTopNumber(String number) {
        String[] numbers = number.split("");
        char topNumber = '0';
        for(String cn : numbers) {
            if(cn.equals("9")) {
                return cn;
            }
            if (cn.charAt(0) > topNumber) {
                topNumber = cn.charAt(0);
            } 
        }
        return Character.toString(topNumber);
    }
}
