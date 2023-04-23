import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static final int MAX_N = 100000;
    
    public static int n, k;
    public static int[] arr = new int[MAX_N + 1];
    
    public static HashMap<Integer, Integer> countArray = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();
        int ans = 0;

        int j = 0;
        for(int i = 1; i <= n; i++) {
            while(j + 1 <= n && countArray.getOrDefault(arr[j + 1], 0) < k) {
                countArray.put(arr[j + 1], countArray.getOrDefault(arr[j + 1], 0) + 1);
                j++;
            }

            ans = Math.max(ans, j - i + 1);
            countArray.put(arr[i], countArray.get(arr[i]) - 1);
        }

        System.out.print(ans);
    }
}