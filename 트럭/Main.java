import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 트럭수
        int W = Integer.parseInt(st.nextToken());   // 다리 길이
        int L = Integer.parseInt(st.nextToken());   // 무게 제한

        Queue<Integer> truck = new LinkedList<>();  // 트럭
        Queue<Integer> road = new LinkedList<>();   // 다리

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }
        // 다리를 0으로 초기화
        for(int i=0; i<W; i++) {
            road.add(0);
        }

        int sum = 0, time = 0;
        while(!road.isEmpty()) {    // 다리가 빌때까지 반복
            sum -= road.poll(); // 다리에 앞부분에서 나오기
            if(!truck.isEmpty()) {  // 트럭을 이동하기 전에 판별
                if(sum + truck.peek() <= L) {   // 최대 무게를 넘어가지 않으면 다리로 이동
                    int value = truck.poll();
                    road.add(value);
                    sum += value;
                }
                else {  // 무게를 넘어가면 버블를 넣어 기다림
                    road.add(0);
                }
            }
            time++;
        }
        System.out.println(time);
    }
}