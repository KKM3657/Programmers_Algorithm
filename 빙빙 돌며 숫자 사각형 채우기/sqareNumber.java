import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;

    static boolean inRange(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] dxs = new int[] {0,1,0,-1};
        int[] dys = new int[] {1,0,-1,0};

        int[][] grid = new int[n][m];
        int x  = 0;
        int y = 0;
        int dir_num = 0;

        for(int i = 1; i <= n*m; i++){
            grid[x][y] = i;
            int nx = x + dxs[dir_num];
            int ny = y + dys[dir_num];
            
            if(!inRange(nx,ny) || grid[nx][ny] != 0){
                dir_num = (dir_num + 1) % 4;
            }
            x = x + dxs[dir_num];
            y = y + dys[dir_num];
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}