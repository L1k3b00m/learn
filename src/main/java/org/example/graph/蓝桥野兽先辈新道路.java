package org.example.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class 蓝桥野兽先辈新道路 {
    static StreamTokenizer stk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static int getInt() {
        try {
            stk.nextToken();
            return (int) stk.nval;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    static int[][] graph = new int[(int)1e5 + 1][2];
    static int m;
    public static void main(String[] args) {
        int n = getInt();//城市数量
        m = getInt();//道路数量
        int q = getInt();//查询数量
        //输入格式为{u,v} -> 加入权值w 表示这个道路是在w天修好的
        for(int i = 0 ; i < m ; i++){
            int u = getInt();
            int v = getInt();
            graph[i] = new int[]{u,v};
        }
        System.out.println(dfs(3,5,0));
    }
    static int dfs(int u,int v,int w){
        if(u == v){
            return w;
        }else{
            if(w > m){
                return -1;
            }
        }

        if(graph[w][0] == u){
            return dfs(graph[w][0],v,w+1);
        }else if(graph[w][1] == u){
            return dfs(graph[w][1],v,w+1);
        }else{
            return dfs(u,v,w+1);
        }

    }
}
