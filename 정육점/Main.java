import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (x,y)->{
            return x[1] == y[1] ? y[0] - x[0] : x[1] - y[1];
        });
        if(arr[0][0] >= K) {
            System.out.println(arr[0][1]);
            return;
        }

        int price = -1;
        int gram = 0;
        int answer = Integer.MAX_VALUE;
        boolean isPossible = false;

        for (int i = 0; i < N; i++) {
            // 고기 구입
            gram += arr[i][0];
            // 이전과 같은 가격일 경우
            if (i > 0 && arr[i - 1][1] == arr[i][1]) {
                price += arr[i][1];
            } else {
                price = arr[i][1];
            }
            if (gram >= K) {
                isPossible = true;
                answer = Math.min(answer, price);
            }
        }
        if(isPossible)
            System.out.println(answer);
        else
            System.out.println(-1);
    }
}