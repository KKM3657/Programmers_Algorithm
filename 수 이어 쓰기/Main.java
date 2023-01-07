import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int curr = 0, answer = 0;   // 정답
        while(answer++ <= 30000){   // 3000까지 가능하므로 최대 30000개의 숫자 사용
            String temp = String.valueOf(answer);   // 숫자를 String으로 변환
            for(int i=0; i<temp.length(); i++){ // 변환한 숫자에 해당하는 글자가 있으면 다음 글자로 넘어감
                if(temp.charAt(i) == input.charAt(curr))
                    curr++;
                if(curr == input.length()){ // 탐색이 완료되면 정답 출력
                    System.out.println(answer);
                    System.exit(0);
                }
            }
        }
    }
}