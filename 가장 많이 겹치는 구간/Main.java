import java.util.Scanner;

public class Main {    
    public static final int MAX_R = 200000;
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int n;
    public static int[] x1 = new int[MAX_N];
    public static int[] x2 = new int[MAX_N];
    public static int[] checked = new int[MAX_R + 1];
    
    public static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }
        
        for(int i = 0; i < n; i++) {
            checked[x1[i]]++;
            checked[x2[i]]--;
        }

        int overlappedCnt = 0;
        for(int i = 1; i <= MAX_R; i++) {
            overlappedCnt += checked[i];
            ans = Math.max(ans, overlappedCnt);
        }
        
        System.out.print(ans);
    }
}