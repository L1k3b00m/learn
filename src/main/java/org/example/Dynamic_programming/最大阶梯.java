package org.example.Dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class 最大阶梯 {
    static int[][] graph = new int[1005][1005];

    static int n;
    static StreamTokenizer stk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static int getInt(){
        try {
            stk.nextToken();
            return (int)stk.nval;
        }catch (Exception e){
            return 1;
        }
    }
    public static void main(String[] args) {
        n = getInt();
        for(int i = 1 ; i <= n;i++){
            for(int j = 1 ; j <= n;j++){
                graph[i][j] = getInt();
            }
        }
        int[] list = {check1(),check2(),check3(),check4()};
        Arrays.sort(list);
        System.out.println(list[3]);
    }
    //从四个方向直接干进去
    static int check1(){
        //左上角
        int ans = 0;
        int[][] dp = new int[1005][1005];
        for(int i = 0 ; i < 1005;i++){
            Arrays.fill(dp[i],1);
        }
        for(int i = 1; i <= n;i++){
            for(int j = 1; j <= n;j++){
                /**
                 *
                 *
                 *       搜索的形状是
                 *         1
                 *        11
                 *       111
                 * **/
                if(graph[i][j] == graph[i-1][j] &&  graph[i-1][j] == graph[i][j-1] && graph[i][j] == graph[i][j-1]){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + 1;
                    ans = Math.max(ans,dp[i][j]);
                }
            }
        }
        return ans;
    }
    static int check2(){
        //右上角
        int ans = 0;
        int[][] dp = new int[1005][1005];
        for(int i = 0 ; i < 1005;i++){
            Arrays.fill(dp[i],1);
        }
        for(int i = 1; i <= n;i++){
            for(int j = n; j >= 1;j--){
                /*


                        搜索的形状是
                          1
                          11
                          111

                  **/
                if(graph[i][j] == graph[i-1][j] &&  graph[i-1][j] == graph[i][j+1] && graph[i][j] == graph[i][j+1]){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j+1]) + 1;
                    ans = Math.max(ans,dp[i][j]);
                }
            }
        }
        return ans;
    }
    static int check3(){
        //左下角
        int ans = 0;
        int[][] dp = new int[1005][1005];
        for(int i = 0 ; i < 1005;i++){
            Arrays.fill(dp[i],1);
        }
        for(int i = n; i >= 1;i--){
            for(int j = 1; j<= n;j++){
                /*


                        搜索的形状是
                         111
                          11
                           1

                  **/
                if(graph[i][j] == graph[i+1][j] &&  graph[i+1][j] == graph[i][j-1] && graph[i][j] == graph[i][j-1]){
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j-1]) + 1;
                    ans = Math.max(ans,dp[i][j]);
                }
            }
        }
        return ans;
    }
    static int check4(){
        //右下角
        int ans = 0;
        int[][] dp = new int[1005][1005];
        for(int i = 0 ; i < 1005;i++){
            Arrays.fill(dp[i],1);
        }
        for(int i = n; i >= 1;i--){
            for(int j = n; j >= 1;j--){
                /*


                        搜索的形状是
                         111
                         11
                         1

                  **/
                if(graph[i][j] == graph[i+1][j] &&  graph[i+1][j] == graph[i][j+1] && graph[i][j] == graph[i][j+1]){
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1]) + 1;
                    ans = Math.max(ans,dp[i][j]);
                }
            }
        }
        return ans;
    }
}
