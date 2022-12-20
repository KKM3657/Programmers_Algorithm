import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Collections;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int value = sc.nextInt();
            if(value == 0){
                if(pq.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(pq.poll());
            }
            pq.add(value);
        }
    }
}