import java.util.Scanner;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int n, k, b;
    public static int[] arr = new int[MAX_N + 1];
    public static int[] prefixSum = new int[MAX_N + 1];
    public static int ans = INT_MAX;
    
    public static int getSum(int s, int e) {
        return prefixSum[e] - prefixSum[s - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        b = sc.nextInt();
        while(b-- > 0) {
            int x = sc.nextInt();
            arr[x] = 1;
        }

        prefixSum[0] = 0;
        for(int i = 1; i<= n; i++)
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        
        for(int i = 1; i <= n - k + 1; i++)
            ans = Math.min(ans, getSum(i, i + k - 1));

        System.out.print(ans);
    }
}