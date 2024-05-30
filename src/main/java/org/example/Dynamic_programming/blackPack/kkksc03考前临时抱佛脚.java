package org.example.Dynamic_programming.blackPack;

import java.util.Scanner;

public class kkksc03考前临时抱佛脚 {
    static int[][] a = new int[5][21];

    static int[] s = new int[5];
    static int min;

    static int left,right;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        s[1] = sc.nextInt();
        s[2] = sc.nextInt();
        s[3] = sc.nextInt();
        s[4] = sc.nextInt();
        for(int i = 1; i <= 4;i++){
            for(int j = 1; j <= s[i];j++){
                a[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        //遍历每一个科目
        for(int i = 1; i <= 4;i++){
            min = (int)1e7;
            left = 0;right=0;
            dfs(i,1);
            ans += min;
        }
        System.out.println(ans);
    }

    static void dfs(int i,int homework_index){
        if(homework_index > s[i]){
            min = Math.min(min,Math.max(right,left));
            return;
        }
        //左边大脑
        left += a[i][homework_index];
        dfs(i,homework_index+1);
        left -= a[i][homework_index];//回溯
        //右边大脑
        right += a[i][homework_index];
        dfs(i,homework_index+1);
        right -= a[i][homework_index];//回溯
    }
}
