import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int n, k;
    public static String word;
    public static HashMap<Character, Integer> countArray = new HashMap<>();
    
    public static int ans;             
    public static int distinctNumber;
    public static boolean canMove(int j) {
        if(j + 1 > n)
            return false;
        
        if(distinctNumber == k && countArray.getOrDefault(word.charAt(j + 1), 0) == 0)
            return false;
        
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        word = sc.next();
        k = sc.nextInt();
        n = word.length();
        word = "#" + word;
        
        distinctNumber = 0;
        int j = 0;
        for(int i = 1; i <= n; i++) {
            while(canMove(j)) {
                char c = word.charAt(j + 1);
                countArray.put(c, countArray.getOrDefault(c, 0) + 1);
                if(countArray.getOrDefault(c, 0) == 1)
                    distinctNumber++;
                j++;
            }
            
            ans = Math.max(ans, j - i + 1);
            countArray.put(word.charAt(i), countArray.get(word.charAt(i)) - 1);
            if(countArray.get(word.charAt(i)) == 0)
                distinctNumber--;
        }

        System.out.print(ans);
    }
}