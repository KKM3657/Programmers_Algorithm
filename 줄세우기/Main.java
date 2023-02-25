import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] input = new int[N];
        int[] dp = new int[N];
        // 입력
        for(int i=0; i<N; i++) {
            input[i] = sc.nextInt();
        }
        // 초기화
        dp[0] = 1;

        int ans = 0;
        // LIS(최장 길이 수열)를 제외하고 이동
        for(int i=1; i<N; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(input[i]>input[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(N-ans);
    }
}