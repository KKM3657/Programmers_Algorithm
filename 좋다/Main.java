import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        int answer = 0;
        for(int i=0; i<N; i++){
            int l = 0, r = N-1; // 처음과 끝점 설정
            while(true){
                if(i == l) l++; // 서로 다른수가 아니므로 다음 지점으로 이동
                else if(i == r) r--;   // 서로 다른수가 아니므로 다음 지점으로 이동
                if(l >= r)  // 넘어가는 경우 멈춤
                    break;
                
                if(arr[i] > arr[l] + arr[r])    // 값이 크면 l을 1추가
                    l++;
                else if(arr[i] < arr[l] + arr[r])   // 값이 작으면 r를 1빼기
                    r--;
                else{   // 해당하는 값이 만들어지면 좋은 수!
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}