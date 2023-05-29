import java.util.*;
import java.io.*;

class Pair{
    // 좌표
    int x;
    int y;
    int num;    // 섬 번호
    int cnt;    // 다리 갯수
    Pair(int x, int y, int num, int cnt){
        this.x = x;
        this.y = y;
        this.num = num;
        this.cnt = cnt;
    }
}
class Main{
    static int N;
    static int[][] grid, temp;
    static boolean[][] visited;
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    static Queue<Pair> land = new LinkedList<>();   // 섬 말단부를 저장하기 위한 좌표
    // 섬 나누기
    public static void dfs(int cx, int cy, int k){
        boolean flag = false;
        for(int i=0; i<4; i++){
            int nx = cx + dx[i], ny = cy + dy[i];
            if(0 > nx || nx >= N || 0 > ny || ny >= N){
                continue;
            }
            if(grid[nx][ny] == 0)
                flag = true;
            if(!visited[nx][ny] && grid[nx][ny] != 0){
                grid[nx][ny] = k;
                visited[nx][ny] = true;
                dfs(nx,ny,k);
            }

        }
        // 섬 말단부
        if(flag) {
            temp[cx][cy] = k;
            land.add(new Pair(cx, cy, k, 0));
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        visited = new boolean[N][N];
        temp = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 섬 나누기
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j] || grid[i][j] == 0)
                    continue;
                cnt++;
                grid[i][j] = cnt;
                visited[i][j] = true;
                dfs(i,j,cnt);
            }
        }

        // 섬 말단부 확인 후 다리 놓기
        int[][][] arr = new int[N][N][2];
        while(!land.isEmpty()){
            Pair curr = land.poll();    // 현재 위치
            for(int i=0; i<4; i++){
                int nx = curr.x + dx[i], ny = curr.y + dy[i];
                if(0 > nx || nx >= N || 0 > ny || ny >= N)
                    continue;
                // 다음으로 이동한 곳이 같은 섬이 아닌경우
                if(grid[nx][ny] != curr.num){
                    if(grid[nx][ny] == 0 && arr[nx][ny][1] == 0){   // 바다인 경우
                        arr[nx][ny][0] = curr.num;
                        arr[nx][ny][1] = curr.cnt + 1;
                        land.add(new Pair(nx,ny,arr[nx][ny][0],arr[nx][ny][1]));
                        continue;
                    }
                    if(arr[nx][ny][0] != curr.num){ // 다른 섬과 연결된 경우
                        System.out.println(curr.cnt + arr[nx][ny][1]);
                        System.exit(0);
                    }
                }
            }
        }
    }
}