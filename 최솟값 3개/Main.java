import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
            if(pq.size() < 3){
                System.out.println(-1);
                continue;
            }
            long value1 = pq.poll();
            long value2 = pq.poll();
            long value3 = pq.poll();

            pq.add(value1);
            pq.add(value2);
            pq.add(value3);

            System.out.println(value1*value2*value3);
        }
    }
}