import java.util.Arrays;
import java.util.ArrayList;
class Solution {
    static int N, M, value;
    static char[][] graph;  // 격자점
    static boolean[][] visited; // 방문기록
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    public void dfs(int cx, int cy){
        for(int i=0; i<4; i++){ // 4방향 탐색
            int nx = cx + dx[i], ny = cy + dy[i];   // 다음 지점
            if(0 > nx || nx >= N || 0 > ny || ny >= M)
                continue;
            if(graph[nx][ny] != 'X' && !visited[nx][ny]){   // 지도 식량 더하기
                value += Character.getNumericValue(graph[nx][ny]);
                visited[nx][ny] = true;
                dfs(nx,ny);
            }
        }
    }
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        graph = new char[N][M];
        visited = new boolean[N][M];
        ArrayList<Integer> al = new ArrayList<>();
        // 격자점 만들기
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                graph[i][j] = maps[i].charAt(j);
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                // X면 지나감
                if(visited[i][j] || graph[i][j] == 'X')
                    continue;
                // 초기화
                value = Character.getNumericValue(graph[i][j]);
                visited[i][j] = true;
                dfs(i,j);
                al.add(value);
            }
        }
        // X만 있는 경우
        if(al.size() == 0){
            int[] answer = new int[]{-1};
            return answer;
        }
        // 오름차순 정렬
        else{
            int[] answer = new int[al.size()];
            for(int i=0; i<al.size(); i++){
                answer[i] = al.get(i);
            }
            Arrays.sort(answer);
            return answer;    
        }
    }
}