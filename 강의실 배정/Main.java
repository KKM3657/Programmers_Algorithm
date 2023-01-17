import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;
// 강의 시작, 끝을 저장하기 위한 클래스
class Pair implements Comparable<Pair>{
    int start;
    int end;

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
    // 객체 정렬
    @Override
    public int compareTo(Pair o) {
        return this.end - o.end;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // 우선순위 큐

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        // 강의의 시작 시간을 기준으로 정렬(람다식 사용)
        Arrays.sort(arr, (a, b) -> {
            return a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1];
        });

        int answer = 1;
        pq.add(new Pair(arr[0][0], arr[0][1])); // 첫 번째 시간 넣기

        for(int i=1; i<n; i++) {
            if(arr[i][0] >= pq.peek().end)  // 강의가 끝나고 강의실이 빈 경우
                pq.poll();
            pq.add(new Pair(arr[i][0], arr[i][1])); // 강의가 진행 중이여서 새로운 강의실 추가
        }
        System.out.println(pq.size());
    }
}