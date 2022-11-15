import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static int[] arr;
    static int[] select;
    static int[] dx_k;
    static int answer = 0;
    public static void find_max_score(int idx, int point){
        // 끝점에 도달할때
        if(idx == n){
            answer = answer < point ? point : answer;
            return;
        }
        // 다음으로 이동할 곳
        int move = arr[idx];
        // 말 선택해서 움직임
        for(int i = 1; i <= k; i++){
            if(dx_k[i] >= m-1 && k == 1){   // 말이 하나인 경우 도달하면 끝
                answer = 1;
                return;
            }
            if(dx_k[i] >= m-1){ // 이미 말이 도착점에 도달한 경우 넘어감
                continue;
            }
            int next_dx = dx_k[i] + move;
            if(next_dx >= m-1){ // 점수가 추가되는 경우
                int prev = dx_k[i];
                dx_k[i] = m-1;
                find_max_score(idx+1, point+1);
                dx_k[i] = prev;          
            } else{ // 다음 이동으로 넘어감
                dx_k[i] = next_dx;
                find_max_score(idx+1, point);
                dx_k[i] -= move;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        dx_k = new int[k+1];
        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<n; i++){
           arr[i] = Integer.parseInt(st.nextToken());
        }

        find_max_score(0, 0);
        System.out.println(answer);
    }
}