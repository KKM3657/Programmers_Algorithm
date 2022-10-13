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
        for(int i = 0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = array[0];
        // 끝점을 기준으로 최대가 되는 값 계산
        for(int i = 1; i<n; i++){
            dp[i] = Math.max(dp[i-1] + array[i], array[i]);
        }
        int max = Integer.MIN_VALUE;
        for(int value : dp){
            if(max < value){
                max = value;
            }
        }
        System.out.println(max);
    }
}