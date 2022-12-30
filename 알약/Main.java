import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] DP = new long[31];
        DP[0] = 1;
        DP[1] = 1;
        DP[2] = 2;
        for(int i=3; i<=30; i++){
            for(int j=0; j<i; j++)
		// 반개를 먹거나 한개를 먹는 경우의 수 생각
                DP[i] += DP[j] * DP[i-j-1];
        }
        while(true){
            int n = sc.nextInt();
            if(n == 0)
                break;
            System.out.println(DP[n]);
        }
    }
}