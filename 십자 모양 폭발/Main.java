import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static int n;
    static int[][] grid;
    // 격자 범위 내에 있는지 판별
    public static boolean in_range(int x, int y){
        return 0<=x && x<n && 0<=y && y<n;
    }
    // 폭발이 터지고 중력이 작용한 결과
    public static void explosion_target(int x, int y){
        int target_x = x-1, target_y = y-1; // 폭발 위치
        
        int[][] temp = new int[n][n];   // 폭발후 중력이 작용한 결과를 나타내기 위한 배열
        int[] dxs = new int[]{-1,0,1,0}, dys = new int[]{0,1,0,-1}; // dx,dy 테크닉
        int range = grid[target_x][target_y];   // 폭발 범위 설정
        grid[target_x][target_y]=0; // 폭발지역 0으로 설정

        for(int i=0; i<4; i++){ // 4방향 적용하기
            int temp_x = target_x, temp_y = target_y;   // 각 방향별로 폭발범위를 적용하기 위한 좌표
            for(int j=1; j<range; j++){ // 폭발 범위 만큼 실시
                int next_x = temp_x + dxs[i], next_y = temp_y + dys[i]; // 다음 좌표
                if(in_range(next_x, next_y)){   // 다음좌표가 격자점 내부의 점인지 판별
                    grid[next_x][next_y] = 0;
                }
                temp_x = next_x;
                temp_y = next_y;
            }
        }
        // 폭발 이후 중력이 작용한 결과
        for(int i=0; i<n; i++){
            int idx = n-1;  // 아래부터 채움
            for(int j=n-1; j>=0; j--){  // 0일때 중력 작용
                if(grid[j][i] != 0){
                    temp[idx][i] = grid[j][i];
                    idx--;
                }
            }
        }
        // 결과 출력
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }


    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        grid = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int target_x = Integer.parseInt(st.nextToken());
        int target_y = Integer.parseInt(st.nextToken());

        explosion_target(target_x,target_y);
    }
}