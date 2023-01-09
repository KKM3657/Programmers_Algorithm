import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, answer = 0;
    static int[] L, J;
    public static void solution(int curr, int hp, int joy){
        // 체력이 남아있는 경우
        if(hp > 0){
            answer = Math.max(answer, joy); // 최대 행복
            if(curr == n)   // 순회 완료
                return;
            // 인사하기
            solution(curr+1, hp - L[curr], joy + J[curr]);
            // 인사하지 않고 넘어가기
            solution(curr+1, hp, joy);
        } else {
            return;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        L = new int[n];
        J = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            L[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            J[i] = Integer.parseInt(st.nextToken());

        solution(0, 100, 0);
        System.out.println(answer);
    }
}