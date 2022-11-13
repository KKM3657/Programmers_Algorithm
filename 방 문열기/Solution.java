import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    public static int[] visited;
    public static int step = 0;
    public static Queue<Integer> q = new LinkedList<>();

    // 너비우선 탐색
    public static void bfs(int[] rooms) {
        while(!q.isEmpty()){
            int curr = q.poll();    // 현재 노드
            int next = rooms[curr] - 1; // 다음으로 이동할 노드
            if(visited[next] == 1){
                continue;
            }
            q.add(next);
            visited[next] = 1;
        }
    }
    public static int solution(int[] rooms){
        visited = new int[rooms.length];
        // 전체 그래프의 갯수 확인
        for(int i = 0; i < rooms.length; i++){
            if(visited[i] == 1) 
                continue;
            step++;
            q.add(i);
            visited[i] = 1;
            bfs(rooms); // 너비 우선 탐색
        }
        if(step == 1)
            return 1;
        else
            return step - 1;    // 방에서 키 하나를 바꾸는 경우 생각
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = st.countTokens();
        int[] rooms = new int[num];

        for(int i = 0; i < num; i++){
            rooms[i] = Integer.parseInt(st.nextToken());
        }

        int answer = solution(rooms);
        System.out.println(answer);
    }
}
