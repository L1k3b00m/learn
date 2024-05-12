package org.example.graph;
import java.util.*;

public class p1117 {
    static int[][] map;
    static int n;
    static boolean[][] vis;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        map = new int[n+5][n+5];
        vis = new boolean[n+5][n+5];
        for(int i = 1;i <= n;i++){
            for(int j = 1; j <= n;j++){
                map[i][j] = scan.nextInt();
                if(map[i][j] == 0) map[i][j] = 2;
            }
        }
        bfs(0,0);
        for(int i = 1; i <= n;i++){
            for(int j = 1; j <= n;j++){
                System.out.print(map[i][j]);
            }
            System.out.print("\n");
        }


    }
    public static void bfs(int x,int y) {
        Queue<p> que = new LinkedList<>();
        que.offer(new p(x,y));
        int[][] routes = {{1,0},{0,1},{-1,0},{0,-1}};
        vis[x][y] = true;
        while(!que.isEmpty()){
            p p = que.poll();
            int px = p.getX();
            int py = p.getY();
            for(int i = 0 ; i < 4;i++){//从四个方向上搜索
                int dx = px+routes[i][0];
                int dy = py+routes[i][1];
                if(dx >= 0 && dy >= 0 && dx <= n + 1 && dy <= n + 1 && !vis[dx][dy] && map[dx][dy] != 1){
                    que.offer(new p(dx,dy));
                    map[dx][dy] = 0;
                    vis[dx][dy] = true;
                }
            }
        }
    }
}
class p{
    private final int x;
    private final int y;
    p(int x,int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

