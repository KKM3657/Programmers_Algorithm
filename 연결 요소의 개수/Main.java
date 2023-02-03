import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] graph;   // 인접행렬
    static boolean[] visited;   // 방문기록
    public static void dfs(int curr) {
        for(int i=0; i<N; i++) {    // 간선을 따라 노드 순회
            if(graph[curr][i] == 1 && !visited[i]) {    // 연결성 확인 및 방문기록 확인
                visited[i] = true;
                dfs(i);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];

        // 그래프 추가
        graph = new int[N][N]; 
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        int answer = 0;
        for(int i=0; i<N; i++) {    // 연결성 확인
            if(visited[i] == true)  // 이미 방문했으면 넘어감
                continue;
            answer++;
            dfs(i);
        }
        System.out.println(answer);
    }
}