package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
public class bellman_ford_SPFA {
    static int[] dist;

    static int n,m;
    static edge[] edges;

    static int cnt = 0;
    static int[] head;

    static StreamTokenizer stk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) {
        n = getInt();
        dist = new int[n+50];
        m = getInt();
        int s = getInt();
        init(m);
        for(int i = 0; i < m;i++){
            add_edge(getInt(),getInt(),getInt());
        }
        bellman_ford(s);
        for(int i = 1; i <= n;i++){
            System.out.println(dist[i]);
        }
    }
    static void bellman_ford(int s){
        Arrays.fill(dist,0xffff);
        dist[s] = 0;
        //枚举n-1次
        for(int i = 1; i <= n-1;i++){
            int cheak = 0;
            //枚举每一条边
            for(int j = 0; j <m;j++){
                //每个节点
                for(int k = head[j] ; k != -1 ; k = edges[k].next){
                    //j->edges[k].to
                    //当到点dist[v] > dist[j] + edges[k].to
                    int v = edges[k].to;
                    if(dist[v] > dist[j] + edges[k].weight){
                        cheak = 1;
                        dist[v] = dist[j] + edges[k].weight;
                    }
                }

            }
            if (cheak == 0){
                //如果全部边都已经验证完全，则可以直接退出
                break;
            }
        }
    }
    static void SPFA(int s){
        //基于队列优化的Bellman-Ford算法
        
    }
    static int getInt(){
        try {
            stk.nextToken();
            return (int) stk.nval;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static void init(int m){
        edges = new edge[m+2];
        head = new int[m+2];
        Arrays.fill(head,-1);
    }
    static void add_edge(int u ,int v,int w){
        edges[cnt] = new edge();
        edges[cnt].to = v;
        edges[cnt].weight = w;
        edges[cnt].next = head[u];
        head[u] = cnt++;
    }
}
