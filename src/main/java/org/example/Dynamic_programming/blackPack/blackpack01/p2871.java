package org.example.Dynamic_programming.blackPack.blackpack01;

import java.io.StreamTokenizer;

public class p2871 {
    static StreamTokenizer stk = new StreamTokenizer(new java.io.BufferedReader(new java.io.InputStreamReader(System.in)));
    static int[] dp = new int[10001];
    public static void main(String[] args) {
            int n = getInt();
            int m = getInt();
            int[] w = new int[n+1];
            int[] v = new int[n+1];
            for(int i = 1;i<=n;i++){
                w[i] = getInt();
                v[i] = getInt();
            }
            //对于背包问题 dp[i] 代表在当前重量之下，能装下的最大价值 有如下状态转移方程
            //dp[i] = max(dp[i - w[i]] + v[i],dp[i]);//覆盖更新
            for(int i = 1 ;i<=n;i++){
                //遍历物品个数
                for(int j = m ; j >= 1;j--){
                    //倒序检索
                    if(j >= w[i]){
                        dp[j] = Math.max(dp[j],dp[j - w[i]] + v[i]);
                    }
                }
            }
        System.out.println(dp[m]);
    }
    static int getInt()
    {
        try
        {
            stk.nextToken();
            return (int) stk.nval;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
