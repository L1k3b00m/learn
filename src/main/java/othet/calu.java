package othet;
/**
 *
 * 计算类
 *
 * **/
public class calu {
    static int mod = 1000000007;
    public static void main(String[] args) {
        System.out.println(2024*2.5);
    }
    static long fpow(int a,int b){
        long res = 1;
        a%= 7;
        while (b >0){
            if(b%2 == 1){
                res = res * a % 7;
            }
            a = a * a % 7;
            b/=2;
        }
        return res;
    }
}
