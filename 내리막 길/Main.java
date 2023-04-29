// 백준 DFS,DP(1520)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[][] grid;
    static int[][] dp;
    static int answer = 0;
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    public static int dfs(int cx, int cy){
        if(cx == N-1 && cy == M-1){ // 끝 지점이면 반환
            return 1;
        }
        if(dp[cx][cy] != -1){   // 이미 탐색이 완료된 점은 바로 반환
            return dp[cx][cy];
        }
        dp[cx][cy] = 0; // 0으로 초기화 후 탐색시작

        for(int i=0; i<4; i++){
            int nx = cx + dx[i], ny = cy + dy[i];   // 다음 지점
            if(0 > nx || nx >= N || 0 > ny || ny >= M)
                continue;

            if(grid[cx][cy] > grid[nx][ny]){    // 조건을 만족하는 경우
                dp[cx][cy] += dfs(nx,ny);
            }
        }
        return dp[cx][cy];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        dp = new int[N][M];
        for(int i=0; i<N; i++)
            Arrays.fill(dp[i], -1);

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(dfs(0,0));
    }
}