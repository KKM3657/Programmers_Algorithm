import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] tree = new int[T+1];
        int[][] dp = new int[T+1][W+1];

        for(int i=1; i<=T; i++){
            st = new StringTokenizer(br.readLine());
            tree[i] = Integer.parseInt(st.nextToken());
        }

        // 모든 경우 확인
        for(int i=1; i<=T; i++) {
            for(int j=0; j<=W; j++) {
                if(j == 0){ // 체력이 없는 경우
                    if(tree[i] == 1)    // 사과가 떨어지는 경우
                        dp[i][j] = dp[i-1][j] + 1;
                    else    // 현재 위치 그대로
                        dp[i][j] = dp[i-1][j];
                    continue;
                }
                // 짝수인 경우 1번 나무에 있는 경우로 생각(왕복하기 때문)
                if(j%2 == 0) {
                    if(tree[i] == 1)    // 자두가 떨어지는 위치에 따라 더함
                        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + 1);
                    else
                        dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
                }
                // 홀수인 경우 2번 나무에 위치
                else {
                    if(tree[i] == 1)    // 자두가 떨어지는 위치에 따라 더함
                        dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
                    else
                        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]+1);
                } 
            } 
        }
        int answer = 0;
        for(int i=0; i<=W; i++)
            answer = Math.max(answer, dp[T][i]);

        System.out.println(answer);
    }
}