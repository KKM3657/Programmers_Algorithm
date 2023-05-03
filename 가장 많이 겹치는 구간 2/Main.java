import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Pair implements Comparable<Pair> { 
    int first, second;
    public Pair(int first, int second) { 
        this.first = first; 
        this.second = second; 
    }
    @Override
    public int compareTo(Pair b) {
        if(first != b.first) return first - b.first;
        return second - b.second;
    }
}

public class Main {
    public static final int MAX_N = 100000;
    
    
    public static int n;
    public static ArrayList<Pair> segments = new ArrayList<>();
    
    public static int ans;
    
    public static ArrayList<Pair> points = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            segments.add(new Pair(x1, x2));
        }
        
        for(int i = 0; i < n; i++) {
            int x1 = segments.get(i).first;
            int x2 = segments.get(i).second;
            points.add(new Pair(x1, +1)); // 시작점
            points.add(new Pair(x2, -1)); // 끝점
        }

        Collections.sort(points);

        int sumVal = 0;
        for(int i = 0; i < 2 * n; i++) {
            int x = points.get(i).first;
            int v = points.get(i).second;

            sumVal += v;

            ans = Math.max(ans, sumVal);
        }
        
        System.out.print(ans);
    }
}