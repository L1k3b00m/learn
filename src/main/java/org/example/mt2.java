package org.example;

import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class mt2 {
    static int n,m;
    static StreamTokenizer stk = new StreamTokenizer(new java.io.BufferedReader(new java.io.InputStreamReader(System.in)));

    static int[][] graph = new int[1050][1050];
    static boolean[][] vis = new boolean[1050][1050];
    //构建一个点图
    static int getInt(){
        try{
            stk.nextToken();
            return (int)stk.nval;
        }catch(Exception e){
            return -1;
        }
    }

    public static void main(String[] args) {
        n = getInt();
        m = getInt();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                graph[i][j] = getInt();
            }
        }
        node end = new node((1+n)/2, (1+m)/2, graph[(1+n)/2][(1+m)/2]);//在中点相见
        int sum = 0;
        node start = new node(1,1,graph[1][1]);
        sum += dijkstra(start,end);
        start = new node(n,m,graph[n][m]);
        sum += dijkstra(start,end);
        System.out.println(sum - graph[(1+n)/2][(1+m)/2]);//因为中心点会被同时算两次，去重
    }
    static class node{
        int x;
        int y;
        int value;
        public node(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    static int dijkstra(node start,node end){{
        int sum = start.value;
            PriorityQueue<node> pq = new PriorityQueue<>((a,b)->b.value-a.value);
            pq.add(start);
            while(!pq.isEmpty()){
                node now = pq.poll();
                if(now.x == end.x && now.y == end.y) break;//检查是否到达终点
                if(vis[now.x][now.y])continue;
                vis[now.x][now.y] = true;//标记访问
                int[][] path = {{0,1},{0,-1},{1,0},{-1,0}};//上下左右
                int x = now.x;
                int y = now.y;
                int max = Integer.MIN_VALUE;
                int max_value = 0;
                for(int i = 0; i < 4;i++){
                    int idx = x + path[i][0];
                    int idy = y + path[i][1];
                    if(max < graph[idx][idy] + sum){//如果当前点+总和大于最大值，则更新最大值
                        max = graph[idx][idy] + sum;
                        if(!vis[idx][idy]){
                            max_value = graph[idx][idy];//保存当前点的值，必须是未访问过的
                        pq.add(new node(idx,idy,graph[idx][idy]));//添加进队列中
                        }
                    }
                }

                sum += max_value;
            }
            return sum;
    }
    }
}
