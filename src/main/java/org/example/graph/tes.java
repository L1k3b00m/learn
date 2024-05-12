package org.example.graph;

import java.util.Stack;

public class tes {
    static int VnumMAX = 10086;
    public static void main(String[] args) {
        //定义有权有向map 节点构成 {起点，终点，权重} 节点0 抛弃
        int[][] map = {{3,5,78},{2,1,1},{1,3,0},{4,3,59},
                {5,3,85},{5,2,22},{2,4,23},{1,4,43},
                {4,5,75},{5,1,15},{1,5,91},{4,1,16},
        {3,2,98},{3,4,22},{5,4,31},{1,2,0},
        {2,5,4},{4,2,51},{3,1,36},{2,3,59}};
        int VNum = 5;//节点总数
        int[] path = new int[VNum + 1];
        int[] dist = new int[VNum + 1];
        //两个工具数组的初始处理
        for(int i = 1 ; i <= VNum ; i++){
            path[i] = -1;
            dist[i] = Integer.MAX_VALUE;//一定要赋值为正无穷
        }
        Dijkstra(5,map,path,dist);
        //PrintS(path,1);
        for(int i : dist){
            System.out.println(i);
        }
    }
    static void Dijkstra(int s,int[][] map,int[] path,int[] dist ){
        int V;
        boolean[] Col = new boolean[VnumMAX];
        //初始化节点
        for(int[] v : map){
            if(v[0] == s){
                dist[v[1]] = v[2];
                path[v[1]] = s;
            }
        }
        dist[s] = 0;
        Col[s] = true;
        //DJ开始
        while(true){
            V = FindMinDistV(map,dist,Col);//寻找未访问的最小的DIST
            if(V == -10086){
                break;
            }
            Col[V] = true;//标记为访问过的节点
            for(int[] VT : map){//VT = {起点，终点，权重}
                if(VT[0] == V){//寻找V的邻接节点
                    if(VT[1] != Integer.MAX_VALUE)//需要做约束，要不然不存在的边会爆数组
                        if(!Col[VT[1]]){//未访问过的节点
                            if(dist[V] + VT[2] < dist[VT[1]] ){//V权重+VT权重 < 原有权重，则更新
                                dist[VT[1]] = dist[V] + VT[2];//更新
                                path[VT[1]] = V;//路径更新
                        }
                    }
                }
            }
        }
    }

    static int FindMinDistV(int[][] map, int[] dist, boolean[] col) {
        int minDist = Integer.MAX_VALUE;
        int minV = 0;
        for(int[] VT : map){//VT = {起点，终点，权重}
            if(!col[VT[0]] && dist[VT[0]] < minDist){
                minDist = dist[VT[0]];
                minV = VT[0];
            }
        }
        if(minDist < Integer.MAX_VALUE){
            return minV;
        }else{
            return -10086;
        }
    }
    static void PrintS(int[] path,int e){
        Stack<Integer> st = new Stack<>();//栈是一种后进先出序列
        st.push(e);
        var next = path[e];
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            if(next != -1){
                st.push(next);
                next = path[next];
            }else if(st.size() == 1){
                sb.append(st.pop());
            }else{
                sb.append(st.pop()).append("->");
            }
        }
        System.out.println(sb);
    }
}
