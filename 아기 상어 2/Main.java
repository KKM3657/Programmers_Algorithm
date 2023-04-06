import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N, M;
    static int[][] grid;
    static Queue<Pair> q = new LinkedList<>();  // BFS를 위한 큐
    static boolean[][] visited; // 방문기록
    static int[] dx = new int[]{0,1,1,1,0,-1,-1,-1}, dy = new int[]{1,1,0,-1,-1,-1,0,1}; // 8방향
    public static int find_solution(){
        int answer = 0;
        int[][] step = new int[N][M];   // 안전거리
        // 큐가 빌때까지 반복
        while(!q.isEmpty()){
            Pair curr = q.poll();   // 현재 위치
            for(int i=0; i<8; i++){
                int nx = curr.x + dx[i], ny = curr.y + dy[i]; // 다음으로 이동할 위치
                // 격자점을 벗어나면 넘어감
                if(0 > nx || nx >= N || 0 > ny || ny >= M)
                    continue;
                // 방문한 적이 없으면 시행
                if(!visited[nx][ny]){
                    step[nx][ny] = step[curr.x][curr.y] + 1;
                    q.add(new Pair(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }
        // 안전거리의 최대값 탐색
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                answer = Math.max(answer, step[i][j]);
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] == 1) {
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }
        System.out.println(find_solution());
    }
}