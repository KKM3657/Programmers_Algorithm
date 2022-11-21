import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> array = new LinkedList<>();
        LinkedList<Integer> sub = new LinkedList<>();
        int n = st.countTokens();
        for(int i=0; i<n; i++){
            array.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(array);
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for(int i=1; i<array.size(); i++){
           int value = array.get(i) - array.get(i-1);
           sub.add(value);
           if(value < min){
               min = value;
               idx = i;
           }
        }
        System.out.println(array.get(idx-1) + " " + array.get(idx));
    }
}