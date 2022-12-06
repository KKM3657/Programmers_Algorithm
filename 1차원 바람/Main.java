import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {
    static int n, m, w_cnt;
    static int[][] grid;
    static String[] direct = new String[]{"L","R"}; // 방향을 나타내는 배열
    // 바람이 부는 방향으로 행 이동
    public static void move_value(int line, String dir){
        // 왼쪽으로 밀기
        if(dir.equals("L")){
            int value = grid[line][m-1];
            for(int i=m-1; i>0; i--){
                grid[line][i] = grid[line][i-1];
            }
            grid[line][0] = value;
        } 
        else{   // 오른쪽을 밀기
            int value = grid[line][0];
            for(int i=0; i<m-1; i++){
                grid[line][i] = grid[line][i+1];
            }
            grid[line][m-1] = value;
        }
    }
    // 바람이 불고 전파
    public static void wind_move(int start, String dir){
        boolean stop1 = true, stop2 = true;
        int r_dir;  // 반대 방향
        if(dir.equals("L"))
            r_dir = 1;
        else
            r_dir = 0;
        // 바람 불기
        move_value(start, dir);
        // 아랫방향으로 전파
        for(int i = start; i>=1; i--){
            for(int j=0; j<m; j++){
                // 전파 시도
                if(grid[i][j] == grid[i-1][j])
                    stop1 = false;
            }
            // 전파
            if(!stop1){
                move_value(i-1, direct[r_dir]);
                stop1 = true;
                if(direct[r_dir].equals("L"))
                    r_dir = 1;
                else
                    r_dir = 0;
            }
            else
                break;
        }
    
        if(dir.equals("L"))
            r_dir = 1;
        else
            r_dir = 0;
        // 윗 방향으로 전파
        for(int i = start; i<=n-2; i++){
            for(int j=0; j<m; j++){
                // 전파 시도
                if(grid[i][j] == grid[i+1][j])
                    stop2 = false;
            }
            if(!stop2){
                move_value(i+1, direct[r_dir]);
                stop2 = true;
                if(direct[r_dir].equals("L"))
                    r_dir = 1;
                else
                    r_dir = 0;
            }
            else
                break;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        w_cnt = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<w_cnt; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            String dir = st.nextToken();
            wind_move(start,dir);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

    }
}