import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dx = new int[][] {{0,0},{1,-1},{1,-1},{1,-1}}, dy = new int[][] {{1,-1},{1,-1},{0,0},{-1,1}};
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 19;
        int[][] grid = new int[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0, rx = Integer.MAX_VALUE, ry = Integer.MAX_VALUE;
        // 전체 탐색
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int cx = i, cy = j;
                if(grid[i][j] == 0)
                    continue;
                //8방향 확인
                for(int k=0; k<4; k++) {
                    int cnt = 1;
                    for(int p=0; p<2; p++){
                        int nx = cx, ny = cy;
                        //오목인지 확인
                        do{
                            nx = nx + dx[k][p];
                            ny = ny + dy[k][p];
                            //System.out.println(nx + " " + ny);
                            //판을 벗어남
                            if(0 > nx || nx >= N || 0 > ny || ny >= N)
                                break;
                            if(grid[nx][ny] != grid[cx][cy])
                                break;
                            cnt++;
                        }while(true);
                    }
                    if(cnt == 5) {
                        result = grid[cx][cy];
                        if(ry >= cy){
                            if(ry == cy){
                                if(rx > cx){
                                    rx = cx;
                                }
                            }
                            else{
                                rx = cx;
                                ry = cy;
                            }
                        }
                    }
                }
            }
        }
        if(result == 0) {
            System.out.println(0);
        }
        else {
            System.out.println(result);
            System.out.printf("%d %d\n",rx+1, ry+1);
        }
    }
}