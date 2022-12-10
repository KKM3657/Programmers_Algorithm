import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<Integer, Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int value = Integer.parseInt(st.nextToken());
            // 중복된 값이 있는지 판별
            if(!map.containsKey(value))
                map.put(value, 1);
            // 중복된 값이라면 갱신
            else
                map.put(value, map.get(value) + 1);
        }

        st = new StringTokenizer(br.readLine());
        // 조회
        for(int i=0; i<m; i++){
            int value = Integer.parseInt(st.nextToken());
            if(map.containsKey(value))
                System.out.print(map.get(value) + " ");
            else
                System.out.print("0" + " ");
        }
    }
}