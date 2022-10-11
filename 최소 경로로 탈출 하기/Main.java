import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

class Pair{
    int x,y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n;
    static int m;
    static Queue<Pair> q = new LinkedList<>();
    static int[][] grid;
    static int[][] visited;
    static int[][] step;
    static int[] dxs = new int[]{1,0,-1,0};
    static int[] dys = new int[]{0,1,0,-1};

    public static boolean in_range(int nx, int ny){
        return 0 <= nx && nx < n && 0 <= ny && ny < m;
    }

    public static boolean can_go(int nx, int ny){
        return in_range(nx,ny) && grid[nx][ny] == 1 && visited[nx][ny] != 1;
    }

    public static void bfs(int nx, int ny, int cnt){
        while(!q.isEmpty()){
            Pair curr = q.poll();
            
            for(int i=0; i<4; i++){
                int next_x = curr.x + dxs[i];
                int next_y = curr.y + dys[i];

                if(can_go(next_x, next_y)){
                    q.add(new Pair(next_x,next_y));
                    visited[next_x][next_y] = 1;
                    step[next_x][next_y] = step[curr.x][curr.y]+ 1;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        visited = new int[n][m];
        step = new int[n][m];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ;j <m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        q.add(new Pair(0,0));
        visited[0][0] = 1;
        bfs(0,0,0);

        int answer = (step[n-1][m-1] == 0) ? -1 : (step[n-1][m-1]);
        System.out.println(answer);
    }
}