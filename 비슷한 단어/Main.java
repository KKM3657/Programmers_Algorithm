import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static int N, max = 0;
    static String[] words, answer;
    public static void find_two_words(int curr, int select){
        // 단어 두개 선택후 비교
        for(int i=0; i<N-1; i++){
            String first = words[i];
            for(int j=i+1; j<N; j++){
                String second = words[j];
                if(words[i].equals(words[j]))   // 같은 단어면 넘어가기
                    continue;
                int len = Math.min(first.length(), second.length()), temp = 0;
                for(int k=0; k<len; k++){
                    if(first.charAt(k) != second.charAt(k))
                        break;
                    temp++;
                }
                // 정답 갱신
                if(max < temp){
                    answer[0] = first;
                    answer[1] = second;
                    max = temp;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new String[N];
        answer = new String[2];

        for(int i=0; i<N; i++){
            words[i] = br.readLine();
        }

        find_two_words(0,0);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}