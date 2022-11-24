import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // dp table 초기화
        dp[1][n] = grid[1][n];
        // 1번 행 초기화
        for(int i=n-1; i>=1; i--){
            dp[1][i] = grid[1][i] + dp[1][i+1]; 
        }
        // n번 열 초기화
        for(int i=2; i<=n; i++){
            dp[i][n] = grid[i][n] + dp[i-1][n]; 
        }
        // dp table 채우기
        for(int i=2; i<=n; i++){
            for(int j=n-1; j>=1; j--){
                dp[i][j] = Math.min(dp[i][j+1], dp[i-1][j]) + grid[i][j];
            }
        }

        System.out.println(dp[n][1]);
    }
}