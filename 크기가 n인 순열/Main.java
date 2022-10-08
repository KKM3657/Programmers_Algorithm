import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    static int n;
    static int[] visited;
    static ArrayList<Integer> al = new ArrayList<>();
    // 답 출력
    public static void print_answer(){
        for(int value : al){
            System.out.print(value + " ");
        }
        System.out.println("");
    }
    // 백트래킹을 이용한 순열 구하기
    public static void choose(int curr_num){
        if(curr_num == n + 1){
            print_answer();
            return;
        }
        // 사전에 방문했다면 넘어감
        for(int i = 1; i<= n; i++){
            if(visited[i] == 1)
                continue;
            
            visited[i] = 1;
            al.add(i);
            choose(curr_num + 1);
            visited[i] = 0;
            al.remove(al.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        visited = new int[n+1];
        choose(1);
    }
}