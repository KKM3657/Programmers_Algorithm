import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100000;
    
    public static int n;
    public static String word;
    
    public static long L[] = new long[MAX_N];
    public static long R[] = new long[MAX_N];
    public static long ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        word = sc.next();

        L[0] = (word.charAt(0) == 'C' ? 1 : 0);
        for(int i = 1; i < n; i++)
            L[i] = L[i - 1] + (word.charAt(i) == 'C' ? 1 : 0);

        R[n - 1] = (word.charAt(n - 1) == 'W' ? 1 : 0);
        for(int i = n - 2; i >= 0; i--)
            R[i] = R[i + 1] + (word.charAt(i) == 'W' ? 1 : 0);

        for(int i = 1; i < n - 1; i++)
            if(word.charAt(i) == 'O')
                ans += L[i - 1] * R[i + 1];

        System.out.print(ans);
    }
}