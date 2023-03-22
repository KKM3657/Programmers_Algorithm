import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;

public class Main {
	static int N, M;
	static int[][] graph;	// 그래프
	static int[] trip;	// 여행 경로
	static HashSet visited = new HashSet();	// 방문기록을 저장하기 위한 Set
	public static void dfs(int curr){	 // 깊이 우선 탐색
		// 연결된 노드 탐색
		for(int i=0; i<N; i++){
			if(visited.contains(i)) // 방문 기록있으면 넘어감
				continue;
			if(graph[curr][i] == 1){// 연결된 다음 노드 이동
				visited.add(i);
				dfs(i);
			}
		}
	}
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new int[N][N];
		trip = new int[M];

		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++){
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++){
			trip[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		visited.add(trip[0]);
		dfs(trip[0]);
		
		// 방문했던 지역에 여행 계획에 포함되지 않는 경우 No 
		for(int i=0; i<M; i++){
			if(!visited.contains(trip[i])){
				System.out.println("NO");
				System.exit(0);
			}
		}
		System.out.println("YES");
    }
}