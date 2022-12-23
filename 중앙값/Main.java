import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Main {
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int t, m;
    public static int[] arr = new int[MAX_N];
    
    public static void findMedian() {
        int median = arr[0];
        PriorityQueue<Integer> maxPq = new PriorityQueue<>();
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        System.out.print(median + " ");
    
        for(int i = 1; i < m; i++) {
            if(i % 2 == 1) {
                if(arr[i] < median)
                    maxPq.add(-arr[i]);
                else
                    minPq.add(arr[i]);
            }
            else {
                // Step 1. 
                // 먼저 maxPq, minPq 중 개수가 1개 더 많은 쪽에
                // 있는 곳에서 우선순위가 가장 큰 값을 뽑아줍니다.
                // 이를 newCand라 하겠습니다.
                int newCand;
                if(maxPq.size() > minPq.size())
                    newCand = -maxPq.poll();
                else 
                    newCand = minPq.poll();
    
                int[] nums = new int[]{median, arr[i], newCand};
                Arrays.sort(nums);
                
                maxPq.add(-nums[0]);
                median = nums[1];
                minPq.add(nums[2]);
                
                System.out.print(median + " ");
            }
        }
        
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while(t-- > 0) {
            m = sc.nextInt();
            for(int i = 0; i < m; i++)
                arr[i] = sc.nextInt();

            findMedian();
        }
    }
}