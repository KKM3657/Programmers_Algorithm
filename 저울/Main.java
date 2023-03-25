import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int N, M, temp;
    static int[][] graph;
    static int[] degree, cnt;
    static boolean[] visited;
    public static void dfs(int curr) {
        for(int i=0; i<N; i++){
            if(visited[i])
                continue;
            if(graph[curr][i] == 1){
                visited[i] = true;
                temp++;
                cnt[i]++;
                dfs(i);
            }
        }
    }
    public static void find_answer(){
        Queue<Integer> q = new LinkedList<>();
        boolean[] erase = new boolean[N];
        for(int i=0; i<N; i++){
            if(degree[i] == 0){
                q.add(i);
                erase[i] = true;
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i=0; i<N; i++){
                if(graph[curr][i] == 1)
                    degree[i]--;
            }
            visited = new boolean[N];
            visited[curr] = true;
            temp = cnt[curr];
            dfs(curr);
            cnt[curr] = temp;

            for(int i=0; i<N; i++){
                if(degree[i] == 0 && !erase[i]) {
                    q.add(i);
                    erase[i] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        degree = new int[N];
        cnt = new int[N];

        Arrays.fill(cnt, 1);

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            graph[a][b] = 1;
            degree[b]++;
        }

        find_answer();

        for(int i=0; i<N; i++){
            System.out.println(N - cnt[i]);
        }
    }
}