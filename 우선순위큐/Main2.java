import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Collections;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            int k = sc.nextInt();
            if(k==0){
                if(!pq.isEmpty())
                    System.out.println(pq.poll());
                else
                    System.out.println(0);
            }
            else
                pq.add(k);
        }
    }
}