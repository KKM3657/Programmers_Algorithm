import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
// 격자점을 나타내기 위한 클래스
class Pair{
    int x, y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int n, k;
    static int[][] grid;
    static int[] dx = new int[]{0,-1,0,1}, dy = new int[]{-1,0,1,0};    // dx, dy 테크닉
    // 격자점 위의 점인지 판별
    public static boolean in_range(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < n;
    }
    // 조건에 만족하는 격자점을 bfs로 찾기
    public static Pair find_point(Pair start){
        int max_value = 0;
        Pair max_point = start; // 시작 지점

        boolean[][] visited = new boolean[n][n];    // 방문 기록 배열
        Queue<Pair> q = new LinkedList<>(); // 다음으로 이동할 격자점을 저장하기 위한 큐
        q.add(start);   // 초기값 설정
        visited[start.x][start.y] = true;   // 방문
        int value = grid[start.x][start.y]; // 기준이 되는 값 설정
        // 큐가 빌때 까지 반복
        while(!q.isEmpty()){
            // 현재 위치
            Pair curr = q.poll();
            // 4방향 탐색
            for(int i=0; i<4; i++){
                int next_x = curr.x + dx[i], next_y = curr.y + dy[i];   // 다음으로 이동할 좌표
                // 격자점 내부의 점, 기준이 되는 값보다 작은지, 방문한 적이 있는지 확인
                if(in_range(next_x, next_y) && value > grid[next_x][next_y] && !visited[next_x][next_y]){
                    visited[next_x][next_y] = true;
                    q.add(new Pair(next_x, next_y));
                    // 도달할 수 있는 칸들 중 최댓값 설정
                    // 다음으로 이동하는 값이 최댓값이면 갱신
                    if(max_value < grid[next_x][next_y]){
                        max_value = grid[next_x][next_y];
                        max_point = new Pair(next_x, next_y);
                    // 다음으로 이동하는 값이 기존의 최댓값과 같으면 행, 열 비교
                    } else if(max_value == grid[next_x][next_y]){
                        if(max_point.x > next_x){
                            max_value = grid[next_x][next_y];
                            max_point = new Pair(next_x, next_y);

                        } else if(max_point.x == next_x){
                            if(max_point.y > next_y){
                                max_value = grid[next_x][next_y];
                                max_point = new Pair(next_x, next_y);
                            }
                        }
                    }
                }
            }
        }
        return max_point;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        grid = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        Pair start = new Pair(l,c);
        // k번째 최댓값 탐색
        for(int i=0; i<k; i++){
            Pair curr = find_point(start);
            start = curr;
        }
        System.out.println((start.x+1) + " " + (start.y+1));
    }
}