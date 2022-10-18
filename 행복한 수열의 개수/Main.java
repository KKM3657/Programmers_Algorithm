import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][n];
        int answer = 0;
        // 입력
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 가로 행복 수열 개수 구하기
        for(int i = 0; i<n; i++){
            int cnt = 1;
            int prev = 0;
            for(int j = 0; j<n; j++){
                if(prev == grid[i][j]){
                    cnt++;
                } else{
                    prev = grid[i][j];
                    cnt = 1;
                }
                if(cnt == m){
                    answer++;
                    break;
                }
            }
        }
        // 세로 행복 수열 구하기
        for(int j = 0; j<n; j++){
            int cnt = 1;
            int prev = 0;
            for(int i = 0; i<n; i++){
                if(prev == grid[i][j]){
                    cnt++;
                } else{
                    prev = grid[i][j];
                    cnt = 1;
                }
                if(cnt == m){
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}