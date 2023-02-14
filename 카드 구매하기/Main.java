import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N+1];   // 입력
        int[] dp = new int[1001];   // DP

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=1; i<=N; i++) {
            int result = arr[i];    // N개 카드가 포함된 팩
            for(int j=1; j<=i/2; j++) {
                result = Math.max(result, (dp[j] + dp[i-j]));   // 분할된 카드팩
            }
            dp[i] = result; // 결과로 나온 카드팩
        }
        System.out.println(dp[N]);
    }
}