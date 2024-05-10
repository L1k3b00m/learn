package org.example;

import java.io.*;
import java.util.*;

public class p4779 {
    private static StreamTokenizer stk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static int[] head = new int[2 * (int)1e5 + 1];
    static  int cnt = 0;
    static  int n;
    static int m;
    static edge[] edges = new edge[2 * (int)1e5 + 1];

    static boolean[] vis = new boolean[(int)1e5 + 1];
    static int[] dist =  new int[(int)1e5 + 1];
    public static void main(String[] args) {//链表法
        n = getInt();
        m = getInt();
        int s = getInt();
        /*邻接表法
        * int[][] graph = new int[n+1][n+1];
        * */
        //链表法（尾插）
        /*
            List<List<int[]>> list = new ArrayList<>();
            for(int i = 1;i<=n;i++){
                list.add(new ArrayList<>());
            }
            for(int i=0;i<m;i++){
                    int u = sc.nextInt();
                    int v = sc.nextInt();
                    int w = sc.nextInt();
                    List<int[]> list1 = list.get(u);
                    list1.add(new int[]{v, w});
                    list.set(u,list1);
            }

            //输出
            for(List<int[]> l : list){
                for(int[] i : l){
                    System.out.print(Arrays.toString(i) + " ");
                }
                System.out.println("\n" + "-----------");
            }
        */
        //链式前向星又称为链表法（头插）
        init();
        for(int i = 0; i < m;i++){//m条边
            int u = getInt();
            int v = getInt();
            int w = getInt();
            add_edge(u,v,w);
        }
        /* 输出
        for(int i = 1; i <= n;i++){
            //遍历i个节点
            System.out.println(i);
            for(int j = head[i];j!=-1;j = edges[j].next){
                //遍历i的所有临接边
                System.out.print("["+i + "," + edges[j].to + "," + edges[j].weight+"]" + " ");
            }
            System.out.print("\n");
            System.out.println("-------------------");
        }
        */
        Dijkstra(s);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n;i++){
            sb.append(dist[i]);
            sb.append(" ");
        }
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        out.print(sb);
        out.flush();
    }
    public static int getInt(){
        try{
        stk.nextToken();}catch (IOException e){
            e.printStackTrace();
        }
        return (int) stk.nval;
    }
    public static void init(){
        Arrays.fill(head,-1);
        cnt = 0;
    }
    public static void add_edge(int u, int v, int weight){
        edges[cnt] = new edge();//新建边
        edges[cnt].to = v;
        edges[cnt].weight = weight;
        edges[cnt].next = head[u];
        head[u] = cnt++;//先赋值完再加加
    }
    static class edge{
        int to;//终止节点
        int weight;//权值
        int next;//下一个节点
    }

    static class node {
        int ponit; // 下一个
        int weight;

        public node(int ponit, int weight) {
            this.ponit = ponit;
            this.weight = weight;
        }


    }
    static void Dijkstra(int s){//堆优化版本
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[s] = 0;
        //压入格式为{v,w}
        PriorityQueue<node> que = new PriorityQueue<>((a,b) -> a.weight - b.weight);//从小到大

        que.offer(new node(s,0));

        while(!que.isEmpty()){
            node now_point = que.poll();
            int u = now_point.ponit;
            int w = now_point.weight;
            if(vis[u]) continue;//将该点置为已访问
            vis[u] = true;
            //遍历该点的所有邻接点
            for(int i = head[u]; i != -1; i = edges[i].next){;
                int v = edges[i].to;//到达点
                //如果dist[到达点] > 当前点的最短距离+到达下一个点的距离 置换
                if(dist[v] > w + edges[i].weight){
                    dist[v] = w + edges[i].weight;
                    if(!vis[v]){
                        que.offer(new node(v,dist[v]));
                    }
                }
            }
        }
    }
}
