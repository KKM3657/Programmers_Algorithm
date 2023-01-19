import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int n, m, cnt;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    // 격자점 내부의 점인지 판별
    static boolean in_range(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < m;
    }
    // dfs 탐색 실시
    static void dfs(int kx, int ky) {
        for(int i=0; i<4; i++) {    // 4 방향
            int nx = kx + dx[i], ny = ky + dy[i];   // 다음으로 이동할 점
            // 격자점 내부의 점인지, 음식물에 해당하는지, 방문기록이 있는지 확인
            if(in_range(nx,ny) && grid[nx][ny]==1 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                cnt++;
                dfs(nx, ny);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            grid[a-1][b-1] = 1;
        }
        // 격자점 내부 탐색 실시
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                // 이미 방문했거나 음식물이 없다면 넘어감
                if(visited[i][j] || grid[i][j] == 0)
                    continue;
                cnt = 1;
                visited[i][j] = true;
                dfs(i,j);
                answer = Math.max(answer, cnt); // 제일 큰 음식물 쓰레기
            }
        }
        System.out.println(answer);
    }
}