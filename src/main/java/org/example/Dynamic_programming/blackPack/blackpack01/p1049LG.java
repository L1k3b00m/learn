package org.example.Dynamic_programming.blackPack.blackpack01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class p1049LG {
    static StreamTokenizer stk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static int getInt(){
        try {
            stk.nextToken();
            return (int)stk.nval;
        }catch (IOException e){
            e.printStackTrace();
            return -1;
        }
    }
    static int[] dp = new int[20010];
    public static void main(String[] args) {
        int V = getInt();
        int n = getInt();
        int[] weight = new int[n+1];
        for(int i = 1;i<=n;i++){
            weight[i] = getInt();
        }
        //状态转移方程dp[i]在当前重量之下，能装下的最多的物品重量为多少
        //遍历每一个物品
        for(int i = 1;i <= n;i++){
            //倒叙遍历每一个重量
            for(int j = V;j >= 1;j--){
                //如果当前背包大小大于物品重量，取
                if(j >= weight[i]){
                    dp[j] = Math.max(dp[j],dp[j-weight[i]]+weight[i]);
                }
            }
        }
        System.out.println();
    }
}
