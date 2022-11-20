import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;
// 좌표를 나타내기 위한 클래스
class Pair{
    int x;
    int y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int n;
    static int answer = 0;
    static int[][] grid;
    static int[][] visited;
    static int[] dx = new int[]{-1,1,0,0}, dy = new int[]{0,0,-1,1};  // dx, dy 테크닉
    static LinkedList<Pair> start_point = new LinkedList<>();   // 시작점을 위한 리스트
    static Queue<Pair> q = new LinkedList<>();  // 다음으로 이동할 좌표 저장
    // 격자 범위내에 있는지 판별
    public static boolean in_range(int x, int y){
        return  0 <= x && x < n && 0 <= y && y < n;
    }
    // 너비우선 탐색으로 찾기
    public static void bfs(Pair start){
        // 이미 방문한적이 있으면 반환
        if(visited[start.x][start.y] != 0)
            return;
        q.add(start);
        answer++;
        visited[start.x][start.y] = answer;
        // 너비우선 탐색 실시
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int curr_x = curr.x, curr_y = curr.y;
            for(int i=0; i<4; i++){
                // 다음으로 이동할 좌표가 격자점 내부이면서 방문한적이 없는경우 이동
                int next_x = curr_x + dx[i], next_y = curr_y + dy[i];
                if(in_range(next_x, next_y) && grid[next_x][next_y] == 0 && visited[next_x][next_y] == 0){
                    q.add(new Pair(next_x, next_y));
                    answer++;
                    visited[next_x][next_y] = answer;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        visited = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            start_point.add(new Pair(x,y));
        }
        
        for(int i=0; i<start_point.size(); i++){
            Pair curr = start_point.get(i);
            bfs(curr);
        }
        System.out.println(answer);
    }
}