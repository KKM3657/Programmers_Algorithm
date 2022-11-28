import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] grid;    // 격자점
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};    // dx,dy 테크닉
    // 격자점 내부의 점인지 판별
    public static boolean in_range(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < m;
    }
    // 깊이 우선 탐색으로 영역 찾기
    public static void dfs(int curr_x, int curr_y, boolean[][] visited, int k){
        for(int i=0; i<4; i++){
            // 다음으로 이동할 좌표
            int next_x = curr_x + dx[i], next_y = curr_y + dy[i];
            // 영역에 해당하는 좌표이면 방문하고 다음 좌표로 이동
            if(in_range(next_x,next_y) && grid[next_x][next_y] > k && !visited[next_x][next_y]){
                visited[next_x][next_y] = true;
                dfs(next_x,next_y,visited,k);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        int max_k = 0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                // 최대 k값 구하기
                if(max_k < grid[i][j])
                    max_k = grid[i][j]; 
            }
        }
        int answer_area = 0, answer_k = 1;
        // 영역의 개수가 최대가 되는 k 탐색
        for(int i=1; i<=max_k; i++){
            boolean[][] visited = new boolean[n][m];
            int temp_area = 0;
            // 조건에 맞는 격자점 순회
            for(int l=0; l<n; l++){
                for(int c=0; c<m; c++){
                    if(grid[l][c] <= i || visited[l][c])
                        continue;
                    temp_area++;
                    visited[l][c] = true;
                    dfs(l,c,visited,i);
                }
            }
            if(answer_area < temp_area){
                answer_area = temp_area;
                answer_k = i;
            }
        }
        System.out.println(answer_k + " " + answer_area);
    }
}