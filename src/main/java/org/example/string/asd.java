package org.example.string;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class asd {

    public static void main(String[] args) {
        System.out.println(kmp("aabaabaaf","aabaac"));
    }

    public static int[] get_next(String parrt){
        int[] next = new int[parrt.length()];
        next[0] = 0;
        int j  = 0;
        for(int i = 1; i < parrt.length(); i++){
            while(j > 0 && parrt.charAt(i) != parrt.charAt(j)) j = next[j - 1];
            if(parrt.charAt(i) == parrt.charAt(j)){
                j++;
                next[i] = j;
            }
        }
        return next;
    }
    public static boolean kmp(String str, String parrt){
        //获取next数组(只与模式串有关)
        int[] next = get_next(parrt);
        //进入kmp
        int j = 0;
        for(int i = 0; i < str.length(); i++){
            //循环匹配
            while(j > 0 && str.charAt(i) != parrt.charAt(j)) j = next[--j];//检查不匹配的上一位在next中的位置，直接跳转到该位置，在该位置继续匹配
            if(str.charAt(i) == parrt.charAt(j)) j++;//匹配成功，j++
            if(j == parrt.length()){
                return true;//当长度等于模式长度则为匹配成功
            }
        }
        //越界
        return false;
    }
}
