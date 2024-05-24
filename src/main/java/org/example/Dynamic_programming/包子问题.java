package org.example.Dynamic_programming;
/**
 小明几乎每天早晨都会在一家包子铺吃早餐。他发现这家包子铺有
 𝑁
 N 种蒸笼，其中第
 𝑖
 i 种蒸笼恰好能放
 𝐴
 𝑖
 A
 i
 ​
 个包子。每种蒸笼都有非常多笼，可以认为是无限笼。

 每当有顾客想买
 𝑋
 X 个包子，卖包子的大叔就会迅速选出若干笼包子来，使得这若干笼中恰好一共有
 𝑋
 X 个包子。比如一共有 3 种蒸笼，分别能放 3、4 和 5 个包子。当顾客想买 11 个包子时，大叔就会选 2 笼 3 个的再加 1 笼 5 个的（也可能选出 1 笼 3 个的再加 2 笼 4 个的）。

 当然有时包子大叔无论如何也凑不出顾客想买的数量。比如一共有 3 种蒸笼，分别能放 4、5 和 6 个包子。而顾客想买 7 个包子时，大叔就凑不出来了。

 小明想知道一共有多少种数目是包子大叔凑不出来的。
 * **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 该问题为如果我手上有无限张面值为x,y,z的钞票，凑出数目为i的方法
 * **/
public class 包子问题 {
    static int N = (int)1e7;
    static int[] num = new int[105];
    static int[] dp = new int[N];
    public static void main(String[] args)
    {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1;i <= n;i++){
            num[i] = sc.nextInt();
            dp[num[i]]++;//初始化 意识为 凑到num[i]个包子有一种办法
        }
        /**
         *
         * 状态转移方程为 dp[i] = dp[i] + dp[i - num[y]] y = for (int y = 1;y <= n;y++)
         *
         * **/
        for(int i = 1;i < N;i++){
            for(int y = 1;y <= n;y++){
                if(i - num[y] >= 0)//边界控制
                    dp[i] = dp[i] + dp[i - num[y]];//检索每一个笼子能不能凑出来
            }
            if(dp[i] == 0) count++;
            if(count > 10000){
                System.out.println("INF");
                System.exit(0);}
        }
        System.out.println(count);
    }
}
