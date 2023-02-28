import java.util.Scanner;

public class Main {    
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100000;
    
    public static int n;
    public static int[] x = new int[MAX_N];
    public static int[] y = new int[MAX_N];
    public static int[] L = new int[MAX_N];
    public static int[] R = new int[MAX_N];
    
    public static int ans = INT_MAX;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        
        L[0] = 0;
        for(int i = 1; i < n; i++)
            L[i] = L[i - 1] + Math.abs(x[i] - x[i - 1]) + Math.abs(y[i] - y[i - 1]);
        
        R[n - 1] = 0;
        for(int i = n - 2; i >= 0; i--)
            R[i] = R[i + 1] + Math.abs(x[i + 1] - x[i]) + Math.abs(y[i + 1] - y[i]);
        
        for(int i = 1; i < n - 1; i++)
            ans = Math.min(ans, L[i - 1] + R[i + 1] + Math.abs(x[i + 1] - x[i - 1]) + Math.abs(y[i + 1] - y[i - 1]));

        System.out.print(ans);
    }
}