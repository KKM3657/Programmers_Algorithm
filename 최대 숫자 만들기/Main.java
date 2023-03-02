import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main {    
    public static final int MAX_N = 50000;
    
    public static int n;
    public static Integer[] arr = new Integer[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr, 0, n, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String s1 = Integer.toString(a) + Integer.toString(b);
                String s2 = Integer.toString(b) + Integer.toString(a);
                return s2.compareTo(s1);
            }
        });

        for(int i = 0; i < n; i++)
            System.out.print(arr[i]);
    }
}