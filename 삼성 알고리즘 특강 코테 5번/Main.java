import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        // k개의 테스트 케이스
        for(int k=1; k<=t; k++){
            int answer = Integer.MIN_VALUE; //  정답

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] array1 = new int[n+1];    // 존이 좋아하는 정도가 저장된 배열
            int[] array2 = new int[n+1];    // 클로이가 좋아하는 정도가 저장된 배열
            int[] dp1_r = new int[n+2], dp1_l = new int[n+2];   // 오른쪽 방향, 왼쪽 방향으로 저장된 연속 구간 최대 합(존)
            int[] dp2_r = new int[n+2], dp2_l = new int[n+2];   // 오른쪽 방향, 왼쪽 방향으로 저장된 연속 구간 최대 합(클로이)
            int[] dp1_rM = new int[n+2], dp1_lM = new int[n+2]; // 오른쪽 방향, 왼쪽 방향으로 인덱스 까지의 누적 최대값(존)
            int[] dp2_rM = new int[n+2], dp2_lM = new int[n+2]; // 오른쪽 방향, 왼쪽 방향으로 인덱스 까지의 누적 최대값(클로이)

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                array1[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                array2[i] = Integer.parseInt(st.nextToken());
            }
            
            // 오른쪽 방향 연속 구간 최대 합(dp)
            for(int i=1; i<=n; i++){
                dp1_r[i] = Math.max(0, dp1_r[i-1]) + array1[i];
                dp2_r[i] = Math.max(0, dp2_r[i-1]) + array2[i];
            }
            // 왼쪽 방향 연속 구간 최대 합(dp)
            for(int i=n; i>=1; i--){
                dp1_l[i] = Math.max(0, dp1_l[i+1]) + array1[i];
                dp2_l[i] = Math.max(0, dp2_l[i+1]) + array2[i];
            }

            // 초기화
            dp1_rM[1] = array1[1];
            dp2_rM[1] = array2[1];

            // 오른쪽 방향 인덱스 까지의 누적 최대값(dp)
            for(int i=2; i<=n; i++){
                dp1_rM[i] = Math.max(dp1_r[i], dp1_rM[i-1]);
                dp2_rM[i] = Math.max(dp2_r[i], dp2_rM[i-1]);
            }

            // 초기화
            dp1_lM[n] = array1[n];
            dp2_lM[n] = array2[n];

            // 왼쪽 방향 인덱스 까지의 누적 최대값(dp)
            for(int i=n-1; i>=1; i--){
                dp1_lM[i] = Math.max(dp1_l[i], dp1_lM[i+1]);
                dp2_lM[i] = Math.max(dp2_l[i], dp2_lM[i+1]);
            }

            // 합이 최대가 되는 경우 탐색
            for(int i=n-1; i >= 1; i--) {
                answer = Math.max(dp1_lM[i+1] + dp2_rM[i], answer);
            }
            for(int i=1; i < n; i++) {
                answer = Math.max(dp1_rM[i] + dp2_lM[i+1], answer);
            }

            System.out.printf("#%d %d\n",k,answer);
        }
    }
}
