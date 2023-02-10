import java.util.Scanner;

public class Main {    
    public static final int MAX_R = 100000;
    public static final int MAX_N = 100000;
    
    public static int n;
    public static int[] arr = new int[MAX_N + 1];
    public static int[] countArray = new int[MAX_R + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();

        int ans = 0;
        
        int j = 0;
        for(int i = 1; i <= n; i++) {
            while(j + 1 <= n && countArray[arr[j + 1]] != 1) {
                countArray[arr[j + 1]]++;
                j++;
            }
            
            ans = Math.max(ans, j - i + 1);
            countArray[arr[i]]--;
        }

        System.out.print(ans);
    }
}