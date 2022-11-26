import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static final int NUM_LEN = 3;
    
    public static int n;
    public static ArrayList<Integer> series = new ArrayList<>();
    public static int[] numbers = new int[]{4, 5, 6};
    
    public static boolean isEqual(int start1, int end1, int start2, int end2) {
        for(int i = 0; i <= end1 - start1; i++) {
            if(series.get(start1 + i) != series.get(start2 + i))
                return false;
        }
        return true;
    }
    
    public static boolean isPossibleSeries() {
        int len = 1;
        while(true) {
            int end1 = series.size() - 1, start1 = end1 - len + 1;
            int end2 = start1 - 1, start2 = end2 - len + 1;
    
            if(start2 < 0)
                break;
    
            if(isEqual(start1, end1, start2, end2))
                return false;
    
            len++;
        }
        return true;
    }
    
    public static void findMinSeries(int cnt) {
        if(cnt == n) {
            for(int i = 0; i < series.size(); i++)
                System.out.print(series.get(i));
            System.exit(0);
        }    
        for(int i = 0; i < NUM_LEN; i++) {
            series.add(numbers[i]);
            if(isPossibleSeries())
                findMinSeries(cnt + 1);
            
            series.remove(series.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        findMinSeries(0);
    }
}