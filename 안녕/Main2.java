import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] DP;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DP = new int[N+1][100];
        grid = new int[N+1][2];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) 
            grid[i][0] = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) 
            grid[i][1] = Integer.parseInt(st.nextToken());
        
        for (int i = 1; i <= N; i++) {
            int hp = grid[i][0];
            int joy = grid[i][1];
            for (int j = 1;  j < 100; j++) {
                if (j - hp >= 0) {
                    DP[i][j] = Math.max(DP[i-1][j], DP[i-1][j-hp] + joy);
                } else {
                    DP[i][j] = DP[i-1][j];
                }
            }
        }
        System.out.println(DP[N][99]);
    }
}
