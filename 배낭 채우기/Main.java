import java.util.Scanner;

public class Main {
    public static final int INT_MIN = Integer.MIN_VALUE;
    public static final int MAX_M = 10000;
    public static final int MAX_N = 100;
    public static int[][] dp = new int[MAX_N + 1][MAX_M + 1];
    public static int n, m;
    public static int[] weight = new int[MAX_N + 1];
    public static int[] value = new int[MAX_N + 1];
    
    public static void initialize() {
        for(int i = 0; i <= n; i++)
            for(int j = 0; j <= m; j++)
                dp[i][j] = INT_MIN;
        
        dp[0][0] = 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        initialize();

        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= m; j++) {
                if(j >= weight[i])
                    dp[i][j] = Math.max(dp[i - 1][j - weight[i]] + value[i], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        int ans = 0;

        for(int j = 0; j <= m; j++)
            ans = Math.max(ans, dp[n][j]);

        System.out.print(ans);
    }
}