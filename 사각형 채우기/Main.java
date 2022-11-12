import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] DP = new int[num+1];

        DP[1] = 1;
        DP[2] = 2;

        for(int i = 3; i <= num; i++){
            DP[i] = (DP[i-1] + DP[i-2]) % 10007;
        }
        System.out.println(DP[num]);
    }
}