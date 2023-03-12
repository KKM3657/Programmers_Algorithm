import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();  // 우선 순위 큐

        for(int i=0; i<N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while(pq.size() != 1){  // 1개가 남을 때까지 시행
            int a = pq.poll();  // A
            int b = pq.poll();  // B

            answer += a + b;    // 묶음 합치기
            pq.add(a+b);    // 합쳐진 묶음을 다시 넣기
        }

        System.out.println(answer);
    }
}