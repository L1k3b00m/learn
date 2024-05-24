package org.example.Dynamic_programming;

import java.util.Scanner;

public class 翻转 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] dp = new int[(int)1e5 + 5][2];//0-1代表翻转与不翻转
        int n = sc.nextInt();
        char[][] str_arr = new char[(int)1e5 + 5][2];
        for(int i = 0; i < n; i++){
            str_arr[i] = sc.next().toCharArray();
        }
        //对于DP来说，有翻转和不翻转两种情况 在验证前一个工作的尾字母与当前工作是否有重合 后进行状态转移
        // 如果有 dp[i] = dp[i-1] + 1;
        // 如果没有 dp[i] = dp[i-1] + 2;
        // 保存temp = arr[i].charAt(1);
        //初始化

        dp[0][1] = 2;
        dp[0][0] = 2;
        //dp[i][0-1]
        for(int i = 1; i < n; i++){
            //如果不翻转 用第一个字母与前面工件两个字母相匹配 与第二个相等就加到不翻转，与第一个相等就加到翻转
            dp[i][0] = Math.min(dp[i-1][0] + (str_arr[i-1][1] == str_arr[i][0] ? 1 : 2),dp[i-1][1] + (str_arr[i-1][0] == str_arr[i][0] ? 1 : 2));
            //如果翻转，用第一个字母与前面工件两个字母相匹配 与第二个相等就加到不翻转，与第一个相等就加到翻转
            dp[i][1] = Math.min(dp[i-1][1] + (str_arr[i-1][0] == str_arr[i][1] ? 1 : 2),dp[i-1][0] + (str_arr[i-1][1] == str_arr[i][1] ? 1 : 2));

        }
        System.out.println(Math.min(dp[n-1][0],dp[n-1][1]));
    }
}
