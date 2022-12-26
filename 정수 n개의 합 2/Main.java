import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MIN_VALUE;
        dp[0] = arr[0];

        // 누적 합 저장
        for(int i=1; i<n; i++){
            dp[i] = dp[i-1] + arr[i];
        }

        // 구간 별 최대 합
        for(int i=1; i<n-k+1; i++){
            answer = Math.max(answer, dp[i+k-1] - dp[i-1]);
        }
        System.out.println(answer);

    }
}