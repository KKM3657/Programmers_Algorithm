import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3], maxDp = new int[N][3], minDp = new int[N][3];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<3; i++){
            maxDp[0][i] = arr[0][i];
            minDp[0][i] = arr[0][i];
        }


        for(int i=1; i<N; i++){
            for(int j=0; j<3; j++){
                //0번째
                if(j==0){
                    //최대
                    maxDp[i][0] = Math.max(maxDp[i-1][0], maxDp[i-1][1]) + arr[i][0];
                    //최소
                    minDp[i][0] = Math.min(minDp[i-1][0], minDp[i-1][1]) + arr[i][0];
                }
                // 1번째
                else if(j==1){
                    //최대
                    maxDp[i][1] = Math.max(maxDp[i-1][0], maxDp[i-1][1]) + arr[i][1];
                    maxDp[i][1] = Math.max(maxDp[i][1], maxDp[i-1][2] + arr[i][1])  ;
                    //최소
                    minDp[i][1] = Math.min(minDp[i-1][0], minDp[i-1][1]) + arr[i][1];
                    minDp[i][1] = Math.min(minDp[i][1], minDp[i-1][2] + arr[i][1]) ;
                }
                // 2번째
                else{
                    //최대
                    maxDp[i][2] = Math.max(maxDp[i-1][1], maxDp[i-1][2]) + arr[i][2];
                    //최소
                    minDp[i][2] = Math.min(minDp[i-1][1], minDp[i-1][2]) + arr[i][2];
                }
            }
        }
        int answer1 = Integer.MIN_VALUE, answer2 = Integer.MAX_VALUE;
        for(int i=0; i<3; i++){
            answer1 = Math.max(answer1, maxDp[N-1][i]);
            answer2 = Math.min(answer2, minDp[N-1][i]);
        }
        System.out.println(answer1 + " " + answer2);
    }
}