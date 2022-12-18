import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Collections;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int n = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String func = st.nextToken();

            if(func.equals("push")){
                pq.add(Integer.parseInt(st.nextToken()));
            }
            else if(func.equals("pop")){
                System.out.println(pq.poll());
            }
            else if(func.equals("size")){
                System.out.println(pq.size());
            }
            else if(func.equals("empty")){
                if(pq.isEmpty())
                     System.out.println(1);
                else
                     System.out.println(0);
            }
            else
                System.out.println(pq.peek());
        }
    }
}