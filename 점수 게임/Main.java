import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(map.containsKey(num)){
                int value = map.get(num);
                map.put(num, value+1);
            } else{
                map.put(num, 1);
            }
        }
        int m_size = map.size();
        Integer[][] arr = new Integer[m_size][2];
        int idx = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            arr[idx][0] = entry.getKey();
            arr[idx][1] = entry.getValue();
            idx++;
        }

        int[] DP = new int[m_size];
        DP[0] = arr[0][0] * arr[0][1];
        for(int i=1; i<m_size; i++){
            int sub = arr[i-1][0] - arr[i][0];
            if(i == 1){
                if(sub > 1){
                    DP[i] = arr[i][0] * arr[i][1] + DP[i-1];
                }
                else{
                    DP[i] = Math.max(arr[i][0] * arr[i][1], DP[i-1]);
                }
                continue;
            }
            if(sub > 1){
                DP[i] = DP[i-1] + arr[i][0] * arr[i][1];
            }
            else{
                DP[i] = Math.max(DP[i-2]+(arr[i][0] * arr[i][1]), DP[i-1]);
            }
        }
        System.out.println(DP[m_size-1]);
    }
}