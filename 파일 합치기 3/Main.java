import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>(); // 우선 순위 큐
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 데이터 입력
            for(int i=0; i<N; i++){
                pq.add(Long.parseLong(st.nextToken()));
            }
            
            long answer = 0;
            // 파일이 한개가 될 때까지 합치기
            while(pq.size() > 1){
                long a = pq.poll();
                long b = pq.poll();
                pq.add(a+b);
                answer += (a+b);
            }

            System.out.println(answer);
        }
    }
}