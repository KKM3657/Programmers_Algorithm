import java.util.Scanner;
import java.util.Arrays;

class Candy implements Comparable<Candy> {
    int x, cnt;

    public Candy(int x, int cnt) {
        this.x = x;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Candy c) {
        return this.x - c.x;        // x 기준 오름차순 정렬
    }
}

public class Main {
    public static final int MAX_N = 100000;
    
    
    public static Candy[] candies = new Candy[MAX_N + 1];
    public static int n, k;
    
    public static int getPosOfCandy(int candyIdx) {
        return candies[candyIdx].x;
    }
    
    public static int getNumOfCandy(int candyIdx) {
        return candies[candyIdx].cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            int cnt = sc.nextInt();
            int x = sc.nextInt();
            candies[i] = new Candy(x, cnt);
        }

        Arrays.sort(candies, 1, n + 1);

        int ans = 0;
        
        int totalNums = 0;
        int j = 0;
        for(int i = 1; i <= n; i++) {
            while(j + 1 <= n && getPosOfCandy(j + 1) - getPosOfCandy(i) <= 2 * k) {
                totalNums += getNumOfCandy(j + 1);
                j++;
            }
            
            ans = Math.max(ans, totalNums);
            totalNums -= getNumOfCandy(i);
        }
        System.out.print(ans);
    }
}