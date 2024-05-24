package org.example.Dynamic_programming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class 对局匹配 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        int max_num = 0;
        int[] arr = new int[N+5];
        int[] sor = new int[N+5];
        for(int i = 0;i < N;i++){
            arr[i] = sc.nextInt();
            max_num = Math.max(max_num,arr[i]);
            sor[arr[i]]++;
        }
        if(k == 0){//只需统计出现过的元素即可
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0;i < N;i++){
                set.add(arr[i]);
            }
            System.out.println(set.size());
            System.exit(0);
        }

        int count = 0;
        //分为K个组
        for(int i = 0; i < k;i++){
            int index = 0;
            //分组为(i,i+k,i+2k+......) 这样子就转化为打家劫舍问题，邻近的不能选
            int[] dp = new int[N];
            int[] val = new int[N];
            for(int j = i; j <= max_num; j+=k){
                val[index] = sor[j];
                index++;
            }
            dp[0] = val[0];//初始化
            for(int j = 1;j < index;j++){
                if(j == 1)dp[1] = Math.max(val[0], val[1]);
                else{
                    dp[j] = Math.max(dp[j - 1],dp[j - 2] + val[j]);//选或者不选
                }
            }
            count += dp[index - 1];
        }
        System.out.println(count);

    }
}
