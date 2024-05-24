package org.example.Dynamic_programming.blackPack.blackpack01;

import org.example.Seach.青蛙跳杯子bfs;

import java.util.*;

public class 原批 {
    /*
    夏天来临，旅行者受可莉邀请来到了一个名为 "仲夏！幻夜？奇想曲！" 的音乐盛典。旅行者需要收集不同种类的魔法音符来完成曲目。这些魔法音符分布在
    n 个岛屿上，每个岛屿都有其特定的音符。岛屿之间存在依赖关系，即访问某些岛屿可能需要先访问其他岛屿并收集到特定音符。
    旅行者的背包有容量限制W，需要选择合适的音符组合来完成曲目。给定岛屿的依赖关系和每个岛屿上音符的价值与重量，
    请帮助旅行者计算如何选择音符以得到最大的价值。

    典型的01背包
    * */

    public static void main(String[] args) {
        //dp定义 dp[i][j] 前i个音符，选择背包容量为j时的最大价值
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int W = sc.nextInt();
        int[] weight = new int[n+5];
        int[] value = new int[n+5];
        for(int i = 1;i <= n;i++){
            value[i] = sc.nextInt();
            weight[i] = sc.nextInt();
        }
        //建立邻接表
        List<List<Integer>> graph = new LinkedList<>();
        for(int i = 0;i <= n;i++){
                graph.add(new LinkedList<>());
        }
        int linked = sc.nextInt();
        int[] zero_deg = new int[n+5];
        for(int i = 1;i <= linked;i++){
            int to = sc.nextInt();
            int from = sc.nextInt();
            graph.get(from).add(to);
            zero_deg[to]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i = 1;i <= n;i++){
            if(zero_deg[i] == 0){
                q.add(i);
            }
        }
        //拓扑排序
        List<Integer> topo = new LinkedList<>();
        while(!q.isEmpty()){
            int u = q.poll();
            topo.add(u);//添加进节点
            for(int v : graph.get(u)){
                if(--zero_deg[v] == 0) q.add(v);//检察该点的所有入度，保证没有回环
            }
        }
        //dp开始

        int[] dp = new int[W+5];
        for(int u:topo){
            for(int k = W ; k >= 1;k--){
                if(k - weight[u] >= 0)
                    dp[k] = Math.max(dp[k],dp[k-weight[u]] + value[u]);
            }
        }
        System.out.println(dp[W]);
        System.out.println(topo);
    }

}
