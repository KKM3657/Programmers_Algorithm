import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Pair{
    int x;
    int y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int[][] grid, step;
    static boolean[][] visited;
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    static int N, M, answer = 0;
    public static void find_answer(){
        Deque<Pair> dq = new LinkedList<Pair>();
        dq.add(new Pair(0,0));
        visited[0][0] = true;

        while(!dq.isEmpty()){
            Pair curr = dq.pollFirst();
            int value = step[curr.x][curr.y];
            for(int i=0; i<4; i++){
                int nx = curr.x + dx[i], ny = curr.y + dy[i];

                if(0 > nx || nx >= N || 0 > ny || ny >= M){
                    continue;
                }
                if(!visited[nx][ny]){
                    if(grid[nx][ny] == 1){
                        dq.addLast(new Pair(nx, ny));
                        visited[nx][ny] = true;
                        step[nx][ny] = value + 1;
                    }
                    else{
                        dq.addFirst(new Pair(nx, ny));
                        visited[nx][ny] = true;
                        step[nx][ny] = value;
                    }
                }
            }
        }
        answer = step[N-1][M-1];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        step = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<M; j++){
                grid[i][j] = input.charAt(j) - '0';
            }
        }

        find_answer();
        System.out.println(answer);
    }
}