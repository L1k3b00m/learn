package org.example.Seach;

import java.io.StreamTokenizer;

public class p1219 {
    static int n;
    static int[] quenes;
    static boolean[] vis;
    static int count = 0;
    static StreamTokenizer stk = new StreamTokenizer(new java.io.BufferedReader(new java.io.InputStreamReader(System.in)));
    static int getInt(){
        try {
            stk.nextToken();
            return (int)stk.nval;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        n = getInt();
        quenes = new int[n+1];
        vis = new boolean[n+1];
        dfs(1);
        System.out.println(count);
    }
    static boolean check(int line){
        for(int i = 1; i < line ;i++){
            if(line - i == Math.abs(quenes[line] - quenes[i])) return false;
        }
        return true;
    }
    static void dfs(int row) {

        if(!check(row-1)) return;//检查前面的所有皇后是否不冲突
        if(row > n){
            count++;
            for(int i = 1; i <= n && count <= 3;i++){
                System.out.print(quenes[i] + " ");
                if(i == n) System.out.println();
            }
        }
        for(int i = 1 ; i <= n;i++){
            if(!vis[i]){
                vis[i] = true;
                quenes[row] = i;
                dfs(row+1);
                vis[i] = false;
            }
        }
    }
}