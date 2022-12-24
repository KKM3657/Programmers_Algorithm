import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        for(int t=0; t<k; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int middle = 0;
            int target = 0;
    
            PriorityQueue<Integer> max_heap = new PriorityQueue<>();    // 중앙값보다 큰 값중에 최소값
            PriorityQueue<Integer> min_heap = new PriorityQueue<>(Collections.reverseOrder()); // 중앙값보다 작은 값중에 최대값
            for(int i=1; i<=n; i++){
                int value = Integer.parseInt(st.nextToken());
                if(i==1){
                    middle = value;
                    System.out.print(middle + " ");
                    continue;
                }
                // 짝수일때
                if(max_heap.size() == min_heap.size()){
                    if(middle < value)
                        max_heap.add(value);
                    else
                        min_heap.add(value);
                    continue;
                }
                // 최대 힙의 원소수가 많을때
                else if(max_heap.size() > min_heap.size())
                    target = max_heap.poll();
                else    // 최소 힙의 원소수가 많을때
                    target = min_heap.poll();

                // 재분배 실시
                int[] arr = new int[]{target, value, middle};
                Arrays.sort(arr);
                min_heap.add(arr[0]);
                middle = arr[1];
                max_heap.add(arr[2]);
                System.out.print(middle + " ");
            }
            System.out.println();
        }
    }
}