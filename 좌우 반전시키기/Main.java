import java.util.Scanner;

public class Main {    
    public static final int MAX_N = 100;
    
    public static int n;
    public static int[] arr = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int ans = 0;
        for(int i = 1; i < n; i++) {
            if(arr[i - 1] == 0) {
                ans++;
                arr[i - 1] = 1;
                arr[i] ^= 1;
                if(i + 1 < n)
                    arr[i + 1] ^= 1;
            }
        }

        if(arr[n - 1] == 0)
            ans = -1;

        System.out.print(ans);
    }
}