import java.util.Scanner;
import java.util.LinkedList;
import java.util.PriorityQueue;
// 해당 숫자와 횟수 저장
class Pair implements Comparable<Pair>{
    int idx;
    int value;

    Pair(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }

    @Override
    public int compareTo(Pair p) {
        return this.value - p.value;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        LinkedList<Integer> answer = new LinkedList<>();

        int[] DP = new int[n+3];
        int[] prev = new int[n+3];
        DP[0] = Integer.MAX_VALUE;  // 0은 사용하지 않음
        prev[0] = 0;   // 0은 사용하지 않음
        
        // 탐색 시작
        for(int i=2; i<=n; i++) {
            // 1. 3으로 나눠 떨어질때
            if(i % 3 == 0)
                pq.add(new Pair(i/3, DP[i/3]));
            // 2. 2로 나눠 떨어질때
            if(i % 2 == 0)
                pq.add(new Pair(i/2, DP[i/2]));
            // 3. -1 할때
            pq.add(new Pair(i-1, DP[i-1]));

            // 최소 횟수 찾기 -> 우선순위 큐 사용
            Pair min = pq.poll();
            DP[i] = min.value + 1;
            prev[i] = min.idx; // 이전 시행 저장
            pq.clear(); // 초기화
        }
        // 1인 경우
        if(n == 1){
            System.out.println(0);
            System.out.print(1);
            System.exit(0);
        }
        // 1 이상인 경우
        int k = n;
        System.out.println(DP[n]);
        System.out.print(n + " ");
        while(prev[k] != 1){    // 출력
            System.out.print(prev[k] + " ");
            k = prev[k];
        }
        System.out.print(1);
    }
}