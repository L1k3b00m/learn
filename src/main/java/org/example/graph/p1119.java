package org.example.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p1119 {
   static int inf = 10086;
    public static void main(String[] args) {
        //init
        //N个村庄和M条路
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n][n];//建图
        for(int i = 0; i < n;i++){
            Arrays.fill(graph[i],inf);
            graph[i][i] = 0;//点到自己为0
        }
        int[] t_list = new int[n+10];
        for(int i = 0; i < n;i++){
            t_list[i] = sc.nextInt();//重建时间
        }
        for(int i = 0;i < m;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = graph[y][x] = sc.nextInt();//导入图，表示为从i到j有一条道路 长度为k
        }
        int q = sc.nextInt();
        int now = 0;
        for(int i = 0 ; i < q;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int t = sc.nextInt();
            while(t_list[now] <= t && now < n){//如果当前节点在当前时间之前，更新
                floyd(graph,now);
                now++;
            }
            if(t_list[x] > t || t_list[y] > t) System.out.println("-1");//村庄未建好
            else{
                if(graph[x][y] == inf) System.out.println("-1");//没有道路
                else System.out.println(graph[x][y]);//输入路径长度
            }
        }
    }
    static void floyd(int[][] graph,int k){
        for(int i = 0;i < graph.length;i++){
            for(int j = 0; j < graph.length;j++){
                if(graph[i][j] > graph[i][k] + graph[k][j]){
                    graph[i][j] = graph[i][k] + graph[k][j];//更新路径
                }
            }
        }
    }
}
