import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
    static HashMap<Integer, String> hashMap = new HashMap<>();
    public static void add(int k, String v){
        hashMap.put(k,v);
    }
    public static String find(int k){
        if(hashMap.containsKey(k))
            return hashMap.get(k);
        return "None";
    }
    public static void remove(int k){
        hashMap.remove(k);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String func = st.nextToken();
            if(func.equals("add")){
                int k = Integer.parseInt(st.nextToken());
                String v = st.nextToken();
                add(k, v);
            }
            else if(func.equals("find")){
                int k = Integer.parseInt(st.nextToken());
                System.out.println(find(k).toString());
            }
            else if(func.equals("remove")){
                int k = Integer.parseInt(st.nextToken());
                remove(k);
            }
        }
    }
}