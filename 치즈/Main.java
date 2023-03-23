import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;

class Pair{
    int x;
    int y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int n, m, answer = 0;
    static int[][] grid;
    static boolean[][] visited; // 방문기록
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    static LinkedList<Pair> cheese = new LinkedList<>();
    // 치즈 지우기
    public static void remove_cheese(){
        LinkedList<Pair> temp = new LinkedList<>(); // 남은 치즈
        for (Pair curr : cheese) {  // 모든 치즈 확인
            int cnt = 0;
            for (int j = 0; j < 4; j++) {   // 지울 치즈 찾기
                int nx = curr.x + dx[j], ny = curr.y + dy[j];
                if(0 > nx || nx >= n || 0 > ny || ny >= m)
                    continue;
                if (grid[nx][ny] == 2) {    // 외부에 노출된 치즈 찾기
                    cnt++;
                }
            }
            if (cnt >= 2) { // 치즈 지우기
                grid[curr.x][curr.y] = 0;
            } else  // 남은 치즈
                temp.add(curr);
        }
        cheese = temp;  // 남은 치즈 반영
    }
    // 외부로 노출된 부분 찾기
    public static void dfs_space(int x, int y){
        for(int i=0; i<4; i++){
            int nx = x + dx[i], ny = y + dy[i];
            if(0 > nx || nx >= n || 0 > ny || ny >= m)
                continue;
            // 치즈, 방문기록이면 넘어감
            if(grid[nx][ny] == 1 || visited[nx][ny])
                continue;
            visited[nx][ny] = true; // 방문
            grid[nx][ny] = 2; // 외부공간
            dfs_space(nx,ny);
        }
    }
    public static void find_solution(){
        while(cheese.size() != 0){  // 치즈가 지워질 때까지 반복
            visited = new boolean[n][m];    // 방문기록 초기화
            grid[0][0] = 2; // 시작점
            visited[0][0] = true;
            dfs_space(0,0); // 외부 공간 찾기
            remove_cheese(); // 치즈 지우기
            answer++;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] == 1){
                    cheese.add(new Pair(i,j));
                }
            }
        }

        find_solution();
        System.out.println(answer);
    }
}