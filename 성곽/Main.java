import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class Main {
    static int R,C,room,answer1 = 0;
    static int[][] grid, step;  // 격자점, 방의 넓이
    static int[][] wall;    // 막혀있는 형태
    static boolean[][] visited; // 방문 기록
    static int[] dx = new int[]{0,-1,0,1}, dy = new int[]{-1,0,1,0};
    // 깊이 우선 탐색으로 방 넓이 확인
    public static void DFS(int cx, int cy) {
        int[] dir = wall[grid[cx][cy]]; // 해당 방의 모양 탐색
        for(int i=0; i<4; i++) {
            if(dir[i] == 1) // 벽으로 막혀있으면 넘어감
                continue;
            int nx = cx + dx[i], ny = cy + dy[i];
            // 격자점 외부이면 넘어감
            if(0 > nx || nx >= R || 0 > ny || ny >= C)
                continue;
            // 방문한 적이 없으면 기록
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
        // 벽으로 막혀있는 형태를 배열로 나타냄
        for(int i=0; i<16; i++) {
            int value = i;
            for(int j=0; j<4; j++) {
                wall[i][j] = value % 2;
                value /= 2;
            }
        }
        // 입력값
        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 초기화
        visited = new boolean[R][C];
        step = new int[R][C];
        ArrayList<Integer> al = new ArrayList<>();  // 방의 넓이를 저장하기 위한 리스트
        al.add(-1);
        // 방 넓이 탐색 및 방 개수 확인
        int answer2 = 0, answer3 = 0;
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
        // 벽 하나를 제외 했을때 최대 방의 넓이 구하기
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                for(int k=0; k<4; k++) {
                    int nx = i + dx[k], ny = j + dy[k];
                    if (0 > nx || nx >= R || 0 > ny || ny >= C)
                        continue;
                    if (step[i][j] != step[nx][ny]) // 다른 방이면 벽을 허물었을때 최대 값이 되는지 판별
                        answer3 = Math.max(answer3, al.get(step[i][j]) + al.get(step[nx][ny]));
                }
            }
        }

        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);
    }
}