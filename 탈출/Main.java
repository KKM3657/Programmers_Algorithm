import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;
// 좌표와 시간을 나타내기 위한 클래스
class Pair{
    int x;
    int y;
    int t;

    Pair(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}
public class Main {
    static int R,C; // 가로, 세로
    static Pair start, end; // 시작과 끝
    static char[][] grid;   // 격자점
    static boolean[][] visited; // 방문 기록
    static int[][] step, temp;  // 물의 이동기록, 고슴도치 이동기록
    static Queue<Pair> water = new LinkedList<>();  // 물을 나타내기 위한 리스트
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    // 고슴도치의 이동경로 탐색
    public static void bfs_s(int cx, int cy, int time) {
        // 초기화
        visited = new boolean[R][C];
        visited[start.x][start.y] = true;
        temp[start.x][start.y] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(cx, cy, time));

        while(!q.isEmpty()){
            Pair curr = q.poll();
            // 4방향 탐색
            for(int i=0; i<4; i++) {
                int nx = curr.x + dx[i], ny = curr.y + dy[i];
                // 격자점을 벗어난 경우
                if(0 > nx || nx >= R || 0 > ny || ny >=C)
                        continue;
                // 도착한 경우 기록 후 종료
                if(grid[nx][ny] == 'D'){
                    temp[nx][ny] = temp[curr.x][curr.y]+1;
                        return;
                }
                // 이동 가능하며, 방문하지 않았으면 이동
                if(grid[nx][ny] == '.' && !visited[nx][ny]){
                    // 물이 이미 차있으면 넘어감
                    if(step[nx][ny] == 0 || curr.t+1 < step[nx][ny]){
                        visited[nx][ny] = true;
                        temp[nx][ny] = temp[curr.x][curr.y]+1;;
                        q.add(new Pair(nx, ny, curr.t+1));    
                    }
                }
            }
        }
    }
    // 물의 이동경로 탐색
    public static void bfs_w(){
        while(!water.isEmpty()){
            Pair curr = water.poll();
            for(int i=0; i<4; i++) {    // 4방향 탐색
                int nx = curr.x + dx[i], ny = curr.y + dy[i];
                // 격자점 외부이면 넘어감
                if(0 > nx || nx >= R || 0 > ny || ny >=C)
                    continue;
                if(grid[nx][ny] == '.' && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    step[nx][ny] = step[curr.x][curr.y] + 1;
                    water.add(new Pair(nx, ny, curr.t+1));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        grid = new char[R][C];
        step = new int[R][C];
        temp = new int[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++) {
            String input = br.readLine();
            for(int j=0; j<C; j++) {
                grid[i][j] = input.charAt(j);                
                if(grid[i][j] == 'S') // 시작 지점
                    start = new Pair(i,j,1);
                else if(grid[i][j] == 'D')  // 종료 지점
                    end = new Pair(i,j,0);
                else if(grid[i][j] == '*') { // 물의 시작 위치
                    water.add(new Pair(i,j,0));
                    visited[i][j] = true;
                    step[i][j] = 1;
                }
            }
        }
        // 물 이동
        bfs_w();
        
        // 고슴도치 이동
        bfs_s(start.x, start.y, start.t);

        if(temp[end.x][end.y] == 0)
            System.out.println("KAKTUS");
        else
            System.out.println(temp[end.x][end.y]-1);
    }
}