import java.util.Scanner;

public class Main {    
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int[] arr = new int[MAX_N + 1];
    public static int n, s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        s = sc.nextInt();
        for(int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();

        int ans = INT_MAX;
        int sumVal = 0;
        int j = 0;
        for(int i = 1; i <= n; i++) {
            // 구간 내 합이 s보다 작으면 계속 진행합니다.
            while(j + 1 <= n && sumVal < s) {
                sumVal += arr[j + 1];
                j++;
            }
            if(sumVal < s)
                break;
            ans = Math.min(ans, j - i + 1);
            sumVal -= arr[i];
        }

        if(ans == INT_MAX)
            ans = -1;
        System.out.print(ans);
    }
}