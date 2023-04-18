import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[][] dp = new long[N+1][M+1];   // dp 생성

        for(int i=0; i<=M; i++){    // 1개의 숫자로 표현할 수 있는 경우 초기화
            dp[1][i] = 1;
        }
        for(int i=1; i<=N; i++){    // 0을 표현할 수 있는 경우는 1가지 
            dp[i][0] = 1;
        }

        // n개의 숫자로 M을 표현하는 방법은 n개의 숫자로 M-1을 표현하고 M을 더하면 만들수 있다. 
        for(int i=2; i<=N; i++){
            for(int j=1; j<=M; j++){
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
            }
        }

        System.out.println(dp[N][M]);
    }
}