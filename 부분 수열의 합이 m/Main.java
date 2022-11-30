import java.util.Scanner;

public class Main {
    public static final int MAX_ANS = 101;
    public static final int MAX_M = 10000;
    public static final int MAX_N = 100;
    
    // 변수 선언:
    public static int n, m;
    public static int[] arr = new int[MAX_N];
    public static int[] dp = new int[MAX_M + 1];
    
    public static void initialize() {
        for(int i = 0; i <= m; i++)
            dp[i] = MAX_ANS;
        dp[0] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        initialize();
        for(int i = 0; i < n; i++) {
            for(int j = m; j >= 0; j--) {
                if(j >= arr[i])
                    dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }

        int minLen = dp[m];
        if(minLen == MAX_ANS)
            minLen = -1;

        System.out.print(minLen);
    }
}