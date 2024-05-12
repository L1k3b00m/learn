package org.example.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class tas1 {
    static int cnt;
    static int n;
    static int m;
    static int[] head = new int[1000];
    static edge[] edges = new edge[1000];
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        m = sc.nextInt();
//        int s = sc.nextInt();
//    //链式前向星
//        init();
//        for(int i = 0; i < m;i++){
//            int u = sc.nextInt();
//            int v = sc.nextInt();
//            int w = sc.nextInt();
//            add_edge(u,v,w);
//        }
//        for(int i = 0; i < n;i++){
//            for(int u = head[i];u != -1 ; u = edges[u].next){
//                System.out.print(" ["+u + " " + edges[u].to + " " + edges[u].weight+ "] ");
//            }
//            System.out.println("\n"+"---------------------");
//        }
        Integer[] a = {23, 76, 45, 89, 12, 37, 5, 31, 54, 6};
        Arrays.sort(a,((o1, o2) -> o2 - o1));
        System.out.println(Arrays.toString(a));

    }
    static void add_edge(int u ,int v ,int w){
        edges[cnt] = new edge();
        edges[cnt].to = v;
        edges[cnt].weight = w;
        edges[cnt].next = head[u];
        head[u] = cnt++;
    }
    static void init(){
        cnt = 0;
        Arrays.fill(head,-1);
    }
    static class edge{
        int to;
        int weight;
        int next;
    }

}
