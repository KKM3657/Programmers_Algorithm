import java.util.Scanner;

public class Main {
    public static final int MAX_N = 400;
    
    public static int n, k;
    public static int[][] board = new int[MAX_N + 1][MAX_N + 1];
    public static int[][] s = new int[MAX_N + 1][MAX_N + 1];
    public static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++) board[i][j] = sc.nextInt();

        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                s[i][j] = s[i][j-1] + board[i][j];
        
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++) {
                int sumAll = 0;
                for(int r = i - k; r <= i + k; r++) {
                    int c = k - Math.abs(i - r);

                    if(1 <= r && r <= n)
                        sumAll += s[r][Math.min(j + c, n)] - s[r][Math.max(j - c - 1, 0)];
                }
                
                ans = Math.max(ans, sumAll);
            }
        
        System.out.print(ans);
    }
}