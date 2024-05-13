package org.example.Dynamic_programming.blackPack.blackpack01;

import java.io.StreamTokenizer;

public class p1048LG {
    static StreamTokenizer stk = new StreamTokenizer(new java.io.BufferedReader(new java.io.InputStreamReader(System.in)));
    static long[] dp = new long[1010];
    public static void main(String[] args) {
        int t = getInt();
        int m = getInt();
        int[] times = new int[m+1];
        int[] value = new int[m+1];
        for(int i = 1;i<=m;i++){
            times[i] = getInt();
            value[i] = getInt();
        }
//        for(int i = 1; i <= t;i++){//遍历每个时间
//            for(int j = 1; j <= m;j++){
//                //遍历每一个物品
//                if(i >= times[j]){//如果放得下 取
//                    dp[i][j] = Math.max(dp[i][j-1],dp[i - times[j]][j - 1] + value[j]);
//                    //意思 当dp[之前空间下的那一件物品][之前当然比现在少一件] + 这件东西的价值 > 没放进去时候的价值
//                }else
//                    dp[i][j] = dp[i][j-1];
//            }
//
//        }
        for(int i = 1; i <= m;i++){
            for (int j = t; j >= 1;j--){
                if(j >= times[i]){
                    dp[j] = Math.max(dp[j],dp[j - times[i]] + value[i]);
                }
            }
        }
        System.out.println(dp[t]);
    }
    static int getInt(){
        try{
            stk.nextToken();
            return (int)stk.nval;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
