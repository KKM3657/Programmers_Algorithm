import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] DP0 = new long[n+1]; // 마지막 숫자가 0으로 끝나는 경우
        long[] DP1 = new long[n+1]; // 마지막 숫자가 1으로 끝나는 경우
        // 초기화
        DP0[1] = 0;
        DP1[1] = 1;

        for(int i=2; i<=n; i++){
            DP0[i] = DP0[i-1] + DP1[i-1];   // 00로 끝나는 경우 + 10로 끝나는 경우
            DP1[i] = DP0[i-1];  // 01로 끝나는 경우
        }
        System.out.println(DP0[n]+ DP1[n]);
    }
}