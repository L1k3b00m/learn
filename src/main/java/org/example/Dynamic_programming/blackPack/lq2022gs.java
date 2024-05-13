package org.example.Dynamic_programming.blackPack;

public class lq2022gs {
    static long[][] dp = new long[2023][11];
//    static long[][][] dp = new long[2023][11][2023];
    //dp解析 dp[i][j][k] 意思为，前i个物品中，选择j个进行加法，和为k的个数有多少个  物品的体积为下标
    public static void main(String[] args) {
//        //初始赋值
//        //因为dp[i][0][0] 意思为前i个物品，选着0个进行加法，和为0的个数，所以初始化为1
//        for(int i = 0;i<2023;i++){
//            dp[i][0][0] = 1;
//        }
//        for(int i = 1;i<2023;i++){
//            //枚举每个物品，权值为物品下标
//            for(int j = 1;j < 11;j++){
//                //枚举每种取法
//                for(int k = 1;k < 2023;k++){
//                    //枚举体积
//                    //两种取法，1.选择第i个物品
//                    //2.不选则第i个物品
//                    //不选
//                    dp[i][j][k] = dp[i-1][j][k];
//                    if(k >= i){
//                        dp[i][j][k] += dp[i-1][j-1][k-i];
//                    }
//                }
//            }
//        }
//        System.out.println(dp[2022][10][2022]);
        //对于二维数组 dp[i][j] 重量为i的情况下，前j的物品相加的方案数
        dp[0][0] = 1;
        for(int i = 1 ; i<=2022;i++){
            //枚举每个物品
            for(int j = 10 ; j >= 1;j--){
                //枚举物品数量
                for(int k = 1 ; k <= 2022;k++){
                    //枚举重量
                    if(k >= i){//可以放下
                        dp[k][j] += dp[k-i][j-1];
                    }
                }
            }
        }
        System.out.println(dp[2022][10]);
    }
}
