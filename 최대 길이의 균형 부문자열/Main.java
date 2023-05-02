import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = input.length(), longest = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0; i<N; i++){
            int value = input.charAt(i) - '0';
            if(value == 0)
                count += 1;
            else
                count -= 1;
            if(map.containsKey(count))
                longest = Math.max(longest, i - map.get(count));
            else
                map.put(count, i);
        }

        System.out.println(longest);
    }
}