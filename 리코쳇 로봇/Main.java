import java.util.Queue;
import java.util.LinkedList;
class Pair{ // 좌표를 나타내기 위한 클래스
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int solution(String[] board) {
        int N = board.length, M = board[0].length();    // 격자 크기
        Queue<Pair> q = new LinkedList<>(); // 큐
        boolean[][] visited = new boolean[N][M];    // 방문기록
        char[][] grid = new char[N][M]; // 격자점
        int[][] step = new int[N][M];   // 최소횟수 테이블
        int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};   // 4방향
        
        for(int i=0; i<N; i++){ // 격자점 채우기
            for(int j=0; j<M; j++){
                grid[i][j] = board[i].charAt(j);
                if(grid[i][j] == 'R'){  // 시작 지점
                    q.add(new Pair(i,j));
                    visited[i][j] = true;
                }
            }
        }
        // 큐가 빌때까지 반복(bfs)
        while(!q.isEmpty()){
            Pair curr = q.poll();   // 현재 위치
            for(int i=0; i<4; i++){ // 4방향 탐색
                int nx = curr.x + dx[i], ny = curr.y + dy[i];   // 다음 지점
                while((0 <= nx && nx < N && 0 <= ny && ny < M) && grid[nx][ny] != 'D'){ // 미끄러짐
                    nx = nx + dx[i];
                    ny = ny + dy[i];
                }
                int tx = nx - dx[i], ty = ny - dy[i];   // 미끄러짐 이후 좌표
                if(!visited[tx][ty]){   // 이미 해당지점에 방문하지 않았다면 큐에 넣기
                    if(grid[tx][ty] == 'G') // 목표지점에 도달하면 종료
                        return step[curr.x][curr.y] + 1;
                    visited[tx][ty] = true; // 방문
                    step[tx][ty] = step[curr.x][curr.y] + 1;    // 최소횟수 채우기
                    q.add(new Pair(tx,ty)); // 큐에 넣기
                }
            }
        }
        return -1;
    }
}