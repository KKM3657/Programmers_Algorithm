import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static int n;
    static int answer;
    static ArrayList<Integer> al = new ArrayList<>();

    // 아름다운 수 판별
    public static boolean is_Beautiful(){
        // 해당 수만큼 개수가 있는지 판별
        for(int i = 0; i < n; i += al.get(i)){
            // 해당 개수 만큼 구간 설정
            if(i + al.get(i) - 1 >= n)
                return false;
            // 구간 안에서 다른 수가 있는지 확인
            for(int j = i; j < i + al.get(i); j++)
                if(al.get(j) != al.get(i))
                    return false;
        }
        return true;
        
    }
    // 재귀함수를 이용한 행복한 수열 찾기
    public static void happy_count(int curr_n){
        // 만든 수열이 행복한 수열인지 판단
        if(curr_n == n){
            if(is_Beautiful()){
                answer++;
            }
            return;
        }
        // 행복한 수열 만들기
        for(int i = 1; i < 5; i++){
            al.add(i);
            happy_count(curr_n+1);
            al.remove(al.size()-1);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        happy_count(0);
        System.out.println(answer);    
    }
}