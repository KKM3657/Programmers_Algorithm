import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {
    static int n,m,k,answer;
    static int[][] grid;    // 격자점
    static int[] wind_x = new int[]{0,0,-1,1}, wind_y = new int[]{-1,1,0,0};    // 동서남북 풍
    static LinkedList<Integer> selected_wind;   // 선택한 바람
    // 격자점 내부의 점인지 판별
    public static boolean in_range(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < m;
    }
    // 바람에 따른 사람 이동
    public static void wind_sum(int x, int y, int dir, int[][]temp){
        int value = temp[x][y];
        int next_x = x + wind_x[dir], next_y = y + wind_y[dir]; // 다음으로 이동할 지점
        if(in_range(next_x,next_y)){    // 격자점 내부의 점인지 판별
            temp[x][y] = 0;
            temp[next_x][next_y] = temp[next_x][next_y] + value;    // 사람 이동
        }
        else    // 이동 불가
            temp[x][y] = value;
    }
    // 완전탐색 최대 인원 찾기 
    public static int find_maxP(){
        int max = 0;
        int[][] temp = new int[n][m];
        // 임시 배열에서 실시
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++)
                temp[i][j] = grid[i][j];
        }
        // 선택한 바람에 따라 사람 이동
        for(Integer dir : selected_wind){
            if(dir == 0){   // 동풍(동->서)
                for(int i=0; i<n; i++){
                    for(int j=m-1; j>=0; j--){
                        if(temp[i][j] == 0)
                            continue;
                        wind_sum(i,j,dir,temp);
                        break;
                    }
                }
            }
            else if(dir == 1){  // 서풍(서->동)
                for(int i=0; i<n; i++){
                    for(int j=0; j<m; j++){
                        if(temp[i][j] == 0)
                            continue;
                        wind_sum(i,j,dir,temp);
                        break;
                    }
                }
            }
            else if(dir == 2){  // 남풍(남->북)
                for(int j=0; j<m; j++){
                    for(int i=n-1; i>=0; i--){
                        if(temp[i][j] == 0)
                            continue;
                        wind_sum(i,j,dir,temp);
                        break;
                    }
                }
            }
            else if(dir == 3){  // 북풍(북->남)
                for(int j=0; j<m; j++){
                    for(int i=0; i<n; i++){
                        if(temp[i][j] == 0)
                            continue;
                        wind_sum(i,j,dir,temp);
                        break;
                    }
                }
            }
        }
        // 최대 사람 구역 탐색
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++)
                max = Math.max(max, temp[i][j]);
        }
        return max;
    }
    // 백트래킹을 이용한 탐색
    public static void find_answer(int select){
        // k개의 바람 선택
        if(select == k){
            int value = find_maxP();
            // 각 경우에서 최대가 정답이 되는지 판별
            if(answer < value)
                answer = value;
            return;
        }
        // 백트래킹(중복 허용)
        for(int i=0; i<4; i++){
            selected_wind.add(i);
            find_answer(select+1);

            selected_wind.remove(selected_wind.size()-1);
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
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            selected_wind = new LinkedList<>();
            answer = 0;

            grid = new int[n][m];
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                for(int l=0; l<m; l++)
                    grid[j][l] = Integer.parseInt(st.nextToken());
            }
            // 초기 위치 설정
            find_answer(0);
            System.out.printf("#%d %d\n",i,answer);
        }

    }

}
