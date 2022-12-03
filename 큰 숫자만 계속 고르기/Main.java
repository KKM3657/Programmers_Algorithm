import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {    
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int n, m;
    public static int[] arr = new int[MAX_N];
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();  

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // priority queue에
        // 숫자들을 넣어줍니다.
        for(int i = 0; i < n; i++)
            pq.add(-arr[i]);

        // m번에 걸쳐서 
        // 최댓값을 찾아 1씩 빼주는 것을 반복합니다.
        while(m-- > 0) {
            // 최댓값을 찾아 제거합니다.
            int maxVal = -pq.poll();
            // 1을 뺀 뒤
            maxVal--;
            // 다시 넣어줍니다.
            pq.add(-maxVal);
        }

        System.out.print(-pq.peek());
    }
}