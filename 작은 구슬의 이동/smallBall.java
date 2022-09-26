import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
    static int n;

    static boolean isRange(int x, int y){
        return (0 <= x && x < n && 0 <= y && y < n);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] dxs = new int[] {0,1,-1,0};
        int[] dys = new int[] {1,0,0,-1};

        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;
        char dir_letter = (st.nextToken()).charAt(0);
        int dir_num = 0;
        
        if(dir_letter == 'U')
            dir_num = 2;
        else if(dir_letter == 'D')
            dir_num = 1;
        else if(dir_letter == 'R')
            dir_num = 0;
        else 
            dir_num = 3;

        for(int i = 0; i< time; i++){
            int nx = x + dxs[dir_num];
            int ny = y + dys[dir_num];

            if(!isRange(nx,ny))
                dir_num = 3 - dir_num;
            else{
                x = nx;
                y = ny;
            }            
        }

        System.out.println((x+1) + " " + (y+1));
    }


}