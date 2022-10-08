import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int vertex;
    static int edge;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static int cnt = 0;
    // 깊이 우선 탐색
    public static void dfs(int vertex){
        for(int curr_v : graph.get(vertex)){
            if(visited[curr_v] != 1){
                cnt += 1;
                visited[curr_v] = 1;
                dfs(curr_v);
            }
        } 
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        visited = new int[vertex+1];
        // Arraylist 초기화
        for(int i = 0; i < vertex + 1; i++){
            ArrayList<Integer> dumy= new ArrayList<>();
            graph.add(dumy);
        }

        // 엣지 추가
        for(int i = 0; i < edge; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        // for(int i = 1; i < vertex+1; i++){
        //     System.out.println(graph.get(i));
        // }
    
        // 시작 지점 설정
        int rootNode = 1;
        visited[rootNode] = 1;
        dfs(rootNode);
        System.out.println(cnt);

    }
}