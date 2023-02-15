import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] dp = new int[1001][10]; // dp테이블 생성
        
        // 초기화
        for(int i=0; i<=9; i++)
            dp[1][i] = 1;

        // 마지막에 온 숫자보다 작은 경우 다 더하기
        for(int i=2; i<=1000; i++) {
            for(int j=0; j<=9; j++) {   // 마지막 자릿수
                for(int k=0; k<=j; k++) // 마지막 자릿수보다 작은 모든 경우
                    dp[i][j] = (dp[i][j] + dp[i-1][k]) % 10007;
            }
        }

        long answer = 0;
        // 결과
        for(int i=0; i<=9; i++){
            answer = (answer + dp[N][i]) % 10007;
        }
        System.out.println(answer);
    }
}