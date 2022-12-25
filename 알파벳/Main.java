import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main{
    static int n, m, max_cnt;
    static String[][] arr;

    static boolean[] alphabet = new boolean[26];
    static Stack<String> answer_list = new Stack<>();
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    public static boolean in_range(int x, int y){
        return 0<= x && x < n && 0<= y && y < m;
    }
    public static void dfs(int curr_x, int curr_y, int cnt){
        if(max_cnt < cnt) {
            max_cnt = cnt;
        }
        for(int i=0; i<4; i++){
            int next_x = curr_x + dx[i], next_y = curr_y + dy[i];
            if(in_range(next_x,next_y) && !alphabet[arr[next_x][next_y].charAt(0) - 'A']){
                answer_list.add(arr[next_x][next_y]);
                alphabet[arr[next_x][next_y].charAt(0) - 'A'] = true;
                dfs(next_x,next_y, cnt+1);

                answer_list.pop();
                alphabet[arr[next_x][next_y].charAt(0) - 'A'] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new String[n][m];
        for(int i=0; i<n; i++){
            arr[i] = br.readLine().split("");
        }

        max_cnt = 1;
        alphabet[arr[0][0].charAt(0) - 'A'] = true;
        answer_list.add(arr[0][0]);
        dfs(0,0, 1);
        System.out.println(max_cnt);
    }
}