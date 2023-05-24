import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
public class Main {
    static int N;
    static String input;
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        N = input.length();
        long[] dp = new long[N+1];
        dp[0] = 1;

        for(int i=0; i<N; i++) {
            int curr = input.charAt(i) - '0'; // 1자리 수 변환
            if(curr != 0){
                // 0이 아니면 무조건 암호표에 대응한다
                dp[i + 1] += dp[i];
                dp[i + 1] %= 1000000;
            }
            if(i == 0)
                continue;
            // 이전 인덱스의 값을 숫자로 변환
            int prev = input.charAt(i - 1) - '0';

            // 이전값이 0이었다면 합쳐봐야 2자리 수가 되지 못하므로 건너뛴다
            if(prev == 0){
                continue;
            }

            // 합쳐서 2자리 수로 만든다
            prev = prev * 10 + curr;

            if(prev <= 26){
                // 2자리 수이기에 무조건 10이상이다. 26이하이면 암호표에 대응한다
                dp[i + 1] += dp[i - 1];
                dp[i + 1] %= 1000000;
            }
        }
        // 최종 경우의 수를 출력
        System.out.println(dp[N]);
    }
}