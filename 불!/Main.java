import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
// 좌표와 시간을 나타내기 위한 클래스
class Pair {
    int x;
    int y;
    int t;
    // 이동
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // 시간이 주어진 경우
    Pair(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}
public class Main {
    static int N,M;
    static char[][] grid;
    static boolean[][] visited;
    static int[][] step, temp;  //불의 이동, J의 이동
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    static Pair s;  // 시작 지점
    static Queue<Pair> q = new LinkedList<>();  // J의 이동경로를 저장하는 저장소
    static Queue<Pair> fire = new LinkedList<>();   //불의 이동경로를 저장하는 저장소
    public static void fire_step() {
        int time = 1;   // 시작

        while(!fire.isEmpty()) {
            Pair curr = fire.poll();
            // 다음 불의 이동인 경우
            if(time == curr.t)
                time++;
            // 다음 불의 이동 위치 확인 및 시간 확인
            for(int i=0; i<4; i++) {
                int nx = curr.x + dx[i], ny = curr.y + dy[i];
                // 격자점 외부이면 넘어감
                if(0 > nx || nx >= N || 0 > ny || ny >= M)
                    continue;
                // 이동할 수 있고, 방문기록이 없으면 불을 이동시킴
                if(grid[nx][ny] == '.' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    step[nx][ny] = time;
                    fire.add(new Pair(nx,ny,time));
                }
            }
        }
    }
    // 불의 경로에 따라 J가 탈출할 수 있는지 판별
    public static void find_path() {
        visited = new boolean[N][M];
        visited[s.x][s.y] = true;
        q.add(s);
        temp[s.x][s.y] = 1;

        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int cnt = temp[curr.x][curr.y]; // 현재위치에서의 시간
            // 다음 J의 이동 위치 및 시간 확인
            for(int i=0; i<4; i++) {
                int nx = curr.x + dx[i], ny = curr.y + dy[i];
                // 격자점 외부면 넘어감
                if(0 > nx || nx >= N || 0 > ny || ny >= M)
                    continue;
                if(grid[nx][ny] == '.' && !visited[nx][ny]) {
                    // 불이 도달 하지 않은 경우 이동 가능
                    if(step[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        temp[nx][ny] = cnt + 1;
                        q.add(new Pair(nx,ny));
                    } else {
                        // 그 시간에 불이 오지 않은 경우 이동 가능
                        if(cnt+1 < step[nx][ny]){
                            visited[nx][ny] = true;
                            temp[nx][ny] = cnt + 1;
                            q.add(new Pair(nx,ny));
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new char[N][M];
        visited = new boolean[N][M];
        step = new int[N][M];
        temp = new int[N][M];

        for(int i=0; i<N; i++) {
            String input = br.readLine();
            for(int j=0; j<M; j++) {
                grid[i][j] = input.charAt(j);
                // 시작 위치
                if(grid[i][j] == 'J')
                    s = new Pair(i,j);
                // 불의 시작 위치(여러 개인 경우 포함)
                else if(grid[i][j] == 'F'){
                    fire.add(new Pair(i,j,1));
                    step[i][j] = 1;
                    visited[i][j] = true;
                }
            }
        }

        fire_step();    // 불의 이동경로
        find_path();    // J의 이동경로

        // 가장자리 부분을 확인하여 탈출 여부 및 최소시간 구하기
        int answer = Integer.MAX_VALUE;
        for(int i=0; i<N; i++) {
            if( 0 < i && i < N-1){
                if (temp[i][0] != 0) {
                    answer = Math.min(answer, temp[i][0]);
                }
                if(temp[i][M-1] != 0)
                    answer = Math.min(answer, temp[i][M-1]);
                continue;
            }
            for(int j=0; j<M; j++) {
                if(temp[i][j] == 0)
                    continue;
                answer = Math.min(answer, temp[i][j]);
            }
        }

        if(answer == Integer.MAX_VALUE)
            System.out.println("IMPOSSIBLE");
        else
            System.out.println(answer);
    }

}