import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pair{
    int x;
    int y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N, M, dir, answer = 0;
    static int[][] grid;
    static int[] dx = new int[]{-1,0,1,0}, dy = new int[]{0,-1,0,1};
    static char[] pic = new char[]{'^','<','v','>'};
    static char[][] graph;
    public static void dfs(int cx, int cy){
        // 청소
        grid[cx][cy] = 2;
        graph[cx][cy] = pic[dir];
        answer++;
        // 4방향
        for(int i=0; i<4; i++) {
            int nx = cx + dx[dir], ny = cy + dy[dir];
            if(0 > nx || nx >= N || 0 > ny || ny >= M || grid[nx][ny] != 0)
                dir = (dir + 1) % 4;
            if(grid[nx][ny] == 0)
                dfs(nx, ny);
        }
        dir = (dir + 1) % 4;
        int nx = cx - dx[dir], ny = cy - dy[dir];
        if(grid[nx][ny] == 1){
            System.out.println(answer);
            System.exit(0);
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        //start = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
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
    }
}