import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    // 격자 범위 안에 들어가는지
    public static boolean inRange(int x,int y){
        return 0 <= x && x < n && 0 <= y && y < n; 
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;
        boolean finish = false;

        int[][] array = new int[n][n];
        // dx,dy 테크닉
        int[] dxs = new int[] {-1,1,0,0};
        int[] dys = new int[] {0,0,-1,1};
        // 2차원 배열 입력
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(array[x][y] + " ");
        // 완전 탐색 실시
        while(!finish){
            for(int i = 0; i < 4; i++){
                boolean answer = false;
                int nx = x + dxs[i];
                int ny = y + dys[i];
                // 격자 범위 안에 들어가는지 + 우선순위에 따른 큰 값이 있는지 판별
                if((inRange(nx,ny))&&(array[x][y] < array[nx][ny])){
                    x = nx;
                    y = ny;
                    System.out.print(array[x][y] + " ");   // 있을시 이동
                    answer = true;
                    break;
                }
                if(i == 3 && !answer){  // 없을시 종료
                    finish = true;
                } 
            }
        }
    }
}