import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int N, M, answer;
    static int[][] grid, step;
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    static void bfs(){
        Queue<int[]>q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];    // 방문기록
        step = new int[N][M];   // 경로
        // 초기화
        q.add(new int[]{0,0});
        visited[0][0] = true;
        step[0][0] = 1;
        // BFS 실행
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int value = step[curr[0]][curr[1]]; // 현재 총 경로
            // 4방향 탐색
            for(int i=0; i<4; i++) {
                // 다음 지점
                int nx = curr[0] + dx[i], ny = curr[1] + dy[i];
                // 격자점 내부인지 판별
                if(0 > nx || nx >= N || 0 > ny || ny >= M)
                    continue;
                // 방문기록과 이동할 수 있는지 확인
                if(grid[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    step[nx][ny] = value + 1;
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        for(int i=0; i<N; i++) {
            String[] input = (br.readLine()).split("");
            for(int j=0; j<M; j++) {
                grid[i][j] = Integer.parseInt(input[j]);
            }
        }

        bfs();

        System.out.println(step[N-1][M-1]);
    }
}