import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, answer = 0;
    static int[] arr;
    public static void find_building(int start){
        int r_cnt = 0, l_cnt = 0;   // 보이는 빌딩 카운트
        long tx = 1, ty = Integer.MIN_VALUE;    // 초기화
        // 시작점에서 오른쪽을 봤을때 보이는 건물 찾기
        for(int i=start+1; i<=n; i++) {
            long dx = i - start, dy = arr[i] - arr[start];
            // 기울기가 더 클때 건물이 보임
            if(dx * ty < tx * dy){
                tx = dx;
                ty = dy;
                r_cnt++;
            }
        }
        tx = 1;
        ty = Integer.MIN_VALUE;
        // 시작점에서 왼쪽을 봤을때 보이는 건물 찾기
        for(int i=start-1; i>=1; i--){
            long dx = i - start, dy = arr[i] - arr[start];
            // 기울기가 더 작을때 건물이 보임
            if(dx * ty > tx * dy){
                tx = dx;
                ty = dy;
                l_cnt++;
            }
        }
        // 최대로 보이는 건물 찾기
        answer = Math.max(answer, r_cnt + l_cnt);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=n; i++){
            find_building(i);
        }
        System.out.println(answer);
    }
}