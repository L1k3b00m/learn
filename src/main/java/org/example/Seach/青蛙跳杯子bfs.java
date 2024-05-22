package org.example.Seach;

import java.util.*;

public class 青蛙跳杯子bfs {
    static String start;

    static String end;

    static int step = 0;

    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        start = sc.next();
        end = sc.next();
        bfs();
        System.out.println(step);
    }

    static void bfs(){
        int[] dir = {-3,-2,-1,1,2,3};
        Queue<String> que = new LinkedList<>();
        que.add(start);
        set.add(start);
        while(!que.isEmpty()){
            int qs = que.size();
            step++;//步速增加
            while(qs-- != 0){
                String cur = que.poll();
                int index = cur.indexOf('*');
                char[] chars = cur.toCharArray();
                for(int i = 0;i<6;i++){
                    if(index + dir[i] >=0 && index+dir[i]<start.length()){
                        swap(chars,index,index+dir[i]);//交换位置
                        String str = String.valueOf(chars);
                        if(!set.contains(str)){//去重
                            if(str.equals(end)) return;//一旦找到答案直接退出
                            set.add(str);
                            que.add(str);
                        }
                        swap(chars,index,index+dir[i]);//还原位置
                    }

                    }
            }
        }

    }
    static void swap(char[] chars ,int i ,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
