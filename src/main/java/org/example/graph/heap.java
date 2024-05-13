package org.example.graph;

import java.util.PriorityQueue;

public class heap {
    public static void main(String[] args) {
        int[] arr = {100,5,3,11,33,6,8,7};
        //关于heap
        /*这是一个完全二叉树（即所有元素在数组中下标是连续的）
        * 堆的特性: 对于每一个节点，他的儿子只能大于（最小堆）或者小于他（最大堆）
        * 实现方式：优先队列*/
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2 - o1);
        for(int i = 0;i < arr.length;i++){
            pq.add(arr[i]);
        }
        for(int i = 1;!pq.isEmpty();i*=2){
            for(int j = 0; j < i;j++){
                System.out.print(pq.poll() + " ");
                if(pq.isEmpty()) break;
            }
            System.out.println("\n");
        }
    }

}
