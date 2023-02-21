import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[1001][3];
        int[][] DP = new int[1001][3];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); //빨간색
            arr[i][1] = Integer.parseInt(st.nextToken()); //초록색
            arr[i][2] = Integer.parseInt(st.nextToken()); //파란색
        }
        // 초기화
        for(int i=0; i<3; i++) {
            DP[1][i] = arr[1][i];
        }
        // 시행
        for(int i=2; i<=1000; i++) {
            //현재 선택한 것이 빨간색
            DP[i][0] = Math.min(DP[i-1][1], DP[i-1][2]) + arr[i][0];

            //현재 선택한 것이 초록색
            DP[i][1] = Math.min(DP[i-1][0], DP[i-1][2]) + arr[i][1];

            //현재 선택한 것이 파란색
            DP[i][2] = Math.min(DP[i-1][0], DP[i-1][1]) + arr[i][2];
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0; i<3; i++) {
            answer = Math.min(answer, DP[N][i]);
        }
        System.out.println(answer);
    }
}