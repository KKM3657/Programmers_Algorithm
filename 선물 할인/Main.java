import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int n, a, b, answer = 0;
    static long[] arr;
    public static void max_present() {
        int temp = 0;
        // 구간 탐색
        for(int i=0; i<n; i++){
            temp += arr[i]/2;   // 반값으로 선택
            if(i - a > 0){  // 반값 선택에 포함되지 않으면 할인한 만큼 다시 더하기
                temp += arr[i-a]/2;
            }
            // 예산 초과면 종료
            if(temp > b)
                break;
            answer++;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());

        arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        max_present();
        System.out.println(answer);
    }
}