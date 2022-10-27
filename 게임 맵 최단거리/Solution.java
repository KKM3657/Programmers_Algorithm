import java.util.Queue;
import java.util.LinkedList;
// 격자를 나타내기 위한 클래스
class Pair{
    int x, y;
    
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    static int n, m;    // 격자 길이
    static Queue<Pair> q = new LinkedList<>();  // bfs를 위한 큐
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};
    static int[][] visited; // 방문 기록
    static int[][] step;    // 최단 거리
    
    // 격자 내 범위인지
    public boolean in_range(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < m;
    }
    
    // 다음으로 이동 가능한지 판별
    public boolean can_go(int[][] maps, int x, int y){
        if(!in_range(x,y))
            return false;
        if(maps[x][y] == 0 || visited[x][y] == 1)
            return false;
        return true;
    }
    
    // 너비우선 탐색
    public void bfs(int[][] maps){
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int x = curr.x, y = curr.y;
            // 갈 수있는 곳 전부 이동
            for(int i = 0; i < 4; i++){
                // 다음으로 이동할 위치
                int next_x = x + dx[i], next_y = y + dy[i];
                if(can_go(maps, next_x, next_y)){
                    q.add(new Pair(next_x, next_y));
                    visited[next_x][next_y] = 1;
                    step[next_x][next_y] = step[x][y] + 1;
                }
            }
        }
    }
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];
        step = new int[n][m];
        // 초기화
        step[0][0] = 1;
        visited[0][0] = 1;
        q.add(new Pair(0,0));
        bfs(maps);
        
        int answer = (step[n-1][m-1] == 0) ? -1 : (step[n-1][m-1]);
        return answer;
    }
}