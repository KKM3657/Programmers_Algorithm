import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    static int n;
    static int k;
    // ArrayList 생성
    static ArrayList<Integer> al = new ArrayList<>();
    // 출력
    public static void print_num(){
        for(int elen: al){
            System.out.print(elen + " ");
        }
        System.out.println("");
    }
    // 순서쌍 구하기
    public static void choose(int curr_num){
        if(curr_num == n + 1){  // 마지막 자리(k)
            print_num();
            return;
        }
        for(int i = 1; i <= k; i++){    // 순서쌍 구하기
            al.add(i);
            choose(curr_num + 1);
            al.remove(al.size()-1);
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        choose(1);
    }
}