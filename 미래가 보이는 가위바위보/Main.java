import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100000;
    
    public static int n;
    public static char[] matches = new char[MAX_N];
    
    public static int[] L = new int[MAX_N];
    public static int[] R = new int[MAX_N];
    public static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            matches[i] = sc.next().charAt(0);
            
        String shapes = new String("PHS");

        for(int s = 0; s < 3; s++) {
            char shape = shapes.charAt(s);
            int sameCnt = 0;
            for(int i = 0; i < n; i++) {
                if(matches[i] == shape)
                    sameCnt += 1;
                
                L[i] = Math.max(L[i], sameCnt);
            }
        }

        for(int s = 0; s < 3; s++) {
            char shape = shapes.charAt(s);
            int sameCnt = 0;
            for(int i = n - 1; i >= 0; i--) {
                if(matches[i] == shape)
                    sameCnt += 1;
                
                R[i] = Math.max(R[i], sameCnt);
            }
        }

        for(int i = 0; i < n - 1; i++)
            ans = Math.max(ans, L[i] + R[i + 1]);

        System.out.print(ans);
    }
}