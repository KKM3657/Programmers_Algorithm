import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 횟수
        int T = Integer.parseInt(st.nextToken());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long answer = 0;    // 정답

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            // 입력
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int value = arr[n-1];   // 뒤에서 부터 순회
            for(int i=n-1; i>=0; i--){
                if(value >= arr[i]) // 뒤에 있는 값이 더 크면 차이 만큼 이윤을 얻음
                    answer += value - arr[i];
                else    // 앞에 있는 값이 더 크면 갱신
                    value = arr[i];
            }
            System.out.println(answer);
        }
    }
}