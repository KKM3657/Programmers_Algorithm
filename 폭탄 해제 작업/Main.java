import java.util.Scanner;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> { 
    int timeLimit, score;
    public Pair(int timeLimit, int score) { 
        this.timeLimit = timeLimit; 
        this.score = score; 
    }
    @Override
    public int compareTo(Pair b) {
        if(timeLimit != b.timeLimit) return timeLimit - b.timeLimit;
        return score - b.score;
    }
}

public class Main {
    public static final int MAX_T = 10000;
    public static final int MAX_N = 10000;
    
    public static int n;
    public static Pair[] bombs = new Pair[MAX_N];
    
    
    public static int getTimeLimit(int bombIdx) {
        int timeLimit = bombs[bombIdx].timeLimit;
    
        return timeLimit;
    }
    
    public static int getScore(int bombIdx) {
        int score = bombs[bombIdx].score;
        
        return score;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int score = sc.nextInt();
            int timeLimit = sc.nextInt();
            bombs[i] = new Pair(timeLimit, score);
        }

        Arrays.sort(bombs, 0, n);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int bombIdx = n - 1;
        int ans = 0;

        for(int t = MAX_T; t >= 1; t--) {
            while(bombIdx >= 0 && getTimeLimit(bombIdx) >= t) {
                pq.add(-getScore(bombIdx));
                bombIdx--;
            }

            if(!pq.isEmpty()) {
                ans += -pq.poll();
            }
        }

        System.out.print(ans);
    }
}