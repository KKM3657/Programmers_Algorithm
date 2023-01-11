import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int V;
    static StringBuilder sb;    // 문자열 저장하기 위한 StringBuilder
    // 수식의 결과 계산
    public static int calculate_value(String input){
        //수식을 구분자로 토큰화
        StringTokenizer st = new StringTokenizer(input, "+-", true);
        int total = Integer.parseInt(st.nextToken());   // 1부터 시작
        // 토큰이 남아있을때 까지
        while(st.hasMoreElements()){
            String a = st.nextToken();  // 연산자
            if(a.equals("+"))
                total += Integer.parseInt(st.nextToken());  // 숫자
            else
                total -= Integer.parseInt(st.nextToken());  // 숫자
        }
        return total;
    }
    // 백트래킹으로 0이 되는 수식 찾기
    public static void find_answer(int curr, int select){
        // 종료 조건
        if(curr == V*2){
            String sentence = (sb.toString()).replaceAll(" ", "");  // 공백 없애기
            int total = calculate_value(sentence);  // 수식 계산
            if(total == 0)
                System.out.println(sb.toString());  // 정답
            return;
        }
        // 연산자
        if(curr % 2 == 0){
            sb.append(" ");
            find_answer(curr+1, select);
            sb.deleteCharAt(sb.length()-1);

            sb.append("+");
            find_answer(curr+1, select);
            sb.deleteCharAt(sb.length()-1);

            sb.append("-");
            find_answer(curr+1, select);
            sb.deleteCharAt(sb.length()-1);

        } else{ // 숫자
            sb.append(String.valueOf(select));
            find_answer(curr+1, select+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sb = new StringBuilder();
        for(int t=0; t<T; t++) {
            V = sc.nextInt();
            find_answer(1,1);
            System.out.println();
        }
    }
}