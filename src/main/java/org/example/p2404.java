package org.example;

import java.util.Arrays;
import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class p2404 {
    static int inf = 10086;
    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0,inf,1,inf, 10},
                {inf, 0,inf,1, 15},
                {inf, 1, 0,inf, 7,},
                {inf, inf, inf, 0 ,  1},
                {inf, inf, inf, inf,0}};
        int[][] path = new int[graph.length][graph[0].length];
        for(int i = 0; i < graph.length;i++){
            for(int j = 0;j < graph[0].length;j++){
                if(graph[i][j] != inf && graph[i][j] != 0){
                    path[i][j] = i;//存储前驱点
                }else{
                    path[i][j] = -1;
                }
            }
        }

        floyd(graph,path);
        for(int[] g : graph){
            System.out.println(Arrays.toString(g));
        }
    }

    static void floyd(int[][] graph,int[][] path){
        //以每个点为中转（前驱节点）
        //从i
        for(int i = 0; i < graph.length;i++){
            //从i
            for(int j = 0;j < graph[i].length;j++){
                //到j
                for(int k = 0;k < graph[j].length;k++){
                    //以每个点为中转，计算最短距离
                    int a = graph[i][k] + graph[k][j];
                    if(a < graph[i][j]){
                        graph[i][j] = a;
                        path[i][j] = k;
                    }
                }
            }
        }
    }
}