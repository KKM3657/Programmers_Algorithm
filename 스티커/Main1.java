// 완전탐색
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n, answer = 0;
    public static void find_answer(int curr, int prev, int value) {
        if(curr == n) {
            answer = Math.max(answer, value);
            return;
        }
        // 선택x
        if(prev == 0){
            find_answer(curr+1, 1, value + arr[0][curr]);
            find_answer(curr+1, 2, value + arr[1][curr]);
        } else {
            if(prev == 1)
                find_answer(curr+1, 2, value + arr[1][curr]);
            else
                find_answer(curr+1, 1, value + arr[0][curr]);

            find_answer(curr+1, 0, value);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            arr = new int[2][n];

            for(int i=0; i<2; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            find_answer(1,0,0);
            find_answer(1,1,arr[0][0]);
            find_answer(1,2,arr[1][0]);
            System.out.println(answer);
        }
    }
}