import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
// 민혁이의 시행결과
class Pair {
    String[] v;
    int s;
    int b;

    Pair(String[] v, int s, int b) {
        this.v = v;
        this.s = s;
        this.b = b;
    }
}
public class Main {
    static int N, answer = 0;
    static LinkedList<Pair> ll = new LinkedList<>(); // 민혁의 시행결과 저장
    static boolean[] visited = new boolean[10]; // 볼을 확인하기 위한 배열
    // 숫자야구 게임 시행
    public static void solution_find(int[] arr, int curr) {
        // 모든 시행 후 정답 반환
        if(curr == N){
            answer++;
            return;
        }
        Pair p = ll.get(curr); // 현재 시행
        int s = 0, b = 0;   // 시행 결과
        for(int i=0; i<3; i++){
            int value = Integer.parseInt(p.v[i]); // 해당 숫자
            if(arr[i] == value) // 스트라이크 확인
                s++;
            else if(visited[value]) // 볼 확인
                b++;
        }
        if(p.s == s && p.b == b) { // 결과를 만족하면 다음 시행으로 넘어감
            solution_find(arr, curr+1);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        // 입력
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] v = st.nextToken().split("");
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ll.add(new Pair(v,s,b));
        }
        // 숫자 찾기
        for(int i=1; i<10; i++) {
            for(int j=1; j<10; j++) {
                for(int k=1; k<10; k++){
                    if(i==j || j==k || k==i) // 중복 제외
                        continue;
                    // 시행
                    visited[i] = true;
                    visited[j] = true;
                    visited[k] = true;
                    int[] value = new int[]{i,j,k};
                    solution_find(value,0);
                    // 초기화
                    visited[i] = false;
                    visited[j] = false;
                    visited[k] = false;
                }
            }
        }
        System.out.println(answer);
    }
}