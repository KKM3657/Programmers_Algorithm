import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.PriorityQueue;
// 좌표를 나타내는 클래스
class Pair{
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N, M, answer = Integer.MAX_VALUE;
    static ArrayList<Pair> home = new ArrayList<>();    // 집 위치
    static ArrayList<Pair> chicken = new ArrayList<>(); // 치킨집 위치
    static LinkedList<Pair> pick = new LinkedList<>();  // 선택한 치킨집
    // 치킨집과 집 거리 계산
    public static int cal_distance() {
        int total = 0;  // 도시의 전체 거리
        for(Pair house : home) {    // 모든 집
            PriorityQueue<Integer> temp = new PriorityQueue<>(); // 최소 거리를 구하기 위한 우선순위 큐
            for(Pair store : pick) { // 선택한 치킨집
                int distance = Math.abs(house.x - store.x) + Math.abs(house.y - store.y); // 선택한 치킨집과 집 사이 거리 구하기
                temp.add(distance);
            }
            total += temp.poll();   // 최소가 되는 거리 합
            temp.clear();
        }
        return total;
    }
    // 치킨집 고르기
    public static void pick_chicken(int curr, int select) {
        // M개의 치킨집을 고른 경우
        if(select == M) {
            answer = Math.min(answer, cal_distance());
            return;
        }
        // 치킨집 순회 완료
        if(curr == chicken.size()){
            return;
        }
        //해당 치킨집 선택
        pick.add(chicken.get(curr));
        pick_chicken(curr+1, select+1);

        //해당 치킨집 선택 안함
        pick.remove(pick.size() - 1);
        pick_chicken(curr+1, select);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 치킨집, 집 입력
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if(value == 1)
                    home.add(new Pair(i, j));
                else if(value == 2)
                    chicken.add(new Pair(i, j));
            }
        }

        pick_chicken(0, 0);
        System.out.println(answer);
    }
}