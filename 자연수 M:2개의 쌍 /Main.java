import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Pair implements Comparable<Pair> {
    int y, x;
    Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public int compareTo(Pair p) {
        return this.y - p.y;        // y 기준 오름차순으로 정렬합니다.
    }
}

public class Main {    
    // 변수 선언
    public static int n;
    public static ArrayList<Pair> nums = new ArrayList<>();
    
    public static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            nums.add(new Pair(y, x));
        }

        Collections.sort(nums);

        int li = 0, ri = n - 1;
        while(li <= ri) {
            int ly = nums.get(li).y;
            int lx = nums.get(li).x;
            int ry = nums.get(ri).y;
            int rx = nums.get(ri).x;

            ans = Math.max(ans, ly + ry);

            if(lx < rx) {
                nums.set(ri, new Pair(ry, rx - lx));
                li++;
            }
            else if(lx > rx) {
                nums.set(li, new Pair(ly, lx - rx));
                ri--;
            }
            else {
                li++;
                ri--;
            }
        }
        System.out.print(ans);
    }
}