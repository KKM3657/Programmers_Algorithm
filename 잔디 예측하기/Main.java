import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.ArrayList;
class Pair{
    int x;
    int y;
    int hp;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    Pair(int x, int y, int hp){
        this.x = x;
        this.y = y;
        this.hp = hp;
    }
}
public class Main {
    static int N, M, D, idx = 0;
    static char[][] grid, predict;
    static ArrayList<Pair> grass = new ArrayList<>();
    static boolean[][][] visited;
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    public static void bfs(int cx, int cy){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(cx,cy,D));
        visited[D][cx][cy] = true;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            for(int i=0; i<4; i++){
                int nx = curr.x + dx[i], ny = curr.y + dy[i];
                if(0 > nx || nx >= N || 0 > ny || ny >= M)
                    continue;
                if(predict[nx][ny] == 'O' && !visited[curr.hp][nx][ny] && curr.hp > 0){
                    visited[curr.hp][nx][ny] = true;
                    visited[curr.hp-1][nx][ny] = true;
                    q.add(new Pair(nx,ny,D));
                    q.add(new Pair(nx,ny,D-1));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new char[N][M];
        predict = new char[N][M];
        int cnt = 0;

        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<M; j++){
                grid[i][j] = input.charAt(j);
                if(grid[i][j] == 'O') {
                    grass.add(new Pair(i, j));
                    cnt++;
                }
            }
        }
        D = Integer.parseInt(br.readLine());
        visited = new boolean[D+1][N][M];

        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<M; j++){
                predict[i][j] = input.charAt(j);
            }
        }

        for(Pair curr : grass){
            bfs(curr.x, curr.y);
        }
        boolean flag = false;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(predict[i][j] == 'O') {
                    for (int k = 0; k <= D; k++) {
                        if (visited[k][i][j]) {
                            flag = true;
                        }
                    }
                    if (!flag) {
                        System.out.println("NO");
                        System.exit(0);
                    }
                }
                flag = false;
            }
        }
        System.out.println("YES");
    }
}
