import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
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
    static int n,m,k,answer;
    static char[][] grid;
    static boolean visited[][];
    static int step[][];
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    static Queue<Pair> q;
    public static boolean in_range(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < m;
    }
    public static int bfs(){
        int cnt = 0, max = 0;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int value = step[curr.x][curr.y];

            for(int i=0; i<4; i++){
                int next_x = curr.x + dx[i], next_y = curr.y + dy[i];
                if(in_range(next_x, next_y) && grid[next_x][next_y] != '#' && !visited[next_x][next_y]){
                    if(grid[next_x][next_y] == 'o'){
                        cnt+=1;
                        if(answer < value + 1)
                            return value + 1;
                    }
                    visited[next_x][next_y] = true;
                    step[next_x][next_y] = value + 1;
                    q.add(new Pair(next_x,next_y));
                    if(cnt == k)
                        return step[next_x][next_y];
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for(int i=1; i<=t; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            grid = new char[n][m];

            for(int j=0; j<n; j++){
                String line = br.readLine();
                for(int l=0; l<m; l++){
                    grid[j][l] = line.charAt(l);
                }
            }
            for(int j=0; j<k; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken())-1, y = Integer.parseInt(st.nextToken())-1;
                grid[x][y] = 'o';
            }
            answer = Integer.MAX_VALUE;
            for(int j=0; j<n; j++){
                for(int l=0; l<m; l++){
                    if(grid[j][l] == '#' || grid[j][l] == 'o')
                        continue;
                    visited = new boolean[n][m];
                    step = new int[n][m];
                    q = new LinkedList<Pair>();
                    visited[j][l] = true;
                    q.add(new Pair(j,l));
                    int result = bfs();
                    if(result == -1)
                        continue;
                    answer = Math.min(result, answer);
                }
            }
            if(answer == Integer.MAX_VALUE)
                answer = -1;
            System.out.printf("#%d %d\n",i,answer);
        }
    }
}
