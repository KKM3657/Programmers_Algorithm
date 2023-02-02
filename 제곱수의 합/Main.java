import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] DP = new int[1000001];
        DP[1] = 1;
        // 경우 탐색
        for(int i=2; i<1000001; i++) {
            double value = Math.sqrt(i);    // 제곱근 구하기
            if(value == (int) Math.sqrt(i)){    // 제곱근이 정수이면 1
                DP[i] = 1;
            } else {
                DP[i] = DP[i-1]+1;
                for(int j=2; j<=(int)value; j++) {  // 최소 갯수의 제곱근 합 구하기
                    DP[i] = Math.min(DP[i], DP[i-(j*j)]+1);
                }
            }
        }
        System.out.println(DP[N]);
    }
}