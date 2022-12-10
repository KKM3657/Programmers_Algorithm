import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static int n, cnt;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};    //dx,dy 테크닉
    // 격자점 내부의 점인지
    public static boolean in_range(int x, int y){
        return 0<= x && x < n && 0<= y && y < n;
    }
    // 깊이 우선탐색
    public static void dfs(int kx, int ky){
        int value = grid[kx][ky];
        // 4방향으로 탐색
        for(int i=0; i<4; i++){
            int next_x = kx + dx[i], next_y = ky + dy[i];
            // 다음으로 이동할 점이 격자점 내부의 점, 같은 숫자, 방문한 적이 없는 곳인지 판별
            if(in_range(next_x,next_y) && value == grid[next_x][next_y] && !visited[next_x][next_y]){
                visited[next_x][next_y] = true;
                cnt++;  // 폭발범위에 포함
                dfs(next_x, next_y);    // 다음 지점으로 이동
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int block = 0, max_cnt = 0;
        n = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 블럭이 터지는 경우 탐색
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j])
                    continue;
                cnt = 1;
                visited[i][j] = true;
                dfs(i, j);
                if(cnt > 3) // 터지는 횟수
                    block++;
                if(cnt > max_cnt)   // 최대 불럭의 크기
                    max_cnt = cnt;
            }
        }

        System.out.println(block + " " + max_cnt);
    }
}