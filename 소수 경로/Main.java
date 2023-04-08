import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static boolean[] dp, visited;   // 소수, 방문기록
    static int[] cnt;   // 변경 횟수
    static int end; // 끝점
    static Queue<Integer> q;    // 큐
    // 소수 판별
    public static boolean is_optimal(int value){
        for(int i=2; i * i <= value; i++){
            if(value % i == 0)
                return false;
        }
        return true;
    }
    // 해당 자릿수 숫자 변경
    public static int change(int value, int pos, int num){
        StringBuilder sb = new StringBuilder(String.valueOf(value));
        sb.setCharAt(pos, (char) (num + '0'));
        return Integer.parseInt(sb.toString());
    }
    public static void bfs(){
        // 큐가 빌때까지
        while(!q.isEmpty()) {
            int num = q.poll();
            // 각 자릿수 확인
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j <= 9; j++) {  // 해당하는 숫자로 변경
                    if (i == 0 && j == 0)   // 1000의 자리가 0이면 넘어감
                        continue;
                    int value = change(num, i, j);  // 숫자 바꾸기
                    if (dp[value] && !visited[value]) { // 소수이면서 방문한 적이 없으면 시행
                        q.add(value);
                        visited[value] = true;
                        cnt[value] = cnt[num] + 1;  // 횟수 + 1
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new boolean[10000];

        for(int i=1000; i<10000; i++){  // 소수 확인
            if(is_optimal(i))
                dp[i] = true;
        }

        for(int t=0; t<N; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());

            q = new LinkedList<>();
            end = Integer.parseInt(st.nextToken());
            visited = new boolean[10000];
            cnt = new int[10000];
            // 시작점 초기화
            q.add(start);
            visited[start] = true;

            bfs();
            // 끝에 해당하는 숫자가 소수가 아니면 불가능 
            if(!visited[end] && cnt[end] == 0)
                System.out.println("Impossible");
            else
                System.out.println(cnt[end]);
        }
    }
}