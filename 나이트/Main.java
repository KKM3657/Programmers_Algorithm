import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

class Pair{
    int x, y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int n;
    static boolean[][] visited;
    static int[][] step;
    static Queue<Pair> q = new LinkedList<>();

    // 격자점 안에 있는지
    public static boolean in_range(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < n;
    }
    // 너비우선 탐색
    public static void bfs(int end_x, int end_y){
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int cx = curr.x, cy = curr.y;

            // 나이트가 움직일 수 있는 좌표 전부 탐색
            int[] dxs = new int[]{-2,-1,1,2,2,1,-1,-2};
            int[] dys = new int[]{1,2,2,1,-1,-2,-2,-1};

            for(int i = 0; i < 8; i++){
                int nx = cx + dxs[i], ny = cy + dys[i];
                if(in_range(nx,ny) && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    step[nx][ny] = step[cx][cy] + 1;
                    q.add(new Pair(nx,ny));
                }
            } 
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n][n];
        step = new int[n][n];
        
        st = new StringTokenizer(br.readLine());
        int start_x = Integer.parseInt(st.nextToken());
        int start_y = Integer.parseInt(st.nextToken());
        int end_x = Integer.parseInt(st.nextToken());
        int end_y = Integer.parseInt(st.nextToken());

        visited[start_x-1][start_y-1] = true;
        q.add(new Pair(start_x-1,start_y-1));
        bfs(end_x-1,end_y-1);
        
        int answer = step[end_x-1][end_y-1] == 0 ? -1 : step[end_x-1][end_y-1];
        // 시작 지점과 도착지점이 같은 경우 0 출력
        if(start_x == end_x && start_y == end_y)
            answer = 0;
        System.out.println(answer);
    }
}