import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] dp;
    static int[] coin;

    // 초기화
    public static void initialize(){
        for(int i = 0; i <= m; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        coin = new int[n+1];
        dp = new int[m+1];
        st = new StringTokenizer(br.readLine());

        // 동전 모음
        for(int i = 1; i<=n; i++){
            coin[i] = Integer.parseInt(st.nextToken()); 
        }

        initialize();
        
        // 마지막에 선택한 동전중 최소 개수를 선택
        for(int i = 0; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(i>= coin[j]){
                    if(dp[i - coin[j]] == Integer.MAX_VALUE)
                        continue;
                    dp[i] = Math.min(dp[i], dp[i - coin[j]] + 1);
                }
            }
        }

        int ans = dp[m];
        if(ans == Integer.MAX_VALUE)
            ans = -1;
        System.out.println(ans);
    }
}