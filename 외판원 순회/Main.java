import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, answer = Integer.MAX_VALUE;
    static int array[][];
    static boolean visited[];

    public static void find_answer(int cnt, int prev, int value){
        // 모든 정점을 방문한 경우
        if(cnt == n){
            // 돌아가는 길이 0이면 정답이 될수 없음
            if(array[prev][0] == 0)
                return;
            // 돌아가는 길 더하기
            int total = value + array[prev][0];
            // 갱신
            if(total < answer)
                answer = total;
            return;
        }
        // 방문하기
        for(int i=1; i<n; i++){
            if(visited[i] || array[prev][i] == 0)
                continue;
            visited[i] = true;
            find_answer(cnt+1, i, value+array[prev][i]);

            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        array = new int[n][n];
        visited = new boolean[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //1번 노드 방문
        visited[0] = true;
        find_answer(1, 0, 0);

        System.out.println(answer);
    }
}