package othet;

import java.util.*;

/**
 *
 * 计算类
 *
 * **/
public class calu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[1010][1010];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i][j] = sc.nextInt();
            }
        }
        for(int i = n-1;i >= 1;i--){
            for(int j = 1;j <= i;j++){
                dp[i][j] = dp[i][j] + Math.max(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        System.out.println(dp[1][1]);

    }
}
