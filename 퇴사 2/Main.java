import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+2][2];
        int[] dp = new int[N+2];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for(int i=1; i<=N+1; i++){
            // 이전까지의 최대 이익
            max = Math.max(max, dp[i]);

            // 상담이 끝나는 날이 퇴사날 전인지 판별
            int next = i + arr[i][0];
            // 상담이 끝난 지점에서의 최대값이 기존의 최댓값 보다 크면 갱신 -> 퇴사날 당일에 끝낼수 있으면 비용 받음
            if(next <= N+1){
                dp[next] = Math.max(dp[next], max + arr[i][1]);
            }
        }
        System.out.println(max);
    }
}