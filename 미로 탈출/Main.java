import java.util.Queue;
import java.util.LinkedList;
// 좌표를 나타내기 위한 클래스
class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    static char[][] grid;   // 격자점
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    static int N, M;
    static Pair start, end, raver;  // 각 위치
    // 레버에서 도착지까지의 최단시간 탐색
    public int bfs_exit(int r_num){
        Queue<Pair> q = new LinkedList();
        q.add(raver);   // 레바에서 시작
        
        boolean[][] visited = new boolean[N][M];    // 방문기록
        visited[raver.x][raver.y] = true;
        
        int[][] step = new int[N][M];   // 이동시간
        step[raver.x][raver.y] = r_num;
        
        while(!q.isEmpty()){
            Pair curr = q.poll();   // 현재 위치
            for(int i=0; i<4; i++){
                int nx = curr.x + dx[i], ny = curr.y + dy[i];
                if(0 > nx || nx >= N || 0 > ny || ny >= M)
                    continue;
                if(grid[nx][ny] != 'X' && !visited[nx][ny]){    // 통로인지 판별
                    if(grid[nx][ny] == 'E'){    // 도착점이라면 종료
                        step[nx][ny] = step[curr.x][curr.y] + 1;
                        return step[nx][ny];
                    }
                    step[nx][ny] = step[curr.x][curr.y] + 1;    // 다음지점으로 이동
                    visited[nx][ny] = true;
                    q.add(new Pair(nx,ny));
                }
            }
        }
        return -1;
    }
    // 시작점에서 레버까지의 최단시간 탐색
    public int bfs_raver(){
        Queue<Pair> q = new LinkedList();
        q.add(start);   // 시작점에서 시작
        
        boolean[][] visited = new boolean[N][M];    // 방문기록
        visited[start.x][start.y] = true;
        
        int[][] step = new int[N][M];   // 이동시간
        
        while(!q.isEmpty()){
            Pair curr = q.poll();   // 현재 위치
            for(int i=0; i<4; i++){
                int nx = curr.x + dx[i], ny = curr.y + dy[i];
                if(0 > nx || nx >= N || 0 > ny || ny >= M)
                    continue;
                if(grid[nx][ny] != 'X' && !visited[nx][ny]){    // 통로인지 판별
                    if(grid[nx][ny] == 'L'){    // 레버에 도착하면 종료
                        step[nx][ny] = step[curr.x][curr.y] + 1;
                        return step[nx][ny];
                    }
                    step[nx][ny] = step[curr.x][curr.y] + 1;
                    visited[nx][ny] = true;
                    q.add(new Pair(nx,ny));
                }
            }
        }
        return -1;
    }
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        grid = new char[N][M];
        
        // 각 위치 초기화
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                grid[i][j] = maps[i].charAt(j);
                if(grid[i][j] == 'S')
                    start = new Pair(i,j);
                if(grid[i][j] == 'E')
                    end = new Pair(i,j);
                if(grid[i][j] == 'L')
                    raver = new Pair(i,j);
            }
        }
        // 레버까지의 걸린 시간
        int result1 = bfs_raver();
        if(result1 == -1)   // 레버까지 도달하지 못하는 경우 -1
            return result1;
        // 탈출까지의 걸린 시간
        return bfs_exit(result1);
    }
}