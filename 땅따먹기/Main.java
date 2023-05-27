import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, K, answer = 0;
    static int[][] arr, temp;
    static boolean[][] pick;
    public static void solution(int x, int y, int select, int value){
        if(select == K){
           answer = Math.max(answer, value);
           return;
        }
        if(select < K && x >= N){
            return;
        }
        // 다음 좌표
        int nx = x, ny = y + 3;
        if(ny >= N-2){
            nx += 1;
            ny = 0;
        }

        // 선택
        pick[x][y] = true;
        solution(nx, ny, select+1, value+temp[x][y]);
        pick[x][y] = false;

        // 다음 좌표
        nx = x;
        ny = y + 1;
        if(ny >= N-2){
            nx += 1;
            ny = 0;
        }
        // 선택하지 않고 넘어감
        solution(nx, ny, select, value);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        temp = new int[N][N-2];
        pick = new boolean[N][N-2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N-2; j++){
                temp[i][j] = arr[i][j] + arr[i][j+1] + arr[i][j+2];
            }
        }
        
        solution(0, 0, 0, 0);

        if(answer == 0)
            System.out.println(-1);
        else
            System.out.println(answer);
    }
}