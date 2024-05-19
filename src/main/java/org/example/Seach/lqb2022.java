package org.example.Seach;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class lqb2022 {
    static String str;
    static long sum = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        str = scan.next();
        long A = scan.nextLong();
        long B = scan.nextLong();
        dfs(0,A,B,0);
        scan.close();
        System.out.println(sum);
    }
    static void dfs(int cur,long a,long b,long val){
        if(cur < str.length()){
            long x = str.charAt(cur) - '0';//获取位数大小
            long count = Math.min(a,9-x);//看看能不能这位离9远不远,先试加法
            dfs(cur+1,a-count,b,val*10L + x + count);//试着把他加到9
            if(b > count){
                dfs(cur+1,a,b-count- 1L,val *10L + 9);
            }
        }else{
            sum = Math.max(sum,val);
        }
    }
}