import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int H, W, answer = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        
        // 입력
        arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오른쪽 방향으로 탐색
        int min = arr[0], idx = 0;  // 시작점 설정
        for(int i=1; i<W; i++) {
            if(arr[i] < min)    // 기준값보다 작은 경우 물이 담길수 없음
                continue;
            for(int j=idx+1; j<i; j++)  // 기준값과 같거나 큰 경우 물이 얼마나 담길 수 있는지 계산
                answer += arr[idx] - arr[j];
            idx = i;    // 기준점 변경
            min = arr[i];   // 기준값 변경
        }
        // 왼쪽 방향(오른쪽 방향에서 계산한 물이 중복되지 않게 설정)
        min = arr[W-1];
        idx = W-1;
        for(int i=W-1; i>=0; i--) {
            if(arr[i] <= min)   // 기준값보다 작거나 같을 경우 물이 담길수 없음
                continue;
            for(int j=idx-1; j>i; j--)  // 기준값보다 큰 경우 물이 얼마나 담길 수 있는지 계산
                answer += arr[idx] - arr[j];
            idx = i;    // 기준점 변경
            min = arr[i];   // 기준값 변경
        }
        System.out.println(answer);
    }
}