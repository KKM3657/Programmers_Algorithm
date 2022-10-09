import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int[][] grid;
    public static int[][] visited;
    static int n;
    static int m;
    static int answer = 0;
    
    // 격자 범위 안에 들어가는지
    public static boolean in_range(int kx, int ky){
        return 0 <= kx && kx < n && 0 <= ky && ky < m;
    }
    // 격자 범위 안에 들어가는지, 방문 하지 않았는지, 뱀이 없는 곳인지
    public static boolean can_go(int kx, int ky){
        if (!in_range(kx,ky))
            return false;
        if (grid[kx][ky] == 0 || visited[kx][ky] == 1)
            return false;
        return true;
    }
    // 깊이 우선 탐색
    public static void dfs(int kx, int ky){
        // 아래 오른쪽 dx, dy 테크닉
        int[] dxs = new int[] {1,0};
        int[] dys = new int[] {0,1};
        
        // 끝점에 도달했다면 1
        if(kx == n-1 && ky == m-1){
            answer = 1;
            return;
        }
        // 다음 좌표로 이동
        for(int i = 0; i < 2; i++){
            int next_x = kx + dxs[i];
            int next_y = ky + dys[i];
            // 다음 좌표로 이동 가능한지 판별
            if(can_go(next_x,next_y)){
                visited[next_x][next_y] = 1;
                dfs(next_x, next_y); 
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        visited = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = 0;
        int y = 0;
        visited[x][y] = 1;
        dfs(x,y);
        System.out.println(answer);
    }
}