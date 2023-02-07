import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
// 좌표 클래스
class Pair{
    int x;
    int y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N, answer = Integer.MAX_VALUE;
    static int[][] grid, temp;
    static boolean[][] selected;    //선택
    static LinkedList<Pair> p = new LinkedList<>();
    static int[] dx = new int[]{0,0,1,0,-1}, dy = new int[]{0,1,0,-1,0};    // 자기자신, 동서남북
    // 비용 계산 메소드
    public static int total_cost(){
        int result = 0;
        for(Pair pair : p){
            result += temp[pair.x][pair.y];
        }
        return result;
    }
    // 지점 선택하기
    public static void find_answer(int curr_x, int curr_y, int select) {
        if(select == 3){    // 3개 지점 선택 완료
            answer = Math.min(answer, total_cost());
            return;
        }
        if(curr_x == N-1 || curr_y == N-1){ // 격자점 외부이면 리턴
            return;
        }
        // y좌표가 N-2가 아니면 그 가로줄을 순회
        if(curr_y != N-2){
            // 구간이 겹치지 않으면 선택 가능
            if(!selected[curr_x][curr_y] && !selected[curr_x+1][curr_y] && !selected[curr_x-1][curr_y]
                    && !selected[curr_x][curr_y+1] && !selected[curr_x][curr_y-1]) {
                // 선택한 경우
                p.add(new Pair(curr_x, curr_y));
                for (int i = 0; i < 5; i++) selected[curr_x + dx[i]][curr_y + dy[i]] = true;
                find_answer(curr_x, curr_y + 1, select + 1);
                // 선택 복구
                p.remove(p.size()-1);
                for(int i=0; i<5; i++) selected[curr_x + dx[i]][curr_y + dy[i]] = false;
            }
            // 선택하지 않는 경우
            find_answer(curr_x, curr_y+1, select);
        }
        else{   // y좌표가 N-2면 세로줄로 줄 바꿈
            // 구간이 겹치지 않으면 선택 가능
            if(!selected[curr_x][curr_y] && !selected[curr_x+1][curr_y] && !selected[curr_x-1][curr_y]
                    && !selected[curr_x][curr_y+1] && !selected[curr_x][curr_y-1]) {
                // 선택한 경우
                p.add(new Pair(curr_x, curr_y));
                for (int i = 0; i < 5; i++) selected[curr_x + dx[i]][curr_y + dy[i]] = true;
                find_answer(curr_x + 1, 1, select + 1);
                // 선택 복구
                p.remove(p.size() - 1);
                for (int i = 0; i < 5; i++) selected[curr_x + dx[i]][curr_y + dy[i]] = false;
            }
            // 선택하지 않는 경우
            find_answer(curr_x+1, 1, select);
        }
    }
    public static void cal_cost(){
        // 값 구하기
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int value = 0;
                for(int k=0; k<5; k++) {    // 5방향 합 구하기
                    int nx = i + dx[k], ny = j + dy[k];
                    if(0 > nx || nx >= N || 0 > ny || ny >= N){ // 격자점을 벗어나면 -1
                        value = -1;
                        break;
                    }
                    value += grid[nx][ny];
                }
                temp[i][j] = value;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        temp = new int[N][N];
        selected = new boolean[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cal_cost();
        find_answer(1,1,0);
        System.out.println(answer);
    }
}