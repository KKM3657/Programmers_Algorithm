import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[][] graph, dp, temp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N+1][M+1];
        dp = new int[N+1][M+1];
        temp = new int[2][M+2]; // 왼쪽, 오른쪽 비교를 위한 임시 배열

        // 입력
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 초기화
        dp[1][1] = graph[1][1];
        for(int i=2; i<=M; i++){
            dp[1][i] = graph[1][i] + dp[1][i-1];
        }
        
        for(int i=2; i<=N; i++){
            // 왼쪽 채우기
            temp[0][0] = dp[i-1][1];
            for(int j=1; j<=M; j++)
                temp[0][j] = Math.max(temp[0][j-1], dp[i-1][j]) + graph[i][j];
            // 오른쪽 채우기
            temp[1][M+1] = dp[i-1][M];
            for(int j=M; j>0; j--)
                temp[1][j] = Math.max(temp[1][j+1], dp[i-1][j]) + graph[i][j];
            // 왼쪽 오른쪽 비교
            for(int j=1; j<=M; j++){
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }
        System.out.println(dp[N][M]);
    }
}