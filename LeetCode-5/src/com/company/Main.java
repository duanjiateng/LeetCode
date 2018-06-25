package com.company;

public class Main {

    /**
     * 暴力法：找出所有子串，判断是否为回文串
     * */
    public static String longestPalindrome(String s) {
        int i, j, max = 0;
        String anwser = null;

            for (i=0; i<s.length(); i++) {
                for (j=i+1; j<s.length()+1; j++) {
                    String str = s.substring(i, j);

                    if( max < str.length() && isPalindrome(str)){

                            max = str.length();
                            anwser = str;

                    }

                }
            }

            return anwser;




    }


    static boolean isPalindrome(String str) {
        int i = 0;


         for (int j=0; j<(str.length()/2); j++){
            if(str.charAt(i) != str.charAt(str.length()-1-i)) {
                return false;
            }
            i++;
        }

        return true;
    }

    public static String longestPalindrome2(String s) {
        char[] c = new char[2*s.length() + 1] ;
        int cen = 0, len = 0, start = 0;


        //对s进行预处理，在每个字符之间加入‘#’，简化奇偶问题

        for(int i=0; i<c.length; i++) {
            if ( i % 2 == 0){
                c[i] = '#';
            }else{
                c[i] = s.charAt((i-1)/2);
            }
        }

        //进行中心扩展
        String s1 = new String(c);
        for (int i=0; i<s1.length(); i++){
            int temp = centerExpansion(s1, i);
            if(len < temp){
                len = temp;
                cen = i;
            }
        }
        System.out.println(len);
        System.out.println(cen);
        start = (cen - len + 1)/2;
        //cen = (cen - 1) / 2;
        len = (2*len - 1) / 2;
        return s.substring(start, start+len);





    }

    static int centerExpansion(String s1, int i) {
        int j = 0;
        while (j <= ((s1.length()-1-i > i) ? i : s1.length()-1-i)){
            if (s1.charAt(i-j) != s1.charAt(i+j)){
                break;
            }
            j++;
        }
        return j;

    }

    public static void main(String[] args) {
	// write your code here
        String s = "abcabccba";
        //System.out.println(longestPalindrome(s));
        //System.out.println(s.charAt(s.length()-1));
        System.out.println(s.substring(0,1));
        System.out.println(longestPalindrome2(s));
    }
}
