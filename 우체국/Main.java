import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] arr = new long[N][2];
        long total_person = 0;  // 전체 인원
        // 입력
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
            total_person += arr[i][1];
        }
        // 거리에 대해서 정렬
        Arrays.sort(arr, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2){
                if(o1[0] < o2[0])
                    return -1;
                else if(o1[0] == o2[0])
                    return 0;
                else
                    return 1;
            }
        });
        long answer = 0, temp = 0;
        // 인원이 절반이 됐을때 우체국을 세워야 최소가 나옴
        for(int i=0; i<N; i++){
            temp += arr[i][1];
            if(temp >= ((total_person+1)/2)){
                answer = arr[i][0];
                break;
            }
        }
        System.out.println(answer);
    }
}