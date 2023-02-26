import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;
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
    static int R,C;
    static Pair start, end;
    static char[][] grid;
    static boolean[][] visited;
    static int[][] step, temp;
    static Queue<Pair> water = new LinkedList<>();
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    public static void dfs(int cx, int cy, int time) {
        if(cx == end.x && cy == end.y)
            return;
        for(int i=0; i<4; i++) {
            int nx = cx + dx[i], ny = cy + dy[i];
            if(0 > nx || nx >= R || 0 > ny || ny >=C)
                    continue;
            if(grid[nx][ny] == 'D'){
                temp[nx][ny] = time+1;
                    return;
            }
            if(grid[nx][ny] == '.'&& time < step[nx][ny] &&!visited[nx][ny]){
                visited[nx][ny] = true;
                temp[nx][ny] = time+1;
                dfs(nx,ny,time+1);
            }
        }
    }
    public static void bfs(){
        while(!water.isEmpty()){
            Pair curr = water.poll();
            for(int i=0; i<4; i++) {
                int nx = curr.x + dx[i], ny = curr.y + dy[i];
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
                if(grid[i][j] == 'S')
                    start = new Pair(i,j,1);
                else if(grid[i][j] == 'D')
                    end = new Pair(i,j,0);
                else if(grid[i][j] == '*'){
                    water.add(new Pair(i,j,0));
                    visited[i][j] = true;
                    step[i][j] = 1;
                }
            }
        }
        // 물 이동
        bfs();
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++){
                System.out.print(step[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        // 고슴도치 이동
        visited = new boolean[R][C];
        visited[start.x][start.y] = true;
        temp[start.x][start.y] = 1;
        dfs(start.x, start.y, start.t);

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++){
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
        if(temp[end.x][end.y] == 0)
            System.out.println("KAKTUS");
        else
            System.out.println(temp[end.x][end.y]-1);
    }
}