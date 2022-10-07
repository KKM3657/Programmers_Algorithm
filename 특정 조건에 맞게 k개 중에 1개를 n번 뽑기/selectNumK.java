import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static int k;
    static int n;
    static ArrayList<Integer> al = new ArrayList<>();
    
    // 숫자 출력
    public static void print_array(){
        for(int num : al){
            System.out.print(num + " ");
        }
        System.out.println("");
    }

    // 재귀함수를 이용한 백 트래킹
    public static void choose_n(int curr_num){
        if(curr_num == n){
            print_array();
            return;
        }
        // 3자리 숫자가 같은 경우 넘어감
        for(int i = 1 ; i <= k ; i++){
            if((curr_num >= 2) && (al.get(al.size() - 1) == i && al.get(al.size() - 2) == i)){
               continue;
            }
            al.add(i);
            choose_n(curr_num + 1);
            al.remove(al.size()-1);
        }    
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        choose_n(0);
    }
}