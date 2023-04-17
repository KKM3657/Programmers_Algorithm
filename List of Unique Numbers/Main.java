// 연속한 ~ 수 => 투 포인터 활용
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        boolean[] visited = new boolean[100001];    // 방문기록
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        int l = 0, r = -1;

        while(l < N){
            while(r + 1 < N && !visited[arr[r+1]]){ // 해당 숫자를 방문한 적이 있으면 멈춤
                visited[arr[r+1]] = true;
                r++;
            }

            answer += r - l + 1;    // 구간에 해당하는 길이가 갯수가 됨
            visited[arr[l]] = false;    // l를 다음 지점으로 이동
            l++;
        }
        System.out.println(answer);
    }
}