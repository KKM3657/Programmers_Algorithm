import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=10;
        
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int i=0; i<N; i++) {
                arr[i] = sc.nextInt();
            }
            int answer = 0;
            for(int i=2; i<N-2; i++) {
                int curr = arr[i], temp = 255;
                for(int j=i-2; j<=i+2; j++) {
                    if(i == j)
                        continue;
                    temp = Math.min(curr-arr[j], temp);
                }
                answer += Math.max(temp, 0);
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}