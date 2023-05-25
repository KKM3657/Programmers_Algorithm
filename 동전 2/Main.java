import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 동전 갯수
        int K = Integer.parseInt(st.nextToken());   // 금액

        int[] value = new int[K+1];
        int[] price = new int[N];
        // 초기화
        for(int i=0; i<N; i++)
            price[i] = Integer.parseInt(br.readLine());
        
        Arrays.sort(price);
        Arrays.fill(value, -1);
        // 1인 경우
        for(int i=0; i<N; i++){
            if(price[i] <= K)
                value[price[i]] = 1;
        }
        // 경우 탐색
        for(int k=1; k<=K; k++){
            for(int i=0; i<N; i++){ // 모든 동전의 경우
                int temp = price[i];    // 현재 동전
                if(temp >= k)   // 현재 동전을 만들수 없거나 최소 경우인 경우 넘어감
                    break;
                if(k - temp > 0){   // 만들수 있는 경우
                    if(value[k-temp] != -1) {   // 해당 금액을 만들수 있는 경우 최소 경우 탐색
                        if (value[k] == -1)
                            value[k] = value[k - temp] + 1;
                        else
                            value[k] = Math.min(value[k], value[k - temp] + 1);
                    }
                }
            }
        }
        System.out.println(value[K]);
    }
}