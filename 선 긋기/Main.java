import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] arr = new long[N][2];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // comparator
        Arrays.sort(arr, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2){
                return (int) (o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
            }
        });

        // lamda
        //Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        long start = arr[0][0], end = arr[0][1];
        long answer = 0;
        for(int i=1; i<=N; i++){
            if(i == N){
                answer += (end - start);
                break;
            }
            if(end >= arr[i][0]){
                end = Math.max(end, arr[i][1]);
            }
            else{
                answer += (end - start);
                start = arr[i][0];
                end = arr[i][1];
            }
        }
        System.out.println(answer);
    }
}