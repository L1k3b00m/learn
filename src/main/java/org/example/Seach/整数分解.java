package org.example.Seach;

import java.util.Scanner;

public class 整数分解 {
    //把正整数n分解成m个不同的正整数，排在后面的必须大于等于前面的数，输出所有方案
    static boolean[] vis = new boolean[50];

    static int[] arr = new int[50];

    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dfs(1);
    }
    static void dfs(int n){
        if(n == N+1){
            for(int i = 1; i <= N; i++){
                System.out.print("    "+arr[i]);
            }
            System.out.println();
        }
        for(int i = 1; i <= N; i++){
            if(!vis[i]){
            arr[n] = i;
            vis[i] = true;
            dfs(n+1);
            vis[i] = false;}
        }
    }
}
