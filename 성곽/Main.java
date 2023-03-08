import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class Main {
    static int R,C,room,answer1 = 0;
    static int[][] grid, step;
    static int[][] wall;
    static boolean[][] visited;
    static int[] dx = new int[]{0,-1,0,1}, dy = new int[]{-1,0,1,0};
    public static void DFS(int cx, int cy) {
        int[] dir = wall[grid[cx][cy]];
        for(int i=0; i<4; i++) {
            if(dir[i] == 1)
                continue;
            int nx = cx + dx[i], ny = cy + dy[i];
            if(0 > nx || nx >= R || 0 > ny || ny >= C)
                continue;
            if(!visited[nx][ny]){
                visited[nx][ny] = true;
                step[nx][ny] = answer1;
                room++;
                DFS(nx, ny);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        grid = new int[R][C];
        wall = new int[16][4];

        for(int i=0; i<16; i++) {
            int value = i;
            for(int j=0; j<4; j++) {
                wall[i][j] = value % 2;
                value /= 2;
            }
        }

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[R][C];
        step = new int[R][C];
        ArrayList<Integer> al = new ArrayList<>();
        al.add(-1);

        int answer2 = 0;
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(visited[i][j])
                    continue;
                answer1++;
                step[i][j] = answer1;
                visited[i][j] = true;
                room = 1;
                DFS(i,j);
                al.add(room);
                answer2 = Math.max(answer2, room);
            }
        }

        System.out.println(answer1);
        System.out.println(answer2);
    }
}