package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
        //SPFA(s);
        for(int i = 1; i <= n;i++){
            System.out.print(dist[i] + " ");
        }
    }
    static void bellman_ford(int s){
        long strat = System.nanoTime();
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
        System.out.println(System.nanoTime() - strat);
    }
    static void SPFA(int s){
        long start = System.nanoTime();
        //基于队列优化的Bellman-Ford算法
        Arrays.fill(dist,0xffff);
        dist[s] = 0;
        //入队{v,
        Queue<Integer> que = new LinkedList<>();
        que.add(s);
        while(!que.isEmpty()){
            int u = que.poll();
            //遍历该点的邻接边
            for(int i = head[u]; i != -1;i = edges[i].next){
                if(dist[edges[i].to] > dist[u] + edges[i].weight){
                    dist[edges[i].to] = dist[u] + edges[i].weight;
                    que.add(edges[i].to);
                }
            }
        }
        System.out.println(System.nanoTime() - start);
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
