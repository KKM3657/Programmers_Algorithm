import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [] dxs = new int [] {1,0,-1,0};
    static int [] dys = new int [] {0,-1,0,1};
    public static int dir_find(char c){
        if(c == 'E')
            return 0;
        else if(c == 'W')
            return 2;
        else if(c == 'S')
            return 1;
        else
            return 3; 
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        

        int num = Integer.parseInt(st.nextToken());
        boolean answer = false;
        int cnt = 0;
        int x = 0;
        int y = 0;
        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            char direct = st.nextToken().charAt(0);
            int dis = Integer.parseInt(st.nextToken());
            int dir_num = dir_find(direct);

            for(int j = 0; j < dis; j++){
                int nx  = x + dxs[dir_num]; 
                int ny  = y + dys[dir_num];
                if(nx == 0 && ny == 0){
                    System.out.println(cnt + 1);
                    answer = true;
                    break;
                } else{
                    x = nx;
                    y = ny;
                    cnt += 1;
                }
            }
            if(answer)
                break;

        }
        if(!answer)
            System.out.println(-1);
    }
}