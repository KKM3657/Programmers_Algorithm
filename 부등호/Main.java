import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    static long n, max_value = Long.MIN_VALUE, min_value = Long.MAX_VALUE;
    static String max_result, min_result;
    static ArrayList<String> arr = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] selected = new boolean[10];    // 숫자 중복사용 확인
    // 부등호 결과 판별 메소드
    public static boolean is_possible(int idx, long prev, long next){
        String operator = arr.get(idx);
        if(operator.equals(">")){
            if(prev > next)
                return true;
        } else{
            if(prev < next)
                return true;
        }
        return false;
    }
    // 백트래킹으로 가능한 숫자 찾기
    public static void find_answer(long prev, int curr){
        // 모든 부등호 사용
        if(curr == n){
            long value = Long.parseLong(sb.toString());
            // 조건을 만족하는 최대값
            if(max_value < value){
                max_value = value;
                max_result = sb.toString();
            }
            // 조건을 만족하는 최소값
            if(min_value > value){
                min_value = value;
                min_result = sb.toString();
            }
            return;
        }
        // 가능한 숫자 탐색
        for(int i=0; i<10; i++){
            // 중복 사용 넘어감
            if(selected[i])
                continue;
            // 조건을 만족하면 선택
            if(is_possible(curr, prev, i)){
                selected[i] = true;
                sb.append(i);
                find_answer(i, curr+1);
                
                // 선택하지 않는 경우
                selected[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr.add(st.nextToken());
        }

        for(int i=0; i<=9; i++){
            selected[i] = true;
            sb.append(i);
            find_answer(i,0);
            
            selected[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }
        System.out.println(max_result);
        System.out.println(min_result);
    }
}