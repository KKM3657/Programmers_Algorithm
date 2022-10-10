import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 순서쌍을 위한 클래스
class Pair { 
    int x, y;
    public Pair(int x, int y) { 
        this.x = x; 
        this.y = y; 
    } 
}

public class Main {
    static int n;
    static int m;
    static Queue<Pair> al = new LinkedList<>();;
    static int[][] grid;
    static int[][] visited;
    static int[] dxs = new int[]{1,0,-1,0};
    static int[] dys = new int[]{0,1,0,-1};

    // 범위 안에 있는지
    public static boolean in_range(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < m;
    }
    // 다음 좌표로 넘어갈 수 있는지    
    public static boolean can_go(int x, int y){
        if(!in_range(x,y)){
            return false;
        }
        if(grid[x][y] == 0 || visited[x][y] == 1){
            return false;
        }
        return true;
    }
    // 너비 우선 탐색
    public static void bfs(){
        while(!al.isEmpty()){
            Pair curr = al.poll();
            int ks = curr.x, ky = curr.y;

            for(int i =0; i<4; i++){
                int next_x = ks + dxs[i];
                int next_y = ky + dys[i];
                
                if(can_go(next_x,next_y)){
                    visited[next_x][next_y] = 1;
                    al.add(new Pair(next_x,next_y));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        visited = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int start_x = 0;
        int start_y = 0;
        visited[start_x][start_y] = 1;
        al.add(new Pair(start_x,start_y));
        bfs();

        System.out.println(visited[n-1][m-1]);
    }
}