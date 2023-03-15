import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
// 노드 클래스
class Node{
    int p;
    int v;

    Node(int p, int v){
        this.p = p;
        this.v = v;
    }
}
public class Main {
    static int N;
    static ArrayList<Node> graph;   // 그래프
    // 공통 조상 노드 찾기
    public static int find_node(int n1, int n2){
        int answer = 0;
        boolean[] visited = new boolean[N+1];   // 방문 기록
        // n1노드의 조상 노드 찾기
        while(true){
            if(visited[n1]){
                break;
            }
            visited[n1] = true;
            n1 = graph.get(n1).p;
        }
        // n2노드의 조상 노드를 찾으면서 공통 조상이면 종료
        while(true){
            if(visited[n2]){
                answer = n2;
                break;
            }
            visited[n2] = true;
            n2 = graph.get(n2).p;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            // 노드 정보 초기화
            N = Integer.parseInt(br.readLine());
            graph = new ArrayList<>();
            for(int i=0; i<=N; i++){
                graph.add(new Node(i,i));
            }
            // 그래프 입력
            for(int i=0; i<N-1; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph.get(v).p = p;
            }
            // 노드 설정
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            System.out.println(find_node(n1, n2));
        }
    }
}