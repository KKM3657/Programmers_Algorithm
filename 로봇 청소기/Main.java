import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, dir, answer = 1;
    static int[][] grid;
    static int[] dx = new int[]{-1,0,1,0}, dy = new int[]{0,1,0,-1};
    static char[][] graph;
    public static void dfs(int cx, int cy){
        // 청소
        grid[cx][cy] = 2;

        // 4방향
        for(int i=0; i<4; i++) {
            dir = (dir + 3) % 4; // 방향 전환
            int nx = cx + dx[dir], ny = cy + dy[dir];
            if(0 <= nx && nx < N && 0 <= ny && ny <= M && grid[nx][ny] == 0) { // 이동
                answer++;
                dfs(nx, ny);
                return;
            }
        }
        int nx = cx - dx[dir], ny = cy - dy[dir];   // 방향 유지한 상태에서 뒤로
        if(grid[nx][ny] != 1){
            dfs(nx,ny); // 다음으로 이동
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken()), sy = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        graph = new char[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(sx, sy);
        System.out.println(answer);
    }
}