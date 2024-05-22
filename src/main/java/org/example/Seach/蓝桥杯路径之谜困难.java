package org.example.Seach;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class 蓝桥杯路径之谜困难 {
    static StreamTokenizer stk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static int getInt(){
        try{
            stk.nextToken();
            return (int)stk.nval;
        }catch (Exception e){
           return -1;
        }
    }
    static boolean success;
    static int[] x_list;
    static int[] y_list;
    static boolean[][] vis;
    static int n;
    static int[] ans;
    public static void main(String[] args) {
        n = getInt();
        x_list = new int[n];
        y_list = new int[n];
        ans = new int[n*n];
        for(int i = 0;i<n;i++){
            x_list[i] = getInt();
        }
        for (int i = 0;i<n;i++){
            y_list[i] = getInt();
        }
        vis = new boolean[n][n];
        dfs(0,0,0);
        System.out.println(Arrays.toString(ans));
    }
    static boolean check(){
        for(int i = 0;i < n;i++){
            if(x_list[i] != 0 || y_list[i] != 0)
                return false;
        }
        return true;
    }
    static void dfs(int x,int y,int step){
        ans[step] = y*n + x;
        vis[x][y] = true;
        //拔剑
        x_list[x]--;
        y_list[y]--;
        if(x == n-1 && y == n-1 && check()){//到达终点
            success = true;
            for (int i = 0; i <= step; i++)//输出答案。
            {
                System.out.print(ans[i]+" ");
            }
            return;
        }
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i = 0;i<4;i++){
            //判断路径是否可走
            int nx = x+dir[i][0];
            int ny = y+dir[i][1];
            if(ny >= 0 && nx >= 0 && ny < n && nx < n && !vis[nx][ny] && !success){

                if(x_list[nx] > 0 && y_list[ny] > 0){
                dfs(nx,ny,step+1);
                //回溯
                vis[nx][ny] = false;
                x_list[nx]++;
                y_list[ny]++;
                }
            }

        }

    }

}
