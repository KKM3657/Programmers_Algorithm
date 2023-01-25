import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] arr = new int[2][n];
            int[][] dp = new int[3][n];

            for(int i=0; i<2; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            dp[0][0] = 0;   // 선택 x
            dp[1][0] = arr[0][0];   // 1번 선택
            dp[2][0] = arr[1][0];   // 2번 선택

            for(int i=1; i<n; i++) {
                //선택x
                dp[0][i] = Math.max(dp[1][i-1], dp[2][i-1]);
                
                //선택o
                dp[1][i] = Math.max(dp[0][i-1], dp[2][i-1]) + arr[0][i];    // 1번 선택
                dp[2][i] = Math.max(dp[0][i-1], dp[1][i-1]) + arr[1][i];    // 2번 선택
            }
            int answer = 0;
            for(int i=0; i<3; i++) {
                answer = Math.max(answer, dp[i][n-1]);
            }
            System.out.println(answer);
        }
    }
}