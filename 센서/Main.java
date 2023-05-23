import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
	// 집중국이 더 많은 경우
        if(K >= N) {
            System.out.println(0);
            return;
        }

        int[] arr = new int[N];
        Integer[] sub = new Integer[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
	// 센서들 간의 차이
        for(int i=0; i<N-1; i++){
            sub[i] = arr[i+1] - arr[i];
        }
        Arrays.sort(sub, Collections.reverseOrder());
	// 최소 길이의 센서들 간의 차이의 합
        int answer = 0;
        for(int i=K-1; i<N-1; i++){
            answer += sub[i];
        }
        System.out.println(answer);
    }
}
