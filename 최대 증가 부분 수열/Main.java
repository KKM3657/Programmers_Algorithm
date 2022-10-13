import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int[] array = new int[n];
        int[] dp = new int[n];
        st = new StringTokenizer(br.readLine());
        // 수열 입력 및 dp 초기화
        for(int i =0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;  // 시작이 1개 부터 이므로 1로 초기화
        }

        dp[0] = 1;

        for(int i = 1; i<n; i++){
            for(int j = 0; j<i; j++){                
                if(array[i] > array[j]){    // 증가하는 경우만 생각
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 선택
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}