import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        // 누적 합 dp 채우기
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++)
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i][j];
        }

        int answer = 0;
        // 정사각형 크기 숫자들의 합 최대 구하기
        for(int i=k; i<=n; i++){
            for(int j=k; j<=n; j++)
                answer = Math.max(answer, dp[i][j] - dp[i-k][j] - dp[i][j-k] + dp[i-k][j-k]);
        }
        System.out.println(answer);
    }
}