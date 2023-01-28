import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100000;
    
    public static int n;
    public static int[] dist = new int[MAX_N + 1];
    public static int[] cost = new int[MAX_N + 1];
    public static int[] minCost = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 2; i <= n; i++)
            dist[i] = sc.nextInt();
        for(int i = 1; i <= n; i++)
            cost[i] = sc.nextInt();
        
        minCost[2] = cost[1];
        for(int i = 3; i <= n; i++)
            minCost[i] = Math.min(minCost[i - 1], cost[i - 1]);
        
        long ans = 0;
        for(int i = 1; i <= n; i++) {
            ans += (long) minCost[i] * dist[i];
        }
        
        System.out.print(ans);
    }
}