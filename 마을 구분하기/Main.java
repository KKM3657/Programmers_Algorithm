import java.io.*;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Collections;
public class Main {
    static int[][] area;    // 영역을 표시한 격자점
    static int[][] visited;    // 영역을 확인하기 위한 배열
    static int[] dx = new int[]{0,1,0,-1};  // 다음으로 이동할 지점 배열
    static int[] dy = new int[]{1,0,-1,0};  // 다음으로 이동할 지점 배열
    static int lines, cnt;

    // 격자 내부의 점인지 판별
    public static boolean in_range(int x, int y){
        return  0 <= x && x < lines && 0 <= y && y < lines;
    }
    // 영역 확인을 위한 완전탐색
    public static void find_all_area(int curr_x, int curr_y){
        for(int i=0; i<4; i++){
            int next_x = curr_x + dx[i], next_y = curr_y + dy[i];   // 다음으로 이동할 지점
            // 격자 내부의 점인지 판별, 다음으로 이동할 점이 해당 영역의 점인지 확인 및 중복인지 판별
            if(in_range(next_x, next_y) && area[next_x][next_y] == 1 && visited[next_x][next_y] == 0){
                cnt += 1; // 영역 + 1
                visited[next_x][next_y] = 1;   // 해당 점 방문
                find_all_area(next_x, next_y);  // 다음 지점으로 이동
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        lines = Integer.parseInt(br.readLine());
        LinkedList<Integer> answer_array = new LinkedList<>();
        area = new int[lines][lines];
        visited = new int[lines][lines];
        // 영역 초기화
        for(int i=0; i<lines; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < lines; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 격자점을 탐색하면서 영역 확인
        for(int i = 0; i<lines; i++){
            for(int j = 0; j<lines; j++){
                // 이미 방문했거나 해당 영역이 아니면 넘어감
                if(area[i][j] == 0 || visited[i][j] == 1){
                    continue;
                }
                cnt = 1;    // 처음 시작
                visited[i][j] = 1;
                find_all_area(i,j); // 영역 찾기
                answer_array.add(cnt);  // 탐색한 영역의 넓이를 리스트에 저장
            }
        }
        Collections.sort(answer_array); // 리스트 정렬
        System.out.println(answer_array.size());
        for (Integer integer : answer_array) {
            System.out.println(integer);
        }
    }
}