import java.util.Scanner;

public class Main {
    // 계단 찾기
    public static int find_stair(int n){
        int[]dp = new int[n+1];
        // 초기값 설정
        if(n < 4){
            return 1;
        }
        dp[2] = 1; dp[3] = 1;
        // 이전에 올라온 계단 확인
        for(int i = 4; i <= n; i++){
            dp[i] = (dp[i-2] + dp[i-3]) % 10007;
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(find_stair(n));
    }
}