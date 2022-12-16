import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for(int k=1; k<=t; k++){
            int answer1 = Integer.MIN_VALUE + 1;
            int answer2 = Integer.MIN_VALUE + 1;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] array1 = new int[n+1];
            int[] array2 = new int[n+1];
            int[] dp1 = new int[n+1];
            int[] dp2 = new int[n+1];
            int[] dp3 = new int[n+2];
            int[] dp4 = new int[n+2];

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                array1[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                array2[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<=n; i++){
                dp1[i] = Math.max(0, dp1[i-1]) + array1[i];
                dp2[i] = Math.max(0, dp2[i-1]) + array2[i];
            }

            for(int i=n; i>=1; i--){
                dp3[i] = Math.max(0, dp3[i+1]) + array1[i];
                dp4[i] = Math.max(0, dp4[i+1]) + array2[i];
            }

            answer1 = getAnswer1(answer1, n, dp1, dp4);

            answer2 = getAnswer1(answer2, n, dp2, dp3);
            System.out.printf("#%d %d\n",k,Math.max(answer1,answer2));
        }
    }

    private static int getAnswer1(int answer1, int n, int[] dp1, int[] dp4) {
        for(int i=1; i<n; i++){
            int value1 = dp1[i];
            int value2 = -1001;
            for(int j=n; j>i; j--){
                if(value2 < dp4[j])
                    value2 = dp4[j];
            }
            if(answer1 < value1 + value2)
                answer1 = value1 + value2;
        }
        return answer1;
    }
}
