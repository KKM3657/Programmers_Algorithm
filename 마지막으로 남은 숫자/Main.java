import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Collections;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }

        do{
            if(pq.size() == 0)
                break;
            int a = pq.poll(), b = pq.poll();
            if(a != b)
                pq.add(Math.abs(a-b));
        }while(pq.size() != 1);
        
        if(pq.isEmpty())
            System.out.println(-1);
        else
            System.out.println(pq.peek());
    }
}