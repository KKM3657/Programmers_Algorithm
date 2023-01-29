import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;
class Pair {
    int x;
    int y;
    int day;    // 날짜

    Pair(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }
}
public class Main {
    static int n, m, answer = 0;
    static int[][] grid;
    static boolean[][] visited;
    static Queue<Pair> q = new LinkedList<>();
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    public static void solution() {
        int day = 0;    // 날짜 초기화
        while(!q.isEmpty()) {   // 큐가 빌때까지 반복
            Pair curr = q.poll();   // 현재 노드
            if(curr.cnt == day) // 다음날으로 이동
                day++;
            for(int i=0; i<4; i++) {    // 4 방향 조회
                int nx = curr.x + dx[i], ny = curr.y + dy[i];
                if(0 > nx || nx >= n || 0 > ny || ny >= m)  // 격자점에 벗어나면 넘어감
                    continue;
                if(grid[nx][ny] == 0 && !visited[nx][ny]) { // 익을 수 있는 토마토인지 확인
                    grid[nx][ny] = 1;
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny, day));
                }
            }
        }
        answer = day-1; // 정답
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        grid = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] == 1){    // 처음에 익은 토마토
                    q.add(new Pair(i,j,0));
                    visited[i][j] = true;
                } 
            }
        }
        solution();
        // 예외 경우 확인
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 0){
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }
        System.out.println(answer);
    }
}