import java.util.Scanner;

public class Main {    
    public static final int MAX_N = 100;
    
    public static int n;
    public static int[][] graph = new int[MAX_N + 1][MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                graph[i][j] = sc.nextInt();
            
        for(int i = 1; i <= n; i++)
            graph[i][i] = 1;

        for(int k = 1; k <= n; k++) 
            for(int i = 1; i <= n; i++)
                for(int j = 1; j <= n; j++)
                    if(graph[i][k] == 1 && graph[k][j] == 1)
                        graph[i][j] = 1;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++)
                System.out.print(graph[i][j] + " ");
            System.out.println();
        }
    }
}