import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100;
    
    // 변수 선언
    public static int n, m;
    public static int[][] dist = new int[MAX_N + 1][MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        m = sc.nextInt();

        // 그래프를 인접행렬로 표현합니다.
        // dist에 입력을 받아줍니다.
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                dist[i][j] = sc.nextInt();
        
        for(int k = 1; k <= n; k++) // 확실하게 거쳐갈 정점을 1번부터 N번까지 순서대로 정의합니다.
            for(int i = 1; i <= n; i++) // 고정된 k에 대해 모든 쌍 (i, j)를 살펴봅니다.
                for(int j = 1; j <= n; j++)
                    // i에서 j로 가는 거리가 k를 경유해 가는 것이 더 좋다면
                    // dist[i][j]값을 갱신해줍니다.
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

        // m개의 질문에 대해 최단 거리를 답변합니다.
        for(int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            // 모든 쌍에 대한 최단거리 결과를 가지고 있기 때문에,
            // 어느 경로를 질문하더라도 바로 최단거리를 출력할 수 있습니다.
            System.out.println(dist[x][y]);
        }
    }
}