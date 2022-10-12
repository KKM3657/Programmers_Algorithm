import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] memo;
    // 재귀함수를 이용한 dp
    public static int fibbo(int num){
        if(memo[num] != 0)
            return memo[num];
        if(num <= 2){
            return memo[num] = 1;
        } else{
            memo[num] = fibbo(num-1) + fibbo(num-2);
        }

        return memo[num];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        memo = new int[n+1];
        int[] memo2 = new int[n+1];
        fibbo(n);
        // 반복문을 이용한 dp
        for(int i = 1; i<=n; i++){
            if(i <= 2){
                memo2[i] = 1;
            } else{
                memo2[i] = memo2[i-1] + memo2[i-2];
            }
        }

        //System.out.println(memo[n]);
        System.out.println(memo2[n]);
    }
}