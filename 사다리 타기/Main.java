import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
// 격자점을 나타내기 위한 클래스
class Pair{
    int x, y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int n, m;
    static int answer_min = 16; // 정답
    static LinkedList<Pair> line_list = new LinkedList<>(); // 가로 줄 리스트
    static int[] origin;    // 사다리 게임의 원래 정답
    static boolean[] selected;  // 가로 줄 선택 배열
    // 두 정답이 동일한지 판별
    public static boolean isEqual(int[] answer_array, int[]temp_array){
        for(int i=1; i<=n; i++){
            if(answer_array[i] != temp_array[i])
                return false;
        }
        return true;
    }
    // 사다리 게임 정답 찾기
    public static void find_result(int[][] lines, int[] answer){
        // 모든 세로 줄 탐색
        for(int i=1; i<=n; i++){
            int idx = 1, next = i;  // 초기위치 초기화
            // 높이가 16줄까지 탐색
            while(idx <16){
                // 해당 교점 뒤에 가로줄이 있으면 오른쪽으로 이동
                if(lines[idx][next] == 1)
                    next++;
                // 해당 교점 앞에 가로줄이 있으면 왼쪽으로 이동
                else if(lines[idx][next-1] == 1)
                    next--;
                idx++;  // 밑으로 이동
            }
            answer[next] = i;   // 정답 저장
        }
    }
    // 완점탐색으로 최소 개수의 가로 줄 탐색
    public static void solution(int curr, int select){
        // 모든 가로 줄 순회
        if(curr == m){
            int[][] new_lines = new int[16][n+1];
            int[] new_answer = new int[n+1];
            // 선택한 가로 줄을 배열로 변환
            for(int i=0; i<m; i++){
                if(selected[i]){
                    Pair pair = line_list.get(i);
                    new_lines[pair.x][pair.y] = 1;
                }
            }
            // 선택한 가로 줄로 사다리 타기 실시
            find_result(new_lines, new_answer);
            // 사다리 타기 결과가 원래 정답과 같은지 비교
            if(isEqual(origin, new_answer)){
                if(answer_min > select)
                    answer_min = select;
            }
            return;
        }
        // 해당 가로 줄을 선택
        selected[curr] = true;
        solution(curr+1, select+1);
        // 해당 가로 줄을 선택하지 않음
        selected[curr] = false;
        solution(curr+1, select);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] lines = new int[16][n+1];   // 전체 가로 줄
        origin = new int[n+1];  // 원 사다리 타기의 결과
        selected = new boolean[m];  // 해당 가로 줄을 선택했는지 판별하기 위한 배열
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            lines[b][a] = 1;    // 가로 줄 반영
            line_list.add(new Pair(b,a));   // 리스트 형태로 가로 줄 반영
        }
        find_result(lines, origin); // 원 사다리 타기 실시

        solution(0,0);  // 완전탐색 실시
        System.out.println(answer_min);
    }
}