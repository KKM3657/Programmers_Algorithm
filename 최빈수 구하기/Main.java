import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int test_num = sc.nextInt();
            Map<Integer, Integer> map = new HashMap<>(); 
            for(int i=0; i<1000; i++){
                int score = sc.nextInt();
                if(map.containsKey(score))
                   map.put(score, map.get(score)+1);
                else
                   map.put(score, 1);
            }
            List<Integer> listKeySet = new ArrayList<>(map.keySet());
            Collections.sort(listKeySet, new Comparator<Integer>(){
                @Override
                public int compare(Integer v1, Integer v2){
                    if(map.get(v1) == map.get(v2)){
                        return v2 - v1;
                    }
                    else{
                        return map.get(v2) - map.get(v1);
                    }
                }
            });
            System.out.println("#" + test_case + " " + listKeySet.get(0));
        }
    }
}