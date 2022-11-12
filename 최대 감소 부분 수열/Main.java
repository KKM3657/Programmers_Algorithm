import java.util.Scanner;

public class Main {
    public static final int MAX_N = 1000;
    
    // 변수 선언
    public static int n;
    public static int[] arr = new int[MAX_N];
    
    
    // 마지막으로 고른 원소의 위치가 i인 부분 수열 중 최장 감소 부분 수열의 길이
    public static int[] dp = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        for(int i = 0; i < n; i++){
            dp[i] = 1;

            // 부분 수열 중 최대 감소 부분 수열의 길이를 계산합니다.
            for(int j = 0; j < i; j++) {
                if(arr[j] > arr[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        // 마지막 원소의 위치가 i일 때의 부분 수열들 중 가장 길이가 긴 감소 부분 수열
        int ans = 0;
        for(int i = 0; i < n; i++)
            ans = Math.max(ans, dp[i]);

        System.out.print(ans);
    }
}