import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] dp = new int[num+3];
        dp[1] = 1;
        dp[2] = 2;
        // 전에 활용한 계산값 이용(dp[n] * dp[0] + ... + dp[0] * dp[n])
        for(int i = 3; i <= num; i++){
            dp[i] = 2*dp[i-1];
            for(int j = i-2; j >= 0; j--){
                dp[i] += dp[j] * dp[i-j-1];
            } 
        }
        System.out.println(dp[num]);
    }
}