import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Main {
    static int n, m; 
    static HashMap<String, Integer> answer_map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        // 입력
        for(int i=0; i<n; i++){
            String input = br.readLine();
            if(input.length() < m)
                continue;
            // 중복 처리
            Integer count = answer_map.getOrDefault(input, 0);
            answer_map.put(input, count+1);
        }
        // 모든 키, 값 가져오기
        List<Entry<String, Integer>> answer = new ArrayList<>(answer_map.entrySet());
        // comparator로 분류
        Collections.sort(answer, new Comparator<Entry<String, Integer>>(){
            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
                int c1 = obj1.getValue();   // 단어 빈도1
                int c2 = obj2.getValue();   // 단어 빈도2
                if(c1 == c2){   // 조건 1: 단어 빈도 비교
                    // 조건 2: 단어 길이 비교
                    if(obj1.getKey().length() == obj2.getKey().length())
                        return obj1.getKey().compareTo(obj2.getKey());
                    else
                        // 조건 3: 알파벳 순서 비교
                        return obj2.getKey().length() - obj1.getKey().length();
                }
                else
                    return c2 - c1;
			}
        });
        for(int i=0; i<answer.size(); i++)
            bw.write(answer.get(i).getKey()+"\n");
        bw.flush();   
    }
}