import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;

    public static boolean inRange(int x, int y) {
		return(0 <= x && x < n && 0 <= y && y < n);
	}

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] dx = new int[]{1, 0, -1, 0};  
	int[] dy = new int[]{0, -1, 0, 1};
		
        n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                
                int cnt = 0;
                for(int dirNum = 0; dirNum< 4; dirNum++){
                    int nx = i + dx[dirNum], ny = j + dy[dirNum];
                    if(inRange(nx,ny) && arr[nx][ny] == 1){
                        cnt += 1;
                    }
                }
                if(cnt >= 3)
                    count++;
            }
        }
        System.out.println(count);
    }
}
