import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N, M, cnt;
    static int[][] grid;
    static int[] dx = new int[]{1,0,-1,0}, dy = new int[]{0,-1,-0,1};   // dx,dy 테크닉
    static boolean[][] visited; // 방문기록
    static void dfs(int cx, int cy){
        for(int i=0; i<4; i++) {    // 4방향 탐색
            int nx = cx + dx[i], ny = cy + dy[i];   // 다음 위치
            if(0 > nx || nx >= M || 0 > ny || ny >= N)  // 좌표를 벗어나면 넘어감
                continue;
            if(grid[ny][nx] == 0 && !visited[ny][nx]) { // 빈칸이며, 방문기록이 없으면 영역 추가
                cnt++;
                visited[ny][nx] = true;
                dfs(nx, ny);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        visited= new boolean[N][M];
        // 해당 영역 색칠
        for(int k=0; k<K; k++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int i=y1; i<y2; i++) {
                for(int j=x1; j<x2; j++) {
                    if(grid[i][j] != 0)
                        continue;
                    grid[i][j] = 1;
                }
            }
        }
        // 영역 탐색
        int answer = 0;
        ArrayList<Integer> answer_list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                // 방문한 기록이나 색칠한 영역이면 넘어감
                if(grid[i][j] == 1 || visited[i][j])
                    continue;
                cnt = 1;
                answer++;
                visited[i][j] = true;
                dfs(j,i);   // 영역 탐색
                answer_list.add(cnt);
            }
        }
        Collections.sort(answer_list);
        System.out.println(answer);
        for(Integer value : answer_list)
            System.out.print(value + " ");
    }
}