import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
// 좌표를 나타내기 위한 클래스
class Pair{
    int x;
    int y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int n;
    static int[][] grid;
    static int max = 0; // 최대 폭발 범위
    static ArrayList<Pair> al = new ArrayList<>();  // 폭발물 좌표
    static ArrayList<Integer> bomb = new ArrayList<>(); // 폭발 종류
    // 폭발물에 따른 폭발하는 땅 좌표
    static int[][] bomb_x = {{-2,-1,1,2},
                            {-1,0,1,0},
                            {-1,1,1,-1}};

    static int[][] bomb_y = {{0,0,0,0},
                            {0,1,0,-1},
                            {1,1,-1,-1}};
    // 격자점 내 범위 판별
    public static boolean in_range(int x, int y){
        return 0<= x && x<n && 0<= y && y<n;
    }
    // 폭발하는 땅 위치 확인
    public static int find_ground(){
        int[][] new_grid = new int[n][n];
        int cnt = 0;    // 폭발 범위
        for(int idx = 0; idx < al.size(); idx++){
            Pair curr = al.get(idx);    // 폭발물 좌표 
            int kx = curr.x, ky = curr.y;
            if(new_grid[kx][ky] == 0)
                cnt++;
            new_grid[kx][ky] = bomb.get(idx);
            // 폭발하는 땅 좌표 확인
            for(int j=0; j<4; j++){
                int dxs = kx + bomb_x[bomb.get(idx)-1][j], dys = ky + bomb_y[bomb.get(idx)-1][j];
                if(in_range(dxs, dys) && new_grid[dxs][dys] == 0){
                    cnt++;
                    new_grid[dxs][dys] = -1;
                }
            }
        }
        return cnt;
    }
    // 백트레킹으로 폭발물 선택
    public static void find_bomb(int curr){
        if(curr == al.size()){
            int cnt = find_ground();
            max = max > cnt ? max : cnt;
            return;
        }
        for(int i = 1; i <= 3; i++){
            bomb.add(i);
            find_bomb(curr+1);
            bomb.remove(bomb.size()-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        grid = new int[n][n];

        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j< n; j++){
                int k = Integer.parseInt(st.nextToken());
                grid[i][j] = k;
                if(k == 1)
                    al.add(new Pair(i,j));
            }
        }
        find_bomb(0);
        System.out.println(max);
    }
}