import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static ArrayList<Integer> al = new ArrayList<>();
    // 출력
    static void print_array(){
        for(int value : al){
            System.out.print(value + " ");
        }
        System.out.println("");
    }
    // 재귀함수를 이용한 백트래킹 
    static void choose(int curr_num, int num){
        if(curr_num == m){
            print_array();
            return;
        }
        // 전에 선택한 숫자를 제외한 나머지 수에서 선택
        for(int i = num; i <= n; i++){
            al.add(i);
            choose(curr_num+1, i+1);
            al.remove(al.size()-1);
        }
        
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        choose(0, 1);
    }
}