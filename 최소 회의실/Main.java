import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];

        // 입력
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        // 강의 시작시간으로 초기화
        Arrays.sort(arr, (x, y) -> x[0]-y[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // 우선순위 큐

        pq.add(arr[0][1]);  // 시작점
        for(int i=1; i<N; i++){
            if(arr[i][0] >= pq.peek())  // 이전 강의가 끝난 경우 빼기
                pq.poll();
            pq.add(arr[i][1]);  // 끝나지 않으면 추가
        }
        System.out.println(pq.size());  // 최종결과
    }
}