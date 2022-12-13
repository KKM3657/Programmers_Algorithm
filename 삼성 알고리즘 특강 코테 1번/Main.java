import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {
    static int n, answer;   // N, 정답
    static LinkedList<Integer> answer_list; // 숫자 리스트
    static int[] array; // 입력으로 받은 n개의 숫자
    static boolean[] visited;   // 방문 기록
    // 두수의 합이 어떤 정수의 제곱이 되는지 판별
    public static int cal_circle(){
        int cnt = 0;
        for(int i=0; i<n; i++){
            int a = answer_list.get(i), b = answer_list.get((i+1)%n);
            double value = Math.sqrt(a+b);  // 제곱근 구하기
            if(value == (int) value)    // 제곱근이 어떤 정수의 제곱이 되는지 판별
                cnt += 1;
        }
        return cnt;
    }
    // 완전탐색
    public static void find_answer(int select){
        if(select == n){    // n개의 숫자를 고를경우 거의 제곱 고리 판별
            int value = cal_circle();   // 거의 제곱 고리에 존재하는 제곱수 개수
            if(answer < value)
                answer = value;
            return;
        }
        // 주어진 숫자 완전 탐색
        for(int i=1; i<n; i++){ // 회전이 가능하므로 중복 제거
            if(visited[i])  // 방문했다면 넘어감
                continue;
            visited[i] = true;
            answer_list.add(array[i]);  // 선택한 경우
            find_answer(select+1);

            visited[i] = false; // 선택하지 않은 경우
            answer_list.remove(answer_list.size()-1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        // 테스트 케이스 t번 반복
        for(int i=1; i<=t; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            answer = 0;
            answer_list = new LinkedList<Integer>();
            array = new int[n];
            visited = new boolean[n];

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                array[j] = Integer.parseInt(st.nextToken());
            }
            // 초기 위치 설정
            visited[0] = true;
            answer_list.add(array[0]);
            find_answer(1);
            System.out.printf("#%d %d\n",i,answer);
        }
    }

}
