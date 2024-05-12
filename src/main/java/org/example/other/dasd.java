package org.example.other;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class dasd {
    static int mod;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        mod = 2146516019;
//       long res = 0;
//       long start = System.currentTimeMillis();
//       for(int i = 1; i<=233333333;i++){
//           long n = fpow(i,mod-2);
//           res ^= n;
//       }
        String a = sc.next();
        String[] s  = new String[4];
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        for(int i = 0; i < a.length();i++){
            if(a.charAt(i) == '+' || a.charAt(i) == '-' || a.charAt(i) == '*' || a.charAt(i) == '/' || a.charAt(i) == '?' || a.charAt(i) == '=') {
                if(!sb.isEmpty()){
                    s[flag] = sb.toString();
                    sb.delete(0,sb.length());
                    flag++;
                }
                if(a.charAt(i) != '='){
                    s[flag] = String.valueOf(a.charAt(i));}
                flag++;
            }else{
            sb.append(a.charAt(i));}
//            System.out.println(sb);
        }
        s[3] = sb.toString();

        if(s[1].equals("?")){
            int a1 = Integer.parseInt(s[0]);
            int b1 = Integer.parseInt(s[2]);
            int c1 = Integer.parseInt(s[3]);
            if(c1 / b1 == a1) System.out.println('*');
            if(c1 - b1 == a1) System.out.println('+');
            if(a1 / b1 == c1) System.out.println("/");
            if(a1 - b1 == c1) System.out.println("-");
        }

        if(s[0].equals("?")){
            int a1 = Integer.parseInt(s[2]);
            int b1 = Integer.parseInt(s[3]);
            if(s[1].equals("*")) System.out.println(b1 / a1);
            if(s[1].equals("+")) System.out.println(b1 - a1);
            if(s[1].equals("/")) System.out.println(b1 * a1);
            if(s[1].equals("-")) System.out.println(b1 + a1);
        }
        if(s[2].equals("?")){
            int a1 = Integer.parseInt(s[0]);
            int b1 = Integer.parseInt(s[3]);
            if(s[1].equals("*")) System.out.println(b1 / a1);
            if(s[1].equals("+")) System.out.println(b1 - a1);
            if(s[1].equals("/")) System.out.println(b1 * a1);
            if(s[1].equals("-")) System.out.println(b1 + a1);
        }
        if(s[3].equals("?")){
            int a1 = Integer.parseInt(s[0]);
            int b1 = Integer.parseInt(s[2]);
            if(s[1].equals("*")) System.out.println(a1*b1);
            if(s[1].equals("+")) System.out.println(b1 + a1);
            if(s[1].equals("/")) System.out.println(a1 / b1);
            if(s[1].equals("-")) System.out.println(b1 - a1);
        }


        //System.out.println(res+"  耗时:"+(System.currentTimeMillis()-start));
    }

    static long fpow(long a,long b){
        long res = 1;
        a%=mod;
        while(b >0){
            if(b % 2 == 1){
                res = res * a % mod;
            }
            a = a * a % mod;
            b/=2;
        }
        return res;
    }
}