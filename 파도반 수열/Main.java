import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        for(int i=6; i<101; i++){
            dp[i] = dp[i-5] + dp[i-1];
        }
        int T = sc.nextInt();
        for(int t=1; t<=T; t++){
            int N = sc.nextInt();
            System.out.println(dp[N]);
        }
    }
}