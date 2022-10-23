import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int n, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();  // BFS를 위한 Queue 생성
        int[] visited = new int[n]; // 노드 방문을 확인할 배열
        int answer = 0;
        
        for(int i = 0; i < n; i++){ // 모든 노드 순회
            if(visited[i] == 1) // 이미 방문한 노드가 있으면 넘어감
                continue;
            answer++;   // 연결되지 않은 노드가 있는 경우
            q.add(i);   // BFS를 위해 push
            while(!q.isEmpty()){    // 연결된 노드를 모두 순회
                int cur_v = q.poll();   // 다음으로 이동할 노드
                for(int next_v = 0; next_v < n; next_v++){  // 연결된 노드 확인 및 방문 여부 확인
                    if(computers[cur_v][next_v] == 1 && (visited[next_v] != 1)){
                        //System.out.println(cur_v + " " + next_v);
                        q.add(next_v);  // 다음으로 이동할 노드
                        visited[cur_v] = 1; // 현재 노드 방문
                    }
                }                   
            }
        }
        return answer;
    }
}