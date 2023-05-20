import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
   public static void main(String args[]) throws Exception
   {
      
      Scanner sc = new Scanner(System.in);
      int T;
      T=sc.nextInt();

      for(int test_case = 1; test_case <= T; test_case++)
      {
         int N = sc.nextInt();
            int[] arr = new int[N];
            for(int i=0; i<N; i++){
               arr[i] = sc.nextInt();
            }
         long answer = 0, temp = arr[N-1];
            for(int i=N-1; i>=0; i--){
                temp = Math.max(temp, arr[i]);
                answer += (temp - arr[i]);
            }
            System.out.println("#" + test_case + " " + answer);
      }
   }
}