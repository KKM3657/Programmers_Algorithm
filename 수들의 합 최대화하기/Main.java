import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
// 좌표를 나타내기 위한 클래스
class Pair{
    int x;
    int y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int n;
    static int[][] grid;
    static int[] visited;
    static int answer = 0;
    static LinkedList<Pair> answer_list = new LinkedList<>();
    // 선택한 점들의 합 구하기
    public static int cal_new(){
        int sum = 0;
        for(Pair curr : answer_list){
            int x = curr.x, y = curr.y;
            sum += grid[x][y];
        }
        return sum;
    }
    // 백트래킹으로 순회하면서 가능한 점들을 탐색
    public static void find_max_answer(int curr){
        // n개의 점을 선택완료 후 최대값인지 판별
        if(curr == n){
            answer = Math.max(answer, cal_new());
            return;
        }
        // 선택한 점을 제외한 가능한 곳 판별
        for(int i=0; i<n; i++){
            if(visited[i] == 1) // 이미 선택한 적이 있으면 넘어감
                continue;
            visited[i] = 1;
            answer_list.add(new Pair(curr, i)); // 선택한 점이 무엇인지 저장
            find_max_answer(curr+1);    // 다음 선택으로 넘어감
            visited[i] = 0; // 이전 상태로 되돌림
            answer_list.remove(answer_list.size()-1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        visited = new int[n];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        find_max_answer(0); // curr를 행으로 생각하고 선택시 행+1
        System.out.println(answer);
    }
}