import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, min = Integer.MAX_VALUE;
    static int[][][] DP = new int[61][61][61];
    static int[][] attack = new int[][]{{9,3,1},{9,1,3},{3,9,1},{3,1,9},{1,9,3},{1,3,9}};
    public static void dfs(int[] scv, int cnt){
        if(min <= cnt)
            return;
        // 이미 지나간 경로
        if(DP[scv[0]][scv[1]][scv[2]] != 0 && DP[scv[0]][scv[1]][scv[2]] <= cnt)
            return;
        // 공격 시행    
        DP[scv[0]][scv[1]][scv[2]] = cnt;
        
        // 모두 죽은 경우 종료
        if(scv[0] == 0 && scv[1] == 0 && scv[2] == 0) {
            min = Math.min(min, cnt);
            return;
        }
        // 체력 깍기
        for(int i=0; i<6; i++) {
            dfs(new int[] {Math.max(scv[0] - attack[i][0], 0),Math.max(scv[1] - attack[i][1], 0),Math.max(scv[2] - attack[i][2], 0)}, cnt+1);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] scv = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<N; i++){
            scv[i] = Integer.parseInt(st.nextToken());
        }

        dfs(scv, 0);

        System.out.println(min);
    }
}