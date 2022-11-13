import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Solution {
    public static int[] solution(String[] logs){
        int[] answer = new int[24]; // 시간별 로그
        for (String log : logs) {
            StringTokenizer st = new StringTokenizer(log, " :/");
            for (int j = 0; j < 3; j++)
                st.nextToken();
            int hour = (Integer.parseInt(st.nextToken()) + 9) % 24; // 시간 계산
            answer[hour] += 1;
            System.out.println("hour = " + hour);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[13];    // 로그 저장을 위한 배열
        for (int i = 0; i < 13; i++) {
            array[i] = br.readLine();
        }
        int[] answer = solution(array);
        System.out.println(Arrays.toString(answer));
    }
}
