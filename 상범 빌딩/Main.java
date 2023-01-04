import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int L,R,C;   // 층, 행, 열
    static char[][][] arr;  // 격자점
    static int[][][] steps; // 걸린 시간
    static Pair start, end; // 시작점, 끝점
    // dz, dx, dy 테크닉
    static int[] dz = new int[]{0,0,0,0,1,-1}, dx = new int[]{0,1,0,-1,0,0}, dy = new int[]{1,0,-1,0,0,0};
    // 좌표를 나타내는 클래스
    static class Pair{
        int z;
        int x;
        int y;

        Pair(int z, int x, int y){
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }
    // 격자점 내부의 점인지 판별
    public static boolean in_range(int z, int x, int y){
        return 0 <= z && z < L && 0 <= x && x < R && 0 <= y && y < C;
    }
    // bfs로 최단 시간 탐색
    public static void bfs(){
        boolean[][][] visited = new boolean[L][R][C];   // 방문 기록
        visited[start.z][start.x][start.y] = true;  // 시작점 방문
        Queue<Pair> q = new LinkedList<>(); // 큐
        q.add(start);   // 시작점 추가

        // 큐가 빌때까지
        while(!q.isEmpty()){
            Pair curr = q.poll();   // 현재 지점
            int value = steps[curr.z][curr.x][curr.y];  // 현재 걸린 시간

            // 6방향 확인
            for(int i=0; i<6; i++){
                int n_z = curr.z + dz[i];   // 다음으로 이동할 층
                int n_x = curr.x + dx[i];   // 다음으로 이동할 행
                int n_y = curr.y + dy[i];   // 다음으로 이동할 열
                // 격자점 내부의 점인지, 금으로 막혀있지 않은지, 방문하지 않았던 곳인지 확인
                if(in_range(n_z,n_x,n_y) && arr[n_z][n_x][n_y] != '#' && !visited[n_z][n_x][n_y]){
                    visited[n_z][n_x][n_y] = true;
                    steps[n_z][n_x][n_y] = value + 1;
                    if(arr[n_z][n_x][n_y] == 'E')   // 탈출
                        break;
                    q.add(new Pair(n_z,n_x,n_y));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == R && R == C && C == 0)
                break;

            arr = new char[L][R][C];
            steps = new int[L][R][C];

            for(int i=0; i<L; i++){
                for(int j=0; j<R; j++){
                    String input = br.readLine();
                    for(int l=0; l<C; l++){
                        arr[i][j][l] = input.charAt(l);
                        if(arr[i][j][l] == 'S') // 시작점
                            start = new Pair(i,j,l);
                        else if(arr[i][j][l] == 'E')    // 끝점
                            end = new Pair(i,j,l);
                    }
                }
                br.readLine();
            }

            bfs();
            int result = steps[end.z][end.x][end.y];
            if(result == 0)
                System.out.println("Trapped!");
            else
                System.out.println("Escaped in " + result + " minute(s).");
        }
    }
}