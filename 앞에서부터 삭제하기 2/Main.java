import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //K는 1이상 N - 2 이하까지만 고려
        pq.add(arr[n-1]);
        int total = arr[n-1];

        double answer = 0;
        // 뒤에서부터 탐색 시작
        for(int i=n-2; i>=1; i--){
            pq.add(arr[i]);
            total += arr[i];
            double value = (double)(total - pq.peek()) / (n-i-1);   // 우선순위 큐에서 최소값 찾기
            if(answer < value)
                answer = value;
        }
        System.out.printf("%.2f", answer);
    }
}