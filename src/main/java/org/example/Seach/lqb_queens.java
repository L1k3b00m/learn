package org.example.Seach;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class lqb_queens {
    static int count = 0;
    static int[] queens;
    static boolean[] vis;
    static int target;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        target = scan.nextInt();
        queens = new int[target+1];
        vis = new boolean[target+1];
        scan.close();
        dfs(1);
        System.out.println(count);
    }
    static void dfs(int row){
        for(int i = 1; i < row - 1;i++){
            if(row  - 1 - i == Math.abs(queens[row - 1] - queens[i])) return;
        }
        if(row > target) count++;
        for(int i = 1;i <= target;i++){
            if(!vis[i]){
                vis[i] = true;
                queens[row] = i;
                dfs(row+1);
                vis[i] = false;
            }
        }
    }
}