import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {
    static int n, m;
    static LinkedList<Integer> li = new LinkedList<>();
    static int[] array;
    static boolean[] visited;
    static int answer = 0;
    public static void find_max_value(int curr, int select){
        // m개를 선택완료한 경우
        if(select == m){
            int value = 0;
            for(int i = 0; i<m; i++){
                value ^= li.get(i);
            }
            if(value > answer)
                answer = value;
            return;
        }
        // 모든 정수 순회
        if(curr == n)
            return;
        // 해당 정수를 선택한 경우
        li.add(array[curr]);
        find_max_value(curr+1, select+1);
        
        // 해당 정수를 선택하지 않는 경우
        li.remove(li.size()-1);
        find_max_value(curr+1, select);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        find_max_value(0,0);
        System.out.println(answer);
    }
}