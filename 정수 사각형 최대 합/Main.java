import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] grid;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        // 입력값 배열 및 dp 배열 생성
        grid = new int[n][n];
        dp = new int[n][n];
        // 초기 입력값
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // dp 초기값 채우기
        dp[0][0] = grid[0][0];
        for(int i=1; i<n; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        // 나머지 빈칸 채우기(아래 있는 수 vs 오른쪽 수)
        for(int i=1; i<n; i++){
            for(int j = 1; j<n; j++){
                dp[i][j] = dp[i-1][j] > dp[i][j-1] ? dp[i-1][j] + grid[i][j] : dp[i][j-1] + grid[i][j];
            }
        }
        
        System.out.println(dp[n-1][n-1]);
    }
}