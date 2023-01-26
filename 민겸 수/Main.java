import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
public class Main {
    // 구간 계산
    public static String calculate(String a, String oc) {
        // 한 글자인 경우
        if(a.length() == 1){
            if(a.equals("M"))
                return("1");
            else
                return("5");
        } else{
            StringBuilder sb = new StringBuilder();
            int m = a.length()-1;   // 마지막 글자
            if(a.charAt(m) == 'K'){ // 마지막 글자가 K인 경우
                sb.append("5");
                sb.append("0".repeat(m));
            }
            else{   // 마지막 글자가 M인 경우
                sb.append("1");
                if(oc.equals("max"))    // 최대인 경우 모두 1로 출력
                    sb.append("1".repeat(m));
                else                    // 최소인 경우 모두 0으로 출력
                    sb.append("0".repeat(m));
            }
            return sb.toString();
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "K", true);

        LinkedList<String> l = new LinkedList<>();
        // 구간 나누기
        while(st.hasMoreElements()){
            l.add(st.nextToken());
        }

        StringBuilder sb = new StringBuilder(), sb2 = new StringBuilder();
        StringBuilder answer = new StringBuilder(), answer2 = new StringBuilder();

        //최대 -> 결합 최대 + M을 1로 처리
        for(int i=0; i<=l.size(); i++) {
            if(i == l.size()){  // 남은 글자 계산
                if(sb.length() != 0)    // 있으면 계산
                    answer.append(calculate(sb.toString(), "max"));
                break;
            }
            if(l.get(i).equals("K")){   // K 기준으로 계산
                sb.append("K");
                answer.append(calculate(sb.toString(), "max"));
                sb.setLength(0);    // 초기화
            } else
                sb.append(l.get(i));    // 추가
        }

        //최소 -> 결합 최소
        for(int i=0; i<=l.size(); i++) {
            if(i == l.size()){  // 남은 글자 계산
                if(sb.length() != 0)    // 있으면 계산
                    answer2.append(calculate(sb2.toString(), "min"));
                break;
            }
            if(l.get(i).equals("K")){   //  K 기준으로 계산
                if(sb2.length() != 0){
                    answer2.append(calculate(sb2.toString(), "min"));
                    sb2.setLength(0);   // 초기화
                }
                answer2.append("5");    // K 계산
            } else
                sb2.append(l.get(i));
        }
        System.out.println(answer);
        System.out.println(answer2);
    }
}