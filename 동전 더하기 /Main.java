import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int idx = n-1, answer = 0;
        while(k > 0 && idx >= 0){   // 답을 찾을때까지 반복
            if(arr[idx] > k){   // 넘어가는 경우
                idx--;
                continue;
            }
            answer += k / arr[idx]; // 최소 동전을 선택하기 위한 전략(제일 큰 배수 부터)
            k = k % arr[idx];   // 나머지도 같은 전략 사용
            idx--;
        }
        System.out.println(answer);
    }
}