import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class Pair {
    int x1, x2;
    public Pair(int x1, int x2) { 
        this.x1 = x1; 
        this.x2 = x2; 
    }
}

class Tuple implements Comparable<Tuple> { 
    int x, v, index;
    public Tuple(int x, int v, int index) { 
        this.x = x; 
        this.v = v;
        this.index = index; 
    }
    @Override
    public int compareTo(Tuple b) {
        if(x != b.x) return x - b.x;
        if(v != b.v) return v - b.v;
        return index - b.index;
    }
}

public class Main {
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int n;
    public static Pair[] segments = new Pair[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            segments[i] = new Pair(x1, x2);
        }   

        ArrayList<Tuple> points = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            int x1 = segments[i].x1;
            int x2 = segments[i].x2;
            points.add(new Tuple(x1, +1, i)); // 시작점
            points.add(new Tuple(x2, -1, i)); // 끝점
        }

        Collections.sort(points);

        HashSet<Integer> segs = new HashSet<>();

        int ans = 0; // 구간 크기의 합을 저장합니다.
        int startX = -1; // 현재 합쳐진 구간의 시작 x값을 기록해줍니다.
        for(int i = 0; i < 2 * n; i++) {
            int x = points.get(i).x;
            int v = points.get(i).v;
            int index = points.get(i).index;

            if(v == +1) {
                if((int) segs.size() == 0)
                    startX = x;    
                
                segs.add(index);
            }

            else {
                segs.remove(index);
                if((int) segs.size() == 0) {
                    int endX = x;
                    ans += endX - startX;
                }
            }
        }
        
        System.out.println(ans);
    }
}