import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] grid; // 격자점
    static boolean[][] visited; // 방문기록
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    // 덩어리 탐색
    public static void dfs(int cx, int cy){
        for(int i=0; i<4; i++){ // 4방향 탐색
            int nx = cx + dx[i], ny = cy + dy[i];
            if(0 > nx || nx >= N || 0 > ny || ny >= M)
                continue;
            if(grid[nx][ny] != 0 && !visited[nx][ny]){  // 연결되어있으면 방문
                visited[nx][ny] = true;
                dfs(nx,ny);
            }
        }
    }
    // 빙산 녹이기
    public static void ice_melting(){
        int[][] temp = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                int cnt = 0;
                for(int k=0; k<4; k++){
                    int nx = i + dx[k], ny = j + dy[k];
                    if(0 > nx || nx >= N || 0 > ny || ny >= M)
                        continue;
                    if(grid[nx][ny] == 0)  // 주변이 물인 경우 확인
                        cnt++;
                }
                temp[i][j] = grid[i][j] - cnt;  // 빙산 녹이기
                temp[i][j] = Math.max(temp[i][j], 0);   // 음수인 경우 0으로 바꿈
            }
        }
        grid = temp;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        // 입력
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0, cnt = 0;
        // 빙산의 변화 탐색
        while(cnt < 2){
            cnt = 0;
            visited = new boolean[N][M];
            ice_melting();  // 빙산 녹이기
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(grid[i][j] == 0 || visited[i][j])
                        continue;
                    dfs(i,j);
                    cnt++;
                }
            }
            if(cnt == 0){   // 두 덩어리가 안되는 경우
                answer = 0;
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }
}