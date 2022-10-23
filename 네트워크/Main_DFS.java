class Solution {
    static int answer = 0;
    static int[] visited;
    // dfs 이용
    public void dfs(int n, int[][] computers, int vertex){
        for(int cur_v = 0; cur_v < n; cur_v++){
            if(computers[vertex][cur_v] == 1 && (visited[cur_v] != 1)){
                    //System.out.println(cur_v + " " + next_v);
                    visited[cur_v] = 1; // 현재 노드 방문
                    dfs(n,computers,cur_v);
                }
        }
    }
    public int solution(int n, int[][] computers) {
        visited = new int[n]; // 노드 방문을 확인할 배열
        
        for(int i = 0; i < n; i++){ // 모든 노드 순회
            if(visited[i] == 1) // 이미 방문한 노드가 있으면 넘어감
                continue;
            answer++;   // 연결되지 않은 노드가 있는 경우
            visited[i] = 1;
            dfs(n,computers,i);
        }
        return answer;
    }
}