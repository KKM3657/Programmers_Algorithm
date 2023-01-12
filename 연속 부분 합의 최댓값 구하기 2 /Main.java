import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        // 최대 구간 합 찾기
        for(int i=1; i<n; i++){
            dp[i] = Math.max(0, dp[i-1]) + arr[i];
        }

        Arrays.sort(dp);
        System.out.println(dp[n-1]);

    }
}