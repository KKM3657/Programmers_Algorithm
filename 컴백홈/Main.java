import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 좌표를 나타내는 클래스
class Pair{
    int x;
    int y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int R, C, K, cnt = 1, answer = 0;
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};    // dx,dy 테크닉
    static char[][] grid;
    static boolean[][] visited; // 방문 기록
    // 격자 범위내에 있는지 판별
    public static boolean in_range(int x, int y){
        return 0 <= x && x < R && 0 <= y && y < C;
    }
    // 깊이 우선 탐색 + 완전탐색
    public static void dfs(Pair curr){
        if(cnt > K) // 정답이 아닌 경우 돌아감
            return;
        if(curr.x == 0 && curr.y == C-1){   // 도착 지점에 도착
            if(cnt == K)
                answer++;
            return;
        }
        // 4방향 탐색
        for(int i=0; i<4; i++){
            int next_x = curr.x + dx[i], next_y = curr.y + dy[i];
            // 격자점 내부의 점이며, 벽에 막혀있지 않으면서, 방문 기록이 없으면 이동
            if(in_range(next_x, next_y) && grid[next_x][next_y] != 'T' && !visited[next_x][next_y]){
                visited[next_x][next_y] = true;
                cnt++;
                dfs(new Pair(next_x, next_y));

                visited[next_x][next_y] = false;    // 원래 상태 복구
                cnt--;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        grid = new char[R][C];
        visited = new boolean[R][C];
        for(int i=0; i<R; i++){
            String input = br.readLine();
            for(int j=0; j<C; j++){
                grid[i][j] = input.charAt(j);
            }
        }
        // 시작 지점 설정
        Pair start = new Pair(R-1, 0);
        visited[R-1][0] = true;
        dfs(start);
        
        System.out.println(answer);
    }
}