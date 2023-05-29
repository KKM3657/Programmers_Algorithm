import java.io.*;
import java.util.*;

class Main{
    static int N, cnt;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    public static void dfs(int cx, int cy, int k){
        for(int i=0; i<4; i++){
            int nx = cx + dx[i], ny = cy + dy[i];
            if(0 > nx || nx >= N || 0 > ny || ny >= N)
                continue;
            if(!visited[nx][ny] && grid[nx][ny] > k){
                visited[nx][ny] = true;
                dfs(nx,ny,k);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        grid = new int[N][N];
        int answer = 1;
        int max = 0, min = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, grid[i][j]);
                min = Math.min(min, grid[i][j]);
            }
        }
        for(int k = min; k<=max; k++){
            cnt = 0;
            visited = new boolean[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(visited[i][j] || grid[i][j] <= k)
                        continue;
                    cnt++;
                    visited[i][j] = true;
                    dfs(i,j,k);
                }
            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }
}
