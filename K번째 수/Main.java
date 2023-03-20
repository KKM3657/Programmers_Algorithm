import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                pq.add(i*j);
            }
        }

        for(int i=1; i<k; i++){
            pq.poll();
        }
        System.out.println(pq.poll());
    }
}