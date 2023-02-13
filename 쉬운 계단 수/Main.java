import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        // dp 테이블 초기화
        int[][] dp = new int[101][10];
        // 일의 자리
        for(int i=1; i<10; i++){
            dp[1][i] = 1;
        }
        // 100의 자리까지 구현
        for(int i=2; i<=100; i++) {
            // 마지막 자리수가 0인 경우 -> 1에서 옴
            dp[i][0] = dp[i-1][1];
            // 마지막 자리수가 1부터 8인 경우 -> -1, +1에서 옴
            for(int j=1; j<=8; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }
            // 마지막 자리수가 9인 경우 -> 8에서 옴
            dp[i][9] = dp[i-1][8] % 1000000000;
        }
        long answer = 0;
        // 총합
        for(int i=0; i<=9; i++)
            answer = (answer + dp[N][i]) % 1000000000;
        System.out.println(answer);
    }
}