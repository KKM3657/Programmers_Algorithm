import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, S, ans = Integer.MAX_VALUE;
    static int[][] dp;
    static boolean[] visited;
    public static void dfs(int num, int start, int sum){    // dfs 탐색
        if(num == N-1){
            ans = Math.min(ans, sum);
        }
        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(num+1, i, sum + dp[start][i]);  // 해당 행성으로 이동
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][N];
        dp = new int[N][N];
        visited = new boolean[N];
        
        // 초기화
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                graph[i][j] = (int)1e9;
            }
            graph[i][i] = 0;
        }
        // 그래프 채우기
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(i != j && graph[i][j] == 0)
                    continue;
                dp[i][j] = graph[i][j];
            }
        }
        // 플로이드 워셜
        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        visited[S] = true;
        dfs(0,S,0); // dfs로 최단거리 탐색
        System.out.println(ans);
    }
}