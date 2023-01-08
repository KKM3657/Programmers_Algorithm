import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static int n, n_cnt = 0, c_cnt = 0;;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0}; // dx,dy 테크닉
    // 격자내의 점인지 판별
    static boolean in_range(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < n;
    }
    // 적록색맹일때 구역 탐색
    static void c_dfs(int cx, int cy){
        for(int i=0; i<4; i++){
            int n_x = cx + dx[i], n_y = cy + dy[i];
            if(in_range(n_x, n_y) && grid[n_x][n_y] != 'B' && !visited[n_x][n_y]){
                visited[n_x][n_y] = true;
                c_dfs(n_x, n_y);
            }
        }
    }
    // 정상일때 구역 탐색
    static void n_dfs(int cx, int cy, char prev){
        for(int i=0; i<4; i++){
            int n_x = cx + dx[i], n_y = cy + dy[i];
            if(in_range(n_x, n_y) && grid[n_x][n_y] == prev && !visited[n_x][n_y]){
                visited[n_x][n_y] = true;
                n_dfs(n_x, n_y, prev);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        
        grid = new char[n][n];
        
        for(int i=0; i<n; i++){
            String input = br.readLine();
            for(int j=0; j<n; j++){
                grid[i][j] = input.charAt(j);
            }
        }

        visited = new boolean[n][n];
        // 정상일때 영역 탐색
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j])
                    continue;
                visited[i][j] = true;
                n_dfs(i,j,grid[i][j]);
                n_cnt++;
            }
        }
        // 적록색맹일때 영역 탐색
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j])
                    continue;
                visited[i][j] = true;
                // 파란색은 구별 가능
                if(grid[i][j] == 'B')
                    n_dfs(i,j,'B');
                else
                    c_dfs(i,j);
                c_cnt++;
            }
        }
        System.out.println(n_cnt + " " + c_cnt);
    }
}