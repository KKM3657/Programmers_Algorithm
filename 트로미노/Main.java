import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][m];
        int answer = 0;
        
        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //  가로 길게
        for(int i=0; i<n; i++){
            for(int j=1; j<m-1; j++){
                answer = Math.max(answer, grid[i][j-1] + grid[i][j] + grid[i][j+1]);
            }
        }
        // 세로 길게
        for(int i=1; i<n-1; i++){
            for(int j=0; j<m; j++){
                answer = Math.max(answer, grid[i-1][j] + grid[i][j] + grid[i+1][j]);
            }
        }
        // ㄴ자
        for(int i=1; i<n; i++){
            for(int j=0; j<m-1; j++){
                answer = Math.max(answer, grid[i-1][j] + grid[i][j] + grid[i][j+1]);
            }
        }
        // ㄴ자 회전
        for(int i=0; i<n-1; i++){
            for(int j=0; j<m-1; j++){
                answer = Math.max(answer, grid[i][j] + grid[i+1][j] + grid[i][j+1]);
            }
        }
        // ㄱ자
        for(int i=0; i<n-1; i++){
            for(int j=1; j<m; j++){
                answer = Math.max(answer, grid[i][j-1] + grid[i][j] + grid[i+1][j]);
            }
        }
        // ㄱ자 회전
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                answer = Math.max(answer, grid[i][j-1] + grid[i][j] + grid[i-1][j]);
            }
        }
        System.out.println(answer);
    }
}