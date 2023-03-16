import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] arr = new int[T][2];
        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            arr[t][0] = Integer.parseInt(st.nextToken());
            arr[t][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] != o2[0] ? o1[0]-o2[0] : o1[1] - o2[1];
            }
        });

        LinkedList<Integer> answer = new LinkedList<>();
        for(int i=1; i<=N; i++){
            answer.add(i);
        }
        for(int i=1; i<=N; i++){
            for(int j=0; j<T; j++){
                if(i == arr[j][1]){
                    for(int idx=0; idx<N; idx++){
                        if(answer.get(idx) == arr[j][0]) {
                            int pos = answer.indexOf(i);
                            if(pos == -1)
                                continue;
                            answer.remove(pos);
                            answer.add(idx, i);
                        }
                    }
                }
            }
        }
        for(Integer value : answer){
            System.out.print(value + " ");
        }
    }
}