import java.util.Scanner;

public class Main {
    public static final long MAX_NUM = (long)1e14;
    public static final int MAX_M = 100000;
    
    public static int n, m;
    public static int[] arr = new int[MAX_M];
    
    public static boolean isPossible(long transitTime) {
        long cnt = 0;
        for(int i = 0; i < m; i++) {
            cnt += transitTime / arr[i];
        }
    
        return cnt >= n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < m; i++)
            arr[i] = sc.nextInt();
        
        long left = 1;
        long right = MAX_NUM;
        long ans = MAX_NUM;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            if(isPossible(mid)) {
                right = mid - 1;
                ans = Math.min(ans, mid);
            }
            else                               
                left = mid + 1;
        }

        System.out.print(ans);
    }
}