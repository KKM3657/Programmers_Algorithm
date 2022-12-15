import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
// 좌표를 나타내는 클래스
class Pair{
    int x;
    int y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int n,m,min_value, answer;
    static int[][] grid, step, temp;
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    static Pair bird;
    // 격자점 내부의 점인지 판별
    public static boolean in_range(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < m;
    }
    // 까마귀 둥지로부터 먹을 수 있는 빵 부스러기의 거리 최소 합
    public static int is_minValue(){
        int value = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] != 1 || temp[i][j] == 1)  // bfs로 탐색한 최소 이동을 제외한 빵 부스러기 탐색
                    continue;
                value += Math.abs(bird.x - i) + Math.abs(bird.y - j);
            }
        }
        return value;
    }
    // dfs를 이용해서 최소 이동 거리 경로 확인 및 최소 합 찾기(백트래킹)
    public static void dfs(int kx, int ky, boolean[][] visited){
        // 과자집 도달
        if(kx == n-1 && ky == m-1){
            int result = is_minValue(); // 최소 이동 경로가 최소가 되는지 판별
            answer = Math.min(answer, result);
            return;
        }
        // 잘못된 경로이면 넘어감
        if(step[kx][ky] > min_value)
            return;
        int value = step[kx][ky];
        // 4방향 탐색
        for(int i=0; i<4; i++){
            int next_x = kx + dx[i], next_y = ky + dy[i];
            // 다음으로 이동할 점이 격자점 내부이면서 bfs로 찾은 최소 이동 경로인지 확인
            if(in_range(next_x,next_y) && step[next_x][next_y] == value+1 && !visited[next_x][next_y]){
                temp[next_x][next_y] = 1;
                visited[next_x][next_y] = true;
                dfs(next_x, next_y, visited);   // 다음으로 이동

                temp[next_x][next_y] = 0;
                visited[next_x][next_y] = false;
            }
        }
    }
    // bfs를 이용해서 최소 이동 거리 확인
    public static void bfs(int start_x, int start_y){
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];    // 방문 기록
        visited[start_x][start_y] = true;
        step[start_x][start_y] = 1;
        q.add(new Pair(start_x, start_y));  // 시작 지점
        // 큐가 빌때까지 반복
        while(!q.isEmpty()){
            Pair curr = q.poll();   // 현재 위치
            int value = step[curr.x][curr.y];
            // 4방향 탐색
            for(int i=0; i<4; i++){
                int next_x = curr.x + dx[i], next_y = curr.y + dy[i];
                // 다음으로 이동할 점이 격자점 내부이면서 빵 부스러기 경로인지 확인
                if(in_range(next_x,next_y) && grid[next_x][next_y] == 1 && !visited[next_x][next_y]){
                    visited[next_x][next_y] = true;
                    q.add(new Pair(next_x, next_y));
                    step[next_x][next_y] = value + 1;
                }
            }
        }
        min_value = step[n-1][m-1] - 1; // 최소 이동거리
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for(int k=1; k<=t; k++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            answer = Integer.MAX_VALUE;
            bird = new Pair(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
            grid = new int[n][m];
            step = new int[n][m];
            temp = new int[n][m];
            boolean[][] visited = new boolean[n][m];

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<m; j++){
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            bfs(0,0);   // 최소 이동거리 탐색
            visited[0][0] = true;
            temp[0][0] = 1;
            dfs(0,0, visited);  // 최소 이동 경로가 정답이 되는지 탐색후 결과 계산
            System.out.printf("#%d %d %d\n",k,min_value,answer);
        }
    }
}
